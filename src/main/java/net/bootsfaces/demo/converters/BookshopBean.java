package net.bootsfaces.demo.converters;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class BookshopBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private double discount = 10.5;
    private double price = 34.90;
    private int quantity = 1;
    private double vat = 7;
    private double total = 0;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void calculate() {
        total = quantity * (price * (100.0 - discount) / 100.0) * (100.0 + vat) / 100.0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

}
