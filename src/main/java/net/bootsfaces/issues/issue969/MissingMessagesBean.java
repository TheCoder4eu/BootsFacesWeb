package net.bootsfaces.issues.issue969;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class MissingMessagesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String someValue = "This is the bean reproducing issue 969.";
	
	public MissingMessagesBean() {
		final FacesMessage facesMessage = new FacesMessage(javax.faces.application.FacesMessage.SEVERITY_INFO, "summary", "message without id");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		final FacesMessage facesMessage2 = new FacesMessage(javax.faces.application.FacesMessage.SEVERITY_INFO, "summary", "message with id");
        FacesContext.getCurrentInstance().addMessage("someId", facesMessage2);
	}

	public String getSomeValue() {
		return someValue;
	}

	public void setSomeValue(String someValue) {
		this.someValue = someValue;
	}

}
