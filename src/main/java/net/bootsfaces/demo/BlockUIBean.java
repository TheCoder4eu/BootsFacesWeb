package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BlockUIBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public void waitFiveSeconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isBlockUIActive() {
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        if ("/forms/blockUI.xhtml".equals(viewId)) {
            return true;
        }
        if ("/bootstrap/SocialShare.xhtml".equals(viewId)) {
            return true;
        }
        return false;
    }

}
