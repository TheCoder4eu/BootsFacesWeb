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
@FacesConverter(value = "beerConverter")
public class BeerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        System.out.println("getAsObject:" + beerId);

        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),
                "#{beersBean}", BeersBean.class);

        BeersBean beers = (BeersBean) vex.getValue(ctx.getELContext());
        return beers.getBeer(Integer.valueOf(beerId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
        System.out.println("getAsString:" + beer);
        return ((Beer) beer).getId().toString();
    }
}
