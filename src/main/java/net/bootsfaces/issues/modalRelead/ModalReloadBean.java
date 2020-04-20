package net.bootsfaces.issues.modalRelead;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@Named
public class ModalReloadBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String someValue = "Original value";
	
	private int counter = 0;
	
	public ModalReloadBean() {
		System.out.println("New bean created");
	}
	

	public String getSomeValue() {
		if (counter > 0) {
			return counter + this.someValue;
		}
		return someValue;
	}

	public void setSomeValue(String someValue) {
		this.someValue = someValue;
	}
	
	public void closeAndReload() throws IOException {
		this.someValue = " server-side reloads";
		counter++;
		reload();
	}
	
	public void reload() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

}
