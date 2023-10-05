package net.bootsfaces.demo.forms;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;


import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@ViewScoped
public class CommandLinkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String testAction() {
        FacesMessages.info("Command link clicked", "Detail?");
        return null;
    }
}
