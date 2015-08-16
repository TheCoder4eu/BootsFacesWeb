package net.bootsfaces.demo.ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CommandButtonBean {
	private String message = "No action listener called yet.";

	private boolean suppressClick = true;
	private boolean suppressDoubleClick = false;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void onDoubleClick() {
		message = "Double click";
	}

	public void onMouseOver() {
		message = "Mouse over";
	}

	public void onMouseOut() {
		message = "Mouse out";
	}

	public void onAction() {
		message = "default action (click or return key)";
	}

	public boolean isSuppressDoubleClick() {
		return suppressDoubleClick;
	}

	public void setSuppressDoubleClick(boolean suppressDoubleClick) {
		this.suppressDoubleClick = suppressDoubleClick;
	}

	public boolean isSuppressClick() {
		return suppressClick;
	}

	public void setSuppressClick(boolean suppressClick) {
		this.suppressClick = suppressClick;
	}
}
