package net.bootsfaces.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SpinBean {
	private double spinValue = 45f;
	
	public SpinBean() { }
	
	public void button1() {
		System.out.println("Spin value is: " + spinValue);
	}
	
	public void button2() {
		spinValue = 98f;
		System.out.println("Spin value is: " + spinValue);
	}

	public double getSpinValue() {
		System.out.println("Called set value of: " + spinValue);
		return spinValue;
	}

	public void setSpinValue(double spinValue) {
		System.out.println("Called set value with: " + spinValue);
		this.spinValue = spinValue;
	}
}
