package people;


import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.jboss.weld.environment.se.Weld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Server {
	private static Weld weld;
	//private static WeldContainer container;
	//private static HttpServer grizzlyserver;
	
	private static final URI ADDRESS = UriBuilder.fromPath("http://localhost:2000").build();
	static Logger logger = LoggerFactory.getLogger(Server.class);

	public Server() {
		
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.packages("people");
		resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		
		/*
		resourceConfig.register(new AbstractBinder() {
		    @Override
		    protected void configure() {
		        bind(ValidatorClass.class).to(ValidatorInterface.class);
		       // bind(ConsumerClass.class).to(ConsumerClass.class);
		    }
		});
		*/
		GrizzlyHttpServerFactory.createHttpServer(ADDRESS, resourceConfig);
		
	}


	public static void main(String[] args) throws InterruptedException {
		weld = new Weld();
		weld.initialize();
		//container = weld.initialize();
		
		//@SuppressWarnings("unused")
		//Resource weldResource= container.select(Resource.class).get();
		
		//logger.info(weldResource.callConsumerClass());
		
		//@SuppressWarnings("unused")
		//Server server = new Server();
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.packages("people");
		resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		GrizzlyHttpServerFactory.createHttpServer(ADDRESS, resourceConfig);

		
		//ConsumerClass client= container.select(ConsumerClass.class).get();
		//logger.info(client.openFileFromClient("file 1"));
		
		//logger.info("Task Completed. Shutting down Weld");
		//server.weld.shutdown();
		//grizzlyserver.shutdownNow();
	}

	// public void initWebGrizzly(@Observes ContainerInitialized init) {}

}	


