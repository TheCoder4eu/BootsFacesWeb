package net.bootsfaces.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SpinBean {

    private double spinValue = 45f;
    private int intSpinValue = 33;

    public SpinBean() {
    }

    public void button1() {
        System.out.println("Spin value is: " + spinValue);
        System.out.println("Int Spin value is: " + intSpinValue);
    }

    public void button2() {
        spinValue = 98f;
        intSpinValue = 21;
        System.out.println("Spin value is: " + spinValue);
        System.out.println("Int Spin value is: " + intSpinValue);
    }

    public double getSpinValue() {
        System.out.println("Called set value of: " + spinValue);
        return spinValue;
    }

    public void setSpinValue(double spinValue) {
        System.out.println("Called set value with: " + spinValue);
        this.spinValue = spinValue;
    }

    public int getIntSpinValue() {
        System.out.println("Called INT set value of: " + intSpinValue);
        return intSpinValue;
    }

    public void setIntSpinValue(int value) {
        System.out.println("Called INT set value with: " + value);
        this.intSpinValue = value;
    }
}
