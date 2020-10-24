package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@ViewScoped
public class InformBean implements Serializable {

    private static final long serialVersionUID = 3776366707374123185L;
    private String firstname;
    private String familyname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    /**
     * Creates a new instance of informBean
     */
    public InformBean() {
    }
}
