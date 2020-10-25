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
package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.bootsfaces.utils.FacesMessages;

/**
 * A simple bean for demo purposes.
 */
@RequestScoped
@ManagedBean
public class SelectMultiMenuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String brand = "1, 2, 3";

    @NotNull
    private String type = "2";

    private String color;

    @NotNull
    @Min(500)
    @Max(50000)
    private int price;

    @NotNull
    @Min(2)
    @Max(999)
    private int enginePower;

    private List<NumericKeyStringValuePair> myList = new ArrayList<>();

    private boolean iAgreeToTheTermsAndConditions = false;

    public SelectMultiMenuBean() {
        getMyList().add(new NumericKeyStringValuePair(1, "Tesla"));
        getMyList().add(new NumericKeyStringValuePair(2, "Porsche"));
        getMyList().add(new NumericKeyStringValuePair(3, "BMW"));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isiAgreeToTheTermsAndConditions() {
        return iAgreeToTheTermsAndConditions;
    }

    public void setiAgreeToTheTermsAndConditions(boolean iAgreeToTheTermsAndConditions) {
        this.iAgreeToTheTermsAndConditions = iAgreeToTheTermsAndConditions;
    }

    public void updateBrandMessage() {
        if (null == brand) {
            FacesMessages.error("**:brandID", "Error", "No brand selected");
        } else {
            FacesMessages.info("**:brandID", "Brand selected", "You've selected " + brand);
        }
    }

    public void updateTypeMessage() {
        if (null == type) {
            FacesMessages.warning("**:typeID", "Warning", "No type selected");
        } else {
            FacesMessages.info("**:typeID", "Type selected", "You've selected " + type);
        }
    }

    public List<NumericKeyStringValuePair> getMyList() {
        return myList;
    }

    public void setMyList(List<NumericKeyStringValuePair> myList) {
        this.myList = myList;
    }
}
