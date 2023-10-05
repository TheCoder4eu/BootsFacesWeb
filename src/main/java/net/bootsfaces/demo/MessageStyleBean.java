package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;


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
