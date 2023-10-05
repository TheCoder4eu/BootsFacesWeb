package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class FullCalendarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String language = "en";

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void updateLanguage() {
    }
}
