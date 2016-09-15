package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.utils.BsfUtils;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class SliderBean implements Serializable {
	private static final long serialVersionUID = -332002335165889800L;
	private String value1 = "10";
	private String value2 = "87";
	private String value3 = "84";
	private String value4 = "43";
	private String value5 = "12";
	private String value6 = "30";
	private Float valueFloat = 15.5f;
	
	private Float[] flValues = new Float[]{ 20.2f, 45.5f };
	
	/**
	 * Creates a new instance of informBean
	 */
	public SliderBean() {
	}
	
	public void button1() {
		System.out.println("Float value is: " + valueFloat);
		System.out.println("Array of float values is: " + Arrays.toString(flValues));
		// valueFloat = 28.5f;
	}
	
	public String getArray() {
		return Arrays.toString(flValues);
	}
	
	public void setArray(String arr) {
		this.flValues = BsfUtils.getSliderValues(arr, true);
	}

	public float getValueFloat() {
		System.out.println("Called get with value = " + valueFloat);
		return valueFloat;
	}
	
	public void setValueFloat(float value) {
		valueFloat = value;
		System.out.println("NEW VF = " + valueFloat);
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
		this.flValues = BsfUtils.getSliderValues(value1);
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
		this.flValues = BsfUtils.getSliderValues(value2);
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
		this.flValues = BsfUtils.getSliderValues(value3);
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
		this.flValues = BsfUtils.getSliderValues(value4);
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
		this.flValues = BsfUtils.getSliderValues(value5);
	}
	
	public String getValue6() {
		return value6;
	}

	public void setValue6(String value6) {
		this.value6 = value6;
		this.flValues = BsfUtils.getSliderValues(value6);
	}
}
