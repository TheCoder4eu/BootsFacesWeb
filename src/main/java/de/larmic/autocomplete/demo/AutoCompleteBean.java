package de.larmic.autocomplete.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import de.larmic.butterfaces.model.text.AutoCompleteModel;

@ViewScoped
@ManagedBean
public class AutoCompleteBean implements Serializable, AutoCompleteModel {
	private static final long serialVersionUID = 1L;
	
	private String value;

	public List<String> autoComplete(Object value) {
		List<String> autoCompleteValues = new ArrayList<String>();
		autoCompleteValues.add("test");
		autoCompleteValues.add("tetest");
		autoCompleteValues.add("test1 ButterFaces");
		autoCompleteValues.add("test2");
		autoCompleteValues.add("ButterFaces");
		autoCompleteValues.add("ButterFaces JSF");
		autoCompleteValues.add("ButterFaces Mojarra");
		autoCompleteValues.add("ButterFaces Component");
		autoCompleteValues.add("JSF");
		autoCompleteValues.add("JSF 2");
		autoCompleteValues.add("JSF 2.2");
		return autoCompleteValues;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}