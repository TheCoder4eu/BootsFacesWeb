package net.bootsfaces.demo;

/**
 * Store Items Class
 * @author Thecoder4.eu
 */
public class Item {
    private String name;
    private String code;
    private String price;

    public Item(String name, String code, String price) {
        this.name = name;
        this.code = code;
        this.price= price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
