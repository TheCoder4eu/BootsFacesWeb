package net.bootsfaces.demo;

import java.io.Serializable;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean
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
