package net.bootsfaces.demo;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@RequestScoped
@Named
public class PollDemoBean {
	
	private int counter=0;
	
	public Date getCurrentTime() { return new Date(); }

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter+1;
	}

	public void listener(ActionEvent event) {
		System.out.println("Poll called me");
	}
}
