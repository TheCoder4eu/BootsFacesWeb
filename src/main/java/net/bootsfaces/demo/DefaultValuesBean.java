package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class DefaultValuesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean renderLabel = true;

    public boolean isRenderLabel() {
        return renderLabel;
    }

    public void setRenderLabel(boolean renderLabel) {
        this.renderLabel = renderLabel;
    }

    public void toggleRenderLabel() {
        renderLabel = !renderLabel;
    }
}
