/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@RequestScoped
public class DateBean implements Serializable {
	private static final long serialVersionUID = -7642332089180105956L;
	private Date adate;
    private Date bdate;
    private Date cdate;
    private Date ddate;
    private Date edate;
    private Date fdate;

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    /**
     * Creates a new instance of DateBean
     */
    public DateBean() {
    }
}
