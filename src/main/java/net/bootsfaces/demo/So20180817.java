package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import net.bootsfaces.utils.FacesMessages;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ManagedBean
@RequestScoped
public class So20180817 implements Serializable {
	private static final long serialVersionUID = 5497787734011747081L;

	public void borrar() {
        System.out.println("BORRAR ");
        FacesMessages.info("idForm:idBorrar", "Se boró correctamente el servicio", "Nunca va a volver. ¡Nunca!");
}
}
