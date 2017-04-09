package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class SliderBean implements Serializable {
	private static final long serialVersionUID = -332002335165889800L;
	private int value1 = 10;
	private int value2 = 87;
	private int value3 = 84;
	private int value4 = 43;
	private int value5 = 12;
	private int value6 = 30;

	@Min(18)
	@Max(65)
	private double age = 0;

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

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getValue3() {
		return value3;
	}

	public void setValue3(int value3) {
		this.value3 = value3;
	}

	public int getValue4() {
		return value4;
	}

	public void setValue4(int value4) {
		this.value4 = value4;
	}

	public int getValue5() {
		return value5;
	}

	public void setValue5(int value5) {
		this.value5 = value5;
	}

	public int getValue6() {
		return value6;
	}

	public void setValue6(int value6) {
		this.value6 = value6;
	}

	public double getValueDouble() {
		return valueDouble;
	}

	public void setValueDouble(double valueDouble) {
		this.valueDouble = valueDouble;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
}
