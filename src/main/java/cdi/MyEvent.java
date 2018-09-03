package cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyEvent {
	
	int eventNum;

	public MyEvent(int eventNum) {
		super();
		this.eventNum = eventNum;
	}

}
