package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@RequestScoped
@ManagedBean
public class PollDemoBean implements Serializable {
	
	private int counter=0;
	
	public Date getCurrentTime() { return new Date(); }

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter+1;
	}

	public void listener(ActionEvent event) {
//		System.out.println("Poll called me");
	}
}
