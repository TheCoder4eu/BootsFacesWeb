package issue908;
import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cartaportesFletConv")
public class CartaportesFletConv implements Converter, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        return (Flete) context.getApplication().evaluateExpressionGet(context, "#{cartaportesController}", CartaportesController.class)
                .getFletesMap().get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof Flete) ? ((Flete) value).getName() : "";
    }
}
