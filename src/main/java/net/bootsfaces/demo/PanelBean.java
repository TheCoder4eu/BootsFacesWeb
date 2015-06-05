package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ManagedBean
@SessionScoped
public class PanelBean implements Serializable {
	private static final long serialVersionUID = 5497787734011747081L;
	
	private boolean hideContent=true;

	public boolean isHideContent() {
		return hideContent;
	}

	public void setHideContent(boolean hideContent) {
		this.hideContent = hideContent;
	}
	
	public boolean getHideContent() {
		return hideContent;
	}
	

}
