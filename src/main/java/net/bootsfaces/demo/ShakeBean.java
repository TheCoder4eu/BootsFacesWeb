/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@RequestScoped
public class ShakeBean implements Serializable {

    private static final long serialVersionUID = -1;

    public void onShaken() {
        FacesMessages.info("Shaken at " + new Date());
    }
}
