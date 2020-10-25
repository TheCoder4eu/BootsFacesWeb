package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ManagedBean
@SessionScoped
public class PanelBean implements Serializable {

    private static final long serialVersionUID = 5497787734011747081L;

    private boolean firstPanelCollapsed = true;

    public boolean isHideContent() {
        return firstPanelCollapsed;
    }

    public boolean getSecondPanelCollapsed() {
        return !firstPanelCollapsed;
    }

    public boolean getFirstPanelCollapsed() {
        return firstPanelCollapsed;
    }

    public void toggle(ActionEvent event) {
        firstPanelCollapsed = !firstPanelCollapsed;
    }

    public String getFirstText() {
        return firstPanelCollapsed ? "closed" : "open";
    }

    public String getSecondText() {
        return firstPanelCollapsed ? "open" : "closed";
    }

}
