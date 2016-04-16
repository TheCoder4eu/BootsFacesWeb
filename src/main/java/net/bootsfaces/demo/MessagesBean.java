package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ManagedBean
@RequestScoped
public class MessagesBean implements Serializable {
	private static final long serialVersionUID = 5497787734011747081L;
	
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces <b>rocks</b>. BootsFaces <b>rocks</b>, too!"));
    }
     
    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for <i>PrimeFaces</i>. It's a good match to BootsFaces."));
    }
     
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Something has gone <strong>wrong</strong>."));
    }
     
    public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error. What did <u>you</u> do?"));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Now it's too late to do anything. The system is down."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Please shut down all systems!"));
    }
	
	public void showMessages() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info message", "This is a very informative message.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
    public void info(ActionEvent event) {
    	String[] messages={"<b>BootsFaces</b> rocks!", "How do you like <b>this message</b>?", "This message has been brought to <b>you</b> by an actionListener."};
    	int index = (int)(Math.random()*messages.length);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", messages[index]));
    }

}
