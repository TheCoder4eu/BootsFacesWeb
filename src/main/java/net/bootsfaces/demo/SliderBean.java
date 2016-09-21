package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class SliderBean implements Serializable {
	private static final long serialVersionUID = -332002335165889800L;
	private double value1 = 10;
	private double value2 = 87;
	private double value3 = 84;
	private double value4 = 43;
	private double value5 = 12;
	private double value6 = 30;
	
	private double valueDouble = 15.5;
	
	/**
	 * Creates a new instance of informBean
	 */
	public SliderBean() {
	}
	
	public void button1() {
		System.out.println("Double value is: " + valueDouble);
		// valueDouble = 28.5;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}

	public double getValue3() {
		return value3;
	}

	public void setValue3(double value3) {
		this.value3 = value3;
	}

	public double getValue4() {
		return value4;
	}

	public void setValue4(double value4) {
		this.value4 = value4;
	}

	public double getValue5() {
		return value5;
	}

	public void setValue5(double value5) {
		this.value5 = value5;
	}

	public double getValue6() {
		return value6;
	}

	public void setValue6(double value6) {
		this.value6 = value6;
	}

	public double getValueDouble() {
		return valueDouble;
	}

	public void setValueDouble(double valueDouble) {
		this.valueDouble = valueDouble;
	}
}
