package net.bootsfaces.issues.issue918;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean
public class HazardOriginConverter_ implements Converter {

    Domains domains = new Domains();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        // return domains.getHazardOrigins().stream().filter(p -> string.equals(p.getCode())).findFirst().orElse(null);
        for (HazardOrigin_ p : domains.getHazardOrigins()) {
            if (string.equals(p.getCode())) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return "";
        }

        if (t instanceof HazardOrigin_) {
            return ((HazardOrigin_) t).getCode();
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Option", t)));
        }
    }
}
