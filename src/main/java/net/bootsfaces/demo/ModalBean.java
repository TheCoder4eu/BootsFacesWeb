package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class ModalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int backupPeriod = 42;

    public int getBackupPeriod() {
        return backupPeriod;
    }

    public void setBackupPeriod(int backupPeriod) {
        this.backupPeriod = backupPeriod;
    }

}
