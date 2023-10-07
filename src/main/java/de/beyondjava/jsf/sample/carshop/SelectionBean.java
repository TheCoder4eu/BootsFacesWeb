package de.beyondjava.jsf.sample.carshop;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Named;
import java.util.List;


@Named
@RequestScoped
public class SelectionBean {

    @ManagedProperty("#{carPool.selectedCars}")
    private List<Car> selectedCars;

    @ManagedProperty("#{carBean}")
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

//	public String showDetails() {
//		int pos = carAsJSon.indexOf(",\"$$hashKey\"");
//		if (pos > 0)
//			carAsJSon = carAsJSon.substring(0, pos) + "}";
//
//		Car car = (Car) JSONUtilities.readObjectFromJSONString(carAsJSon, Car.class);
//		return getCarBean().showDetails(car);
//	}
}
