package net.bootsfaces.issues.issue541;

import java.io.Serializable;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class Issue541Bean implements Serializable {

    private String value = "Hallo";

    private static final long serialVersionUID = 745232242454805589L;

    boolean b = true;

    public Issue541Bean() {
        super();
    }

    public void onChange() {
        System.out.println("##### > OK");
        b = false;
    }

    public boolean isDisabled() {
        return b;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
