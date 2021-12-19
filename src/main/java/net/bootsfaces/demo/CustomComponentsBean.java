package net.bootsfaces.demo;

import de.beyondjava.jsf.sample.carshop.Car;

import java.io.Serializable;
import java.util.List;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class CustomComponentsBean implements Serializable {

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

    public String onClick() {
        return "Success.jsf";
    }

    public String onClick(Car car) {
        return "Success.jsf";
    }

    public String goBack() {
        return "CompositeComponents.jsf";
    }

    public void onDelete(List<Car> cars, Car car) {
        cars.remove(car);
    }
}
