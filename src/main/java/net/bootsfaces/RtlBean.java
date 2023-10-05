package net.bootsfaces;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;


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
