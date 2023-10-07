package net.bootsfaces.demo;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
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
