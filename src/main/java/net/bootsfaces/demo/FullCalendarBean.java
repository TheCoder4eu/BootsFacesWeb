package net.bootsfaces.demo;

import java.io.Serializable;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

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
