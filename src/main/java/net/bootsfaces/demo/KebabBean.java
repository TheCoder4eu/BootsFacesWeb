package net.bootsfaces.demo;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class KebabBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean contentDisabled = false;

    public boolean isContentDisabled() {
        return contentDisabled;
    }

    public void setContentDisabled(boolean contentDisabled) {
        this.contentDisabled = contentDisabled;
    }

    public void onChange() {

    }
}
