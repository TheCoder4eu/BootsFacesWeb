package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@Named
@RequestScoped
public class ClockBean implements Serializable {
	private static final long serialVersionUID = 5497787734011747081L;
	@Min(0)
	@Max(23)
	private int hour;

	@Min(0)
	@Max(55)
	private int minute;
	
	{
		Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
}
