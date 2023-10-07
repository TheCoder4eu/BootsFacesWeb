package net.bootsfaces.demo;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;


@Named
@ViewScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 10)
    @NotEmpty
    private String username;

    @Size(min = 4, max = 10)
    @NotEmpty
    private String password;

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        if ("BootsFaces".equalsIgnoreCase(username) && "rocks!".equalsIgnoreCase(password)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Congratulations! You've successfully logged in.", "");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "That's the wrong password. Hint: BootsFaces rocks!", "");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
    }

    public void login2() {
        if ("BootsFaces".equalsIgnoreCase(username) && "rocks!".equalsIgnoreCase(password)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Congratulations! You've successfully logged in.", "");
            FacesContext.getCurrentInstance().addMessage("loginForm:passwordDiv", msg);

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "That's the wrong password. Hint: BootsFaces rocks!", "");
            FacesContext.getCurrentInstance().addMessage("loginForm:passwordDiv", msg);
        }
    }

    public void forgotPassword() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Default user name: BootsFaces", "");
        FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Default password: rocks!", "");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }

    public void update() {

    }
}
