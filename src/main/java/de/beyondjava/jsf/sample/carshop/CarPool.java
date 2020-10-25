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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarPool implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static int SIZE_OF_INITIAL_CAR_POOL = 15;

    private String language = "Italian";

    @ManagedProperty("#{staticOptionBean}")
    private StaticOptionBean staticOptions;

    public StaticOptionBean getStaticOptions() {
        return staticOptions;
    }

    public void setStaticOptions(StaticOptionBean staticOptions) {
        this.staticOptions = staticOptions;
    }

    public DynamicOptionBean getDynamicOptions() {
        return dynamicOptions;
    }

    public void setDynamicOptions(DynamicOptionBean dynamicOptions) {
        this.dynamicOptions = dynamicOptions;
    }

    @ManagedProperty("#{dynamicOptionBean}")
    private DynamicOptionBean dynamicOptions;

    private List<String> types;

    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    private List<Car> carPool;

    public List<Car> getCarPool() {
        return carPool;
    }

    public List<Car> getEmptyCarPool() {
        return new ArrayList<Car>();
    }

    private List<Car> selectedCars = new ArrayList<>();

    private List<Car> currentlySelectedCars = new ArrayList<>();

    public List<Car> getSelectedCars() {
        return selectedCars;
    }

    @PostConstruct
    public void initRandomCarPool() {
        types = dynamicOptions.getTypesToBrand(null);
        carPool = new ArrayList<Car>();
        for (int i = 0; i < SIZE_OF_INITIAL_CAR_POOL; i++) {
            carPool.add(getRandomCar());
        }
        selectedCars = carPool;
    }

    public void setCarPool(List<Car> carpool) {
        this.carPool = carpool;
    }

    private Car getRandomCar() {
        int typeIndex = (int) Math.floor(Math.random() * (types.size() - 1));
        String type = types.get(typeIndex + 1);
        String brand = dynamicOptions.getBrandToType(type);
        int year = (int) (Math.floor((currentYear - 1980) * Math.random())) + 1980;
        int age = currentYear - year;

        int price = 60000 / (1 + age) + (int) Math.floor(Math.random() * 10000);

        int mileage = (int) (Math.floor((age + 1) * 20000 * Math.random()));

        int colorIndex = (int) Math.floor(Math.random() * (staticOptions.getColors().size() - 1));
        String color = staticOptions.getColors().get(colorIndex + 1);

        int fuelIndex = (int) Math.floor(Math.random() * (staticOptions.getFuels().size() - 1));
        String fuel = staticOptions.getFuels().get(fuelIndex + 1);

        int enginePower = (int) Math.floor(Math.random() * 100) + 50;

        Car c = new Car(brand, type, year, color, mileage, fuel, price);
        c.setEnginePower(enginePower);
        return c;
    }

    public void applyFilter(FilterBean b) {
        selectedCars = new ArrayList<Car>();
        for (Car c : carPool) {
            String criterium = b.getBrand();
            if (criterium != null && criterium.length() > 0) {
                if (!c.getBrand().equals(criterium)) {
                    continue;
                }
            }
            criterium = b.getType();
            if (criterium != null && criterium.length() > 0) {
                if (!c.getType().equals(criterium)) {
                    continue;
                }
            }
            criterium = b.getColor();
            if (criterium != null && criterium.length() > 0) {
                if (!c.getColor().equals(criterium)) {
                    continue;
                }
            }
            criterium = b.getFuel();
            if (criterium != null && criterium.length() > 0) {
                if (!c.getFuel().equals(criterium)) {
                    continue;
                }
            }
            int year = b.getYear();
            if (c.getYear() < year) {
                continue;
            }
            criterium = b.getMileage();
            if (criterium != null && criterium.length() > 0) {
                int km = Integer.parseInt(criterium.substring(2, criterium.length() - 3));
                if (c.getMileage() > km) {
                    continue;
                }
            }
            criterium = b.getPrice();
            if (criterium != null && criterium.length() > 0) {
                int euro = Integer.parseInt(criterium.substring(3, criterium.length()));
                if (c.getPrice() > euro) {
                    continue;
                }
            }
            selectedCars.add(c);
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLang() {
        if ("Italian".equals(language)) {
            return "it";
        }
        return null;
    }

    public String getCustomLangUrl() {
        if ("Brazilian Portuguese".equals(language)) {
            return "//cdn.datatables.net/plug-ins/1.10.12/i18n/Portuguese-Brasil.json";
        }
        if ("Norwegian".equals(language)) {
            return "//cdn.datatables.net/plug-ins/1.10.12/i18n/Norwegian-Bokmal.json";
        }
        return null;
    }

    public void onLanguageChange() {

    }

    public void onSelect() {
        System.out.println("OnSelect");
    }

    public void onSelect(Car car) {
        System.out.println("OnSelect:" + car);
    }

    public void onSelect(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnSelect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);

        if (!"row".equals(typeOfSelection)) {
            car = null; // it's an empty instance of Car, so we better get rid of it
        }
        if (indexes != null && indexes.contains("[")) {
            car = null; // JSF can't deal with arrays of parameters
        }
        if (null != car) {
            getCurrentlySelectedCars().add(car);
        } else if (null != indexes && "row".equals(typeOfSelection)) {
            if (indexes.startsWith("[")) {
                indexes = indexes.substring(1, indexes.length() - 1);
            }
            String[] indexArray = indexes.split(",");
            for (String index : indexArray) {
                int i = Integer.valueOf(index);
                Car newCar = carPool.get(i);
                if (!currentlySelectedCars.contains(newCar)) {
                    getCurrentlySelectedCars().add(newCar);
                }
            }
        }
    }

    public void onDeselect(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnDeselect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
        if (null != car && "row".equals(typeOfSelection)) {
            getCurrentlySelectedCars().remove(car);
        } else if (null != indexes && "row".equals(typeOfSelection)) {
            String[] indexArray = indexes.split(",");
            for (String index : indexArray) {
                int i = Integer.valueOf(index);
                getCurrentlySelectedCars().remove(carPool.get(i));
            }
        }
    }

    public void onSelectDemo2(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnSelect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
    }

    public void onDeselectDemo2(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnDeselect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
    }

    public List<Car> getCurrentlySelectedCars() {
        return currentlySelectedCars;
    }

    public void setCurrentlySelectedCars(List<Car> currentlySelectedCars) {
        this.currentlySelectedCars = currentlySelectedCars;
    }

    public void delete(Car car) {
        this.carPool.remove(car);
    }

    public void changeColor(Car car) {
        String color;
        do {
            int colorIndex = (int) Math.floor(Math.random() * (staticOptions.getColors().size() - 1));
            color = staticOptions.getColors().get(colorIndex + 1);
        } while (color.equals(car.getColor()));

        car.setColor(color);
    }
}
