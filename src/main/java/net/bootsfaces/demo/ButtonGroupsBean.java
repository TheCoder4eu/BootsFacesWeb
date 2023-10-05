package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;


@ViewScoped
@ManagedBean
public class ButtonGroupsBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean contentDisabled = false;
    private boolean invidualLinksDisabled = false;
    private boolean dropButtonDisabled = false;

    public boolean isContentDisabled() {
        return contentDisabled;
    }

    public void setContentDisabled(boolean contentDisabled) {
        this.contentDisabled = contentDisabled;
    }

    /**
     * Dummy method to handle the AJAX event
     */
    public void onChange() {
    }

    public boolean isDropButtonDisabled() {
        return dropButtonDisabled;
    }

    public void setDropButtonDisabled(boolean dropButtonDisabled) {
        this.dropButtonDisabled = dropButtonDisabled;
    }

    public boolean isInvidualLinksDisabled() {
        return invidualLinksDisabled;
    }

    public void setInvidualLinksDisabled(boolean invidualLinksDisabled) {
        this.invidualLinksDisabled = invidualLinksDisabled;
    }
}
