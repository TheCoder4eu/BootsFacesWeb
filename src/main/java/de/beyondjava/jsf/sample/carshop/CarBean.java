package de.beyondjava.jsf.sample.carshop;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean iAgreeToTheTermsAndConditions = false;
    private Car car;

    public CarBean() {
        car = new Car();
    }

    public String showDetails(Car car) {
        this.car = car;
        return "details.jsf";
    }

    public String getBrand() {
        return car.getBrand();
    }

    public void setBrand(String brand) {
        car.setBrand(brand);
    }

    public String getType() {
        return car.getType();
    }

    public void setType(String type) {
        car.setType(type);
    }

    public String getColor() {
        return car.getColor();
    }

    public void setColor(String color) {
        car.setColor(color);
    }

    public int getPrice() {
        return car.getPrice();
    }

    public void setPrice(int price) {
        car.setPrice(price);
    }

    public int getMileage() {
        return car.getMileage();
    }

    public void setMileage(int mileage) {
        car.setMileage(mileage);
    }

    public int getYear() {
        return car.getYear();
    }

    public void setYear(int year) {
        car.setYear(year);
    }

    public String getFuel() {
        return car.getFuel();
    }

    public void setFuel(String fuel) {
        car.setFuel(fuel);
    }

    public int getEnginePower() {
        return car.getEnginePower();
    }

    public void setEnginePower(int enginePower) {
        car.setEnginePower(enginePower);
    }

    public void listAvailableCars() {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
                "Currently, there's no car available. Try again later.");
        FacesContext.getCurrentInstance().addMessage(null, fm);

    }

    public boolean isiAgreeToTheTermsAndConditions() {
        return iAgreeToTheTermsAndConditions;
    }

    public void setiAgreeToTheTermsAndConditions(boolean iAgreeToTheTermsAndConditions) {
        this.iAgreeToTheTermsAndConditions = iAgreeToTheTermsAndConditions;
    }
}
