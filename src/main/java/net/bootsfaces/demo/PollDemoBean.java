package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.Date;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.event.ActionEvent;

@ViewScoped
@ManagedBean
public class PollDemoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int counter = 0;

    private boolean stop;

    public Date getCurrentTime() {
        return new Date();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter + 1;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void listener(ActionEvent event) {
//		System.out.println("Poll called me");
    }
}
