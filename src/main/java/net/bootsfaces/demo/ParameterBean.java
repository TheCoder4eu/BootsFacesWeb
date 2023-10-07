package net.bootsfaces.demo;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;
import java.util.Map;


import net.bootsfaces.utils.FacesMessages;

@Named
@ViewScoped
public class ParameterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Min(1)
    @Max(10)
    private int parameter = 2;

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    public void submitParameter(int parameter) {
        this.parameter = parameter;
        FacesMessages.info("Parameter passed: " + parameter);
    }

    public void submitParameter() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            int parameter = new Integer(params.get("myParameter"));

            this.parameter = parameter;
            FacesMessages.error("Parameter passed: " + parameter);
        } catch (NumberFormatException e) {
            FacesMessages.error("Couldn't parse the number");
        }
    }

}
