package people;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ManagedAsync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.DataIntegrityValidation;
import bean.People;
import cdi.AnotherClass;
import cdi.ConsumerClass;

//@RequestScoped
@Path("/api")
public class Resource {

	static Logger logger = LoggerFactory.getLogger(Resource.class);

	// @Inject
	// private Executor executor;
	@Inject
	ValidatorInterface val;
	@Inject
	ConsumerClass c;
	@Inject 
	AnotherClass ac;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getPeople")
	public Response getPeople() {
		People person = val.getSampleBean();

		Set<ConstraintViolation<People>> violations = val.validate(person);
		if (violations.size() > 0) {
			logger.info("Running Validations");
			logger.info(violations.toString());

			final Map<String, String> errorResponse = violations.stream()
					.collect(Collectors.toMap(o -> o.getPropertyPath().toString(), o -> o.getMessage()));

			return Response.status(Response.Status.BAD_REQUEST).entity(new DataIntegrityValidation(errorResponse))
					.build();

		}
		logger.info(callConsumerClass());
		ac.sayHello();
		
		return Response.ok().entity(person).build();
	}

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("getNumAsync")
	@ManagedAsync
	public void getNumAsyn(@Suspended final AsyncResponse asyncResponse) {
		CompletableFuture<Boolean> testA = CompletableFuture.supplyAsync(() -> true);
		CompletableFuture<Boolean> testB = CompletableFuture.supplyAsync(() -> true);
		CompletableFuture<Boolean> testC = CompletableFuture.supplyAsync(() -> true);


		
		testA.thenCombine(testB, (a,b) -> a && b ).thenCombine(testC, (a,b) -> a && b)
		.thenApply(result -> asyncResponse.resume("validation success" + result));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getPeopleAsync")
	@ManagedAsync
	public void getPeopleAsyn(@Suspended final AsyncResponse asyncResponse) {
		/*
		 * String result= val.getSampleExpensiveBean();
		 * asyncResponse.resume(result);
		 */
		/*
		 * CompletableFuture.runAsync(() ->{ People p=
		 * val.getSampleExpensiveBean();
		 * asyncResponse.resume(Response.ok().entity(p).build()); });
		 */

		/*
		 * CompletableFuture.supplyAsync(val::getSampleExpensiveBean)
		 * .thenApply(result ->
		 * asyncResponse.resume(Response.ok().entity(result).build())) ;
		 */
		
		CompletableFuture.supplyAsync(Resource::returnGetResponse)
		.thenApplyAsync(result -> asyncResponse.resume(result))
		.exceptionally(e -> asyncResponse
				.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build()));

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ManagedAsync
	@Path("peopleAsync")
	public void updatePeopleAsync(@Suspended final AsyncResponse asyncResponse, People request) {
		 String initialThread = Thread.currentThread().getName();
		 System.out.println("Initial thread: " + initialThread);
		 
		CompletableFuture.supplyAsync(() -> returnUpdateResponse(request))
		.thenApply(result -> asyncResponse.resume(result))
		.exceptionally(e -> asyncResponse
				.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build()));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("people")
	public Response updatePeople(People request) {
		 String processingThread = Thread.currentThread().getName();
		 System.out.println("Processing thread: " + processingThread);
		People person = new People();
		person.setName(request.getName());
		person.setAge(request.getAge());
		person.setAddress(request.getAddress());
		person.setTelNumbers(request.getTelNumbers());

		Set<ConstraintViolation<People>> violations = val.validate(person);
		if (!violations.isEmpty()) {
			final Map<String, String> errorResponse = violations.stream()
					.collect(Collectors.toMap(s -> s.getPropertyPath().toString(), s -> s.getMessage()));
			return Response.status(Response.Status.BAD_REQUEST).entity(new DataIntegrityValidation(errorResponse))
					.build();
		}
		final Map<String, String> successResponse = new HashMap<String, String>();
		successResponse.put("message", "success");
		return Response.ok(new DataIntegrityValidation(successResponse)).build();

	}

	private static Response returnGetResponse() {
		People person = ValidatorClass.getSampleExpensiveBean();
		Set<ConstraintViolation<People>> violations = ValidatorClass.validateStatic(person);
		Response r;
		if (violations.size() > 0) {

			final Map<String, String> errorResponse = violations.stream()
					.collect(Collectors.toMap(o -> o.getPropertyPath().toString(), o -> o.getMessage()));
			r = Response.status(Response.Status.BAD_REQUEST).entity(new DataIntegrityValidation(errorResponse)).build();
		}
		r = Response.ok().entity(person).build();
		return r;
	}

	private static Response returnUpdateResponse(People request) {

		People person = new People();
		person.setName(request.getName());
		person.setAge(request.getAge());
		person.setAddress(request.getAddress());
		person.setTelNumbers(request.getTelNumbers());

		Set<ConstraintViolation<People>> violations = ValidatorClass.validateStatic(person);
		Response r;
		if (violations.size() > 0) {

			final Map<String, String> errorResponse = violations.stream()
					.collect(Collectors.toMap(o -> o.getPropertyPath().toString(), o -> o.getMessage()));
			r = Response.status(Response.Status.BAD_REQUEST).entity(new DataIntegrityValidation(errorResponse)).build();
		}
		r = Response.ok().entity(person).build();
		return r;
	}

	
	public String callConsumerClass() {
		String output= c.openFileFromClient("file 1");
		return output;
	}
}
