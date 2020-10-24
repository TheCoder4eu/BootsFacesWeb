package net.bootsfaces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class RtlBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean rtl = false;

    public boolean isRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public String getDirection() {
        return rtl ? "rtl" : "ltr";
    }

    public void toggleRTL() {
    }
}
