package net.bootsfaces.demo.selectOneMenu;

/**
 * Example taken from :
 * https://memorynotfound.com/using-custom-converter-for-hselectonemenu/
 */
public class Beer {

    private Integer id;
    private String brand;

    public Beer(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
