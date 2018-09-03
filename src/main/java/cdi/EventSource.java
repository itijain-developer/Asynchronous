package cdi;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cdi.service.EventAnnotation;

public class EventSource {
	static Logger logger = LoggerFactory.getLogger(EventSource.class);

	@Inject
	@EventAnnotation
	private Event<MyEvent> event;

	public String callEvent(int numberOfEvents) {

			MyEvent myEvent = new MyEvent(numberOfEvents);
			logger.info("Generating Event: " + myEvent.eventNum);
			event.fire(myEvent);
			//ConsumerClass.onEvent(myEvent);	
		return "Finished. Generated " + numberOfEvents + " events.";
	}
	public void onEvent(@Observes @EventAnnotation MyEvent eventObserved) {
		logger.info("observed event with num: " );
	}
}
