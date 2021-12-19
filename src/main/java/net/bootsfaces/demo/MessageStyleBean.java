package net.bootsfaces.demo;

import java.io.Serializable;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MessageStyleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean useLegacyBootsFacesStyle = true;

    public boolean isUseLegacyBootsFacesStyle() {
        return useLegacyBootsFacesStyle;
    }

    public void setUseLegacyBootsFacesStyle(boolean useLegacyBootsFacesStyle) {
        this.useLegacyBootsFacesStyle = useLegacyBootsFacesStyle;
    }

    public void toggleSettings() {
        this.useLegacyBootsFacesStyle = !this.useLegacyBootsFacesStyle;
    }

}
