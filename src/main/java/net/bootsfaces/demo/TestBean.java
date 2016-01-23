package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class TestBean implements Serializable {
	private static final long serialVersionUID = -332002335165889800L;
	private int val1 = 78;
	private int val2 = 87;
	private int val3 = 34;
	private int val4 = 43;
	private int val5 = 12;
	private int val6 = 30;
	private String label1 = "Label One";
	private String label2 = "Label Two";
	private String text1 = "Text One";
	private String text2 = "Text Two";

	private int index = 2;

	public void nextTab() {
		index++;
		if (index > 3)
			index = 0;
	}

	public int getVal1() {
		return val1;
	}

	public void setVal1(int val1) {
		this.val1 = val1;
	}

	public int getVal2() {
		return val2;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}

	public String getLabel1() {
		return label1;
	}

	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public int getVal3() {
		return val3;
	}

	public void setVal3(int val3) {
		this.val3 = val3;
	}

	public int getVal4() {
		return val4;
	}

	public void setVal4(int val4) {
		this.val4 = val4;
	}

	public int getVal5() {
		return val5;
	}

	public void setVal5(int val5) {
		this.val5 = val5;
	}

	public int getVal6() {
		return val6;
	}

	public void setVal6(int val6) {
		this.val6 = val6;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	/**
	 * Creates a new instance of informBean
	 */
	public TestBean() {
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
