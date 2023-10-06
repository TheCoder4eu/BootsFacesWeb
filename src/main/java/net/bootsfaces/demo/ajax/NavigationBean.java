package net.bootsfaces.demo.ajax;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
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
