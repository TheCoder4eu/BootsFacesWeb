package net.bootsfaces.issues.modalRelead;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;


import net.bootsfaces.utils.FacesMessages;

@Named
@SessionScoped
public class ModalReloadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String someValue = "Original value";

    private int counter = 0;

    private Part file; // +getter+setter

    public ModalReloadBean() {
        System.out.println("New bean created");
    }

    public void save() {
        FacesMessages.info("File " + file.getSubmittedFileName() + " uploaded: " + file.getSize() + " bytes");
    }

    public String getSomeValue() {
        if (counter > 0) {
            return counter + this.someValue;
        }
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public void closeAndReload() throws IOException {
        this.someValue = " server-side reloads";
        counter++;
        reload();
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getUploadSuccessfull() {
        if (null == file) {
            return "no file uploaded";

        }
        return "upload successful";
    }

}
