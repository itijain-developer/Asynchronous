package cdi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.inject.Produces;

public class TimeLoggerFactory {
	
	@Produces
	public TimeLogger getTimeLogger() {
		return new TimeLogger(new SimpleDateFormat("HH:mm"), Calendar.getInstance());
	}

}
