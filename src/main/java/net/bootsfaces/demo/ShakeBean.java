/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;


import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author TheCoder4eu
 */
@Named
@RequestScoped
public class ShakeBean implements Serializable {

    private static final long serialVersionUID = -1;

    public void onShaken() {
        FacesMessages.info("Shaken at " + new Date());
    }
}
