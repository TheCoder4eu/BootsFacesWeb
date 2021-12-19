package test.beans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;

import net.bootsfaces.component.scrollSpy.event.ScrollSpyEventListener;

@SessionScoped
@ManagedBean(name = "spy")
public class ScrollSpyBean implements ScrollSpyEventListener {

    @Override
    public void itemSelected(String arg0) {
        System.out.println("SELECTED: " + arg0);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SELECTED: " + arg0, "SELECTED: " + arg0));
    }

}
