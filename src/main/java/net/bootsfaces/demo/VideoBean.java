package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		events += "play" + "\n";
	}
	public void onPause() {
		events += "pause" + "\n";
	}

}
