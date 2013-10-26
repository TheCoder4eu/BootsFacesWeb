package net.bootfaces.preview;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author droidcoder
 */
@ManagedBean
@RequestScoped
public class InformBean implements Serializable {
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
