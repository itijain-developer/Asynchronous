package cdi;

import javax.ejb.EJB;
//import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import cdi.service.EventAnnotation;
import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Log;
import cdi.service.Mode;
import cdi.service.PaymentFilter;
import requestScope.Waiter;

@Log
public class ConsumerClass {
	
	static Logger logger= LoggerFactory.getLogger(ConsumerClass.class);

	private ImageFilter imageFilter;
	private TimeLogger time;
	
	@Inject 
	private PaymentFilter pf;
	
	@EJB 
	private Waiter joe;
	
	@Inject
	ConsumerClass(@ImageType(desiredMode = Mode.PNG) ImageFilter imageFilter,TimeLogger timeLogger){
		this.imageFilter=imageFilter;
		this.time=timeLogger;
	}
	
	
	
	public String openFileFromClient(String fileName) {
		logger.info("Image filter to string: " + imageFilter.toString());
		String output= imageFilter.openFile(fileName)+ " at " + time.getTime();
		pf.getPayment();
		//AnotherClass anotherClass = new AnotherClass();
		//joe.orderSoup("Manchow");
		//EventSource eventSource = new EventSource();
		//eventSource.callEvent(3);
		return output;
	}
	
	/*
	public static void onEvent(MyEvent myEvent) {
		logger.info("observed event with num: " + myEvent.eventNum);
	}
	*/
	/*
	public void onEvent(@Observes MyEvent myEvent) {
		logger.info("observed event with num: " + myEvent.eventNum);
	}
	*/
	
}
