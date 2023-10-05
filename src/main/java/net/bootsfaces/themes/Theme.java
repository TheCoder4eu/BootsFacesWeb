package net.bootsfaces.themes;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;

    private String currentTheme = "default";

    private String internalTheme = "default";

    private String customTheme = "";

    public String getCurrentTheme() {
        return currentTheme;
    }

    public String getInternalTheme() {
        return internalTheme;
    }

    public String getCustomTheme() {
        return customTheme;
    }

    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
        if (currentTheme.equalsIgnoreCase("Freelancer")) {
            internalTheme = "other";
            customTheme = currentTheme;
        } else if (currentTheme.equalsIgnoreCase("Grayscale")) {
            internalTheme = "other";
            customTheme = currentTheme;
        } else {
            internalTheme = currentTheme;
            customTheme = "";
        }
    }

    public void selectTheme() {
    }

}
