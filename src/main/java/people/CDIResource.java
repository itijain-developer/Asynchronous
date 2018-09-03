package people;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.spi.Context;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ManagedAsync;

import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Mode;

import java.lang.reflect.Type;


@RequestScoped
@Path("/cdi")
public class CDIResource {

	@Inject 
	BeanManager bm;
	
	@Inject
	@ImageType(desiredMode = Mode.PNG) ImageFilter imageFilter;
	
	public CDIResource() {
		
	}
	

	@Path("{lastname}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@ManagedAsync
	public void getLastName(@PathParam("lastname") String lastname, @Suspended AsyncResponse asyncResponse) {
		String responeString = "lastname! " + lastname;
		//asyncResponse.resume(Response.ok().entity(responeString).build());
		asyncResponse.resume(responeString);
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		Context context = bm.getContext(ApplicationScoped.class);
		 Set<Bean<?>> beans = bm.getBeans(CDIResource.class);
		 Bean bean = bm.resolve(beans);
		 Type type = (Type) bean.getTypes().iterator().next();
		 System.out.println(imageFilter.toString());
		return "Hello world!";
	}
	

}
