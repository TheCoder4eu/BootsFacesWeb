package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class NavBarBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean navBarDisabled = false;
    private boolean navBarLinksDisabled = false;
    private boolean dropMenuDisabled = false;

    public boolean isNavBarDisabled() {
        return navBarDisabled;
    }

    public void setNavBarDisabled(boolean navBarDisabled) {
        this.navBarDisabled = navBarDisabled;
    }

    public boolean isNavBarLinksDisabled() {
        return navBarLinksDisabled;
    }

    public void setNavBarLinksDisabled(boolean navLinksDisabled) {
        this.navBarLinksDisabled = navLinksDisabled;
    }

    public boolean isDropMenuDisabled() {
        return dropMenuDisabled;
    }

    public void setDropMenuDisabled(boolean dropMenuDisabled) {
        this.dropMenuDisabled = dropMenuDisabled;
    }

    public void onChange() {
    }
}
