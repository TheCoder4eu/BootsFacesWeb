/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.beyondjava.jsf.sample.carshop;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ManagedBean
@SessionScoped
public class Car implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String brand;

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NotNull
    String color;

    String type;

    @Min(1886)
    @Max(2014)
    @NotNull
    int year;

    @Min(0)
    @Max(1000000)
    @NotNull
    int mileage;

    @NotNull
    String fuel;

    @Min(1)
    @Max(5000000)
    int price;

    @Min(50)
    @Max(200)
    private int enginePower;

    private boolean editable;

    public Car() {
    }

    public Car(String brand, String type, int year, String color, int mileage, String fuel, int price) {
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.fuel = fuel;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getEnginePowerKW() {
        return (int) Math.round(enginePower / 1.35962);
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void edit() {
        editable = !editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return ((currentYear - year) * 12 + 5) + " months";
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", color=" + color + ", type=" + type + ", year=" + year + ", mileage=" + mileage
                + ", fuel=" + fuel + ", price=" + price + ", enginePower=" + enginePower + ", editable=" + editable
                + "]";
    }
}
