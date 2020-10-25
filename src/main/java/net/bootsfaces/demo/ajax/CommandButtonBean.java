package net.bootsfaces.demo.ajax;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CommandButtonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message = "No action listener called yet.";

    private boolean suppressClick = true;
    private boolean suppressDoubleClick = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void onDoubleClick() {
        message = now() + " Double click";
    }

    public void onMouseOver() {
        message = now() + " Mouse over";
    }

    public void onMouseOut() {
        message = now() + " Mouse out";
    }

    public void onAction() {
        message = now() + " default action (click or return key)";
    }

    public boolean isSuppressDoubleClick() {
        return suppressDoubleClick;
    }

    public void setSuppressDoubleClick(boolean suppressDoubleClick) {
        this.suppressDoubleClick = suppressDoubleClick;
    }

    public boolean isSuppressClick() {
        return suppressClick;
    }

    public void setSuppressClick(boolean suppressClick) {
        this.suppressClick = suppressClick;
    }

    private String now() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    }
}
