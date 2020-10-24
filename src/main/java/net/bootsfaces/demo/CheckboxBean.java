package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;

@SessionScoped
@ManagedBean
public class CheckboxBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean checkbox = true;

    @AssertTrue(message = "Greetings from the JSR303 Bean Validation API: This checkbox must always be checked!")
    private boolean cbxError = false;
    private boolean cbxFatal = false;
    private boolean cbxWarning = false;
    private boolean cbxInfo = false;

    private boolean editable = false;

    public CheckboxBean() {
        setCbxError(true);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void toggleEditmode() {
        editable = !editable;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public boolean isCbxError() {
        return cbxError;
    }

    public void setCbxError(boolean errorCheckbox) {
        this.cbxError = errorCheckbox;
    }

    public void action() {
    }

    public boolean isCbxFatal() {
        return cbxFatal;
    }

    public void setCbxFatal(boolean cbxFatal) {
        this.cbxFatal = cbxFatal;
        if (cbxFatal) {
            FacesContext.getCurrentInstance().addMessage("messageForm:checkboxWithFatalMessage",
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "", "This is what a fatal error looks like."));
        }
    }

    public boolean isCbxWarning() {
        return cbxWarning;
    }

    public void setCbxWarning(boolean cbxWarning) {
        this.cbxWarning = cbxWarning;
        if (cbxWarning) {
            FacesContext.getCurrentInstance().addMessage("messageForm:checkboxWithWarning",
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "", "This is what a <i>warning</i> looks like."));
        }
    }

    public boolean isCbxInfo() {
        return cbxInfo;
    }

    public void setCbxInfo(boolean cbxInfo) {
        this.cbxInfo = cbxInfo;
        if (cbxInfo) {
            FacesContext.getCurrentInstance().addMessage("messageForm:checkboxWithInfoMessage",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "", "This is what an <i>info</i> message looks like."));
        }
    }

}
