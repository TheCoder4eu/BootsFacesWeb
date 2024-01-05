package net.bootsfaces.demo;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "StringToBooleanConverter")
public class StringToBooleanConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String s) {
        if (s != null && s.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object bool) {
        if (bool == null) {
            return "false";
        }
        if (bool.equals(Boolean.TRUE)) {
            return "true";
        }
        return "false";
    }
}
