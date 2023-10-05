package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class VideoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String events = "";

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public void onPlay() {
        events = "play" + "\n" + events;
    }

    public void onPause() {
        events = "pause" + "\n" + events;
    }

    public void onSeeking() {
        events = "seeking" + "\n" + events;
    }

    public void onCanplaythrough() {
        events = "can play through" + "\n" + events;
    }

    public void onLoadedData() {
        events = "loaded data" + "\n" + events;
    }

}
