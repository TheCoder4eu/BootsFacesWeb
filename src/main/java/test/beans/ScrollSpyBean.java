package test.beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

import net.bootsfaces.component.scrollSpy.event.ScrollSpyEventListener;

@Named(value = "spy")
@SessionScoped
public class ScrollSpyBean implements ScrollSpyEventListener, Serializable {

    @Override
    public void itemSelected(String arg0) {
        System.out.println("SELECTED: " + arg0);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SELECTED: " + arg0, "SELECTED: " + arg0));
    }

}
