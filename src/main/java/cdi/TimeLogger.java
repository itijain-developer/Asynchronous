package cdi;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TimeLogger {
	
	 public TimeLogger(SimpleDateFormat dateFormat, Calendar calendar) {
		super();
		this.dateFormat = dateFormat;
		this.calendar = calendar;
	}

	private SimpleDateFormat dateFormat;

	    private Calendar calendar;
	    
	public String getTime() {

        return dateFormat.format(calendar.getTime());

    }

}
