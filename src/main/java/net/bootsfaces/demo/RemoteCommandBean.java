package net.bootsfaces.demo;

import java.io.Serializable;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class RemoteCommandBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void count(ActionEvent event) {
        counter++;
    }

    public void setCounter() {
        String initialValue = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("initialValue");
        if (null != initialValue) {
            counter = Integer.valueOf(initialValue);
        }
    }
}
