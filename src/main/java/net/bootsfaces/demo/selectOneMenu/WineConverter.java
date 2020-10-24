package net.bootsfaces.demo.selectOneMenu;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Example taken from :
 * https://memorynotfound.com/using-custom-converter-for-hselectonemenu/
 */
@FacesConverter(forClass = Wine.class)
public class WineConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String wineId) {
        System.out.println("getAsObject:" + wineId);

        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),
                "#{beersBean}", BeersBean.class);

        BeersBean beers = (BeersBean) vex.getValue(ctx.getELContext());
        return beers.getWine(Integer.valueOf(wineId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object wine) {
        System.out.println("getAsString:" + wine);
        return ((Wine) wine).getId().toString();
    }
}
