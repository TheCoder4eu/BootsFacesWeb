package net.bootsfaces.demo.ajax;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String page = "start.xhtml";

    public String getPage() {
        return page;
    }

    public void setPage(String currentPage) {
        this.page = currentPage;
    }

    public String register() {
        this.page = "register.xhtml";
        return null;
    }

    public String start() {
        this.page = "start.xhtml";
        return null;
    }
}
