package net.bootsfaces.demo.forms;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
