package net.bootsfaces.demo.ajax;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String page="start.xhtml";

	public String getPage() {
		return page;
	}
	
	public void setPage(String currentPage) {
		this.page=currentPage;
	}
	public void register() {
		this.page="register.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./navigationAndAJAX.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start() {
		this.page="start.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./navigationAndAJAX.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}        
