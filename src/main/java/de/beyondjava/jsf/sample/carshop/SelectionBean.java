package de.beyondjava.jsf.sample.carshop;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;


@Deprecated
@Named
@RequestScoped
public class SelectionBean {

    @Inject
    @ManagedProperty("#{carPool.selectedCars}")
    private List<Car> selectedCars;

    @Inject
    private CarBean carBean;

    public CarBean getCarBean() {
        return carBean;
    }

    public void setCarBean(CarBean carBean) {
        this.carBean = carBean;
    }

    public List<Car> getSelectedCars() {
        return selectedCars;
    }

    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }

    private String carAsJSon;

    public String getCarAsJSon() {
        return carAsJSon;
    }

    public void setCarAsJSon(String carAsJSon) {
        this.carAsJSon = carAsJSon;
    }
    
}
