package net.bootsfaces.demo.converters;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("de.beyondjava.vatConverter")
public class VatConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (null == value) {
            return null;
        }
        if (value.equals("false")) {
            return 0;
        }
        return 7;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (null == value) {
            return null;
        }
        if (value instanceof Number) {
            int v = ((Number) value).intValue();
            if (v == 0) {
                return "false";
            }
            return "true";
        }
        return null;

    }
}
