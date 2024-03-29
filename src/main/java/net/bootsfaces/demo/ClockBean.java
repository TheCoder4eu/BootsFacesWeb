package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Calendar;


/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@Named
@RequestScoped
public class ClockBean implements Serializable {

    private static final long serialVersionUID = 5497787734011747081L;
    private int hour;

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
