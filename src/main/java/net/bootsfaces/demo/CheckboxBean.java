package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean
public class CheckboxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean checkbox = true;
	
	private boolean editable = false;
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void toggleEditmode(ActionEvent even) {
		editable=!editable;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

}
