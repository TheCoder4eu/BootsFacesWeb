package net.bootsfaces.issues.modalRelead;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import net.bootsfaces.utils.FacesMessages;

@SessionScoped
@Named
public class ModalReloadBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String someValue = "Original value";
	
	private int counter = 0;
	
	private Part file; // +getter+setter


	
	public ModalReloadBean() {
		System.out.println("New bean created");
	}
	
	public void save() {
		FacesMessages.info("File " + file.getSubmittedFileName() + " uploaded: " + file.getSize() + " bytes");
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


	public Part getFile() {
		return file;
	}


	public void setFile(Part file) {
		this.file = file;
	}
	
	public String getUploadSuccessfull() {
		if (null == file) {
			return "no file uploaded";
			
		}
		return "upload successful";
	}

}
