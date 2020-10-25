package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
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
