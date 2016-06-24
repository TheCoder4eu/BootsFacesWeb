/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class DateTimeBean implements Serializable {
	private static final long serialVersionUID = -7642332089180105956L;
	private Date justNow = new Date();

	private boolean modePlain = false;

	private boolean modeInline = false;

	private boolean modePopup = false;

	private boolean sideBySide=false;

	private boolean showTime=true;

	private boolean showDate=true;

	public String getMode() {
		if (modePlain) {
			modeInline=false;
			modePopup=false;
			return "plain";
		}
		if (modeInline) {
			modePopup=false;
			return "inline";
		}
		if (modePopup) {
			return "popup";
		}
		return "component";
	}

	public boolean isModePlain() {
		return modePlain;
	}

	public void setModePlain(boolean modePlain) {
		this.modePlain = modePlain;
	}

	public boolean isModeInline() {
		return modeInline;
	}

	public void setModeInline(boolean modeInline) {
		this.modeInline = modeInline;
	}

	public boolean isModePopup() {
		return modePopup;
	}

	public void setModePopup(boolean modePopup) {
		this.modePopup = modePopup;
	}

	public Date getJustNow() {
		return justNow;
	}

	public void setJustNow(Date today) {
		this.justNow = today;
	}

	public void updateSettings() {

	}

	public boolean isSideBySide() {
		return sideBySide;
	}

	public void setSideBySide(boolean sideBySide) {
		this.sideBySide = sideBySide;
	}

	public boolean isShowDate() {
		return showDate;
	}

	public void setShowDate(boolean showDate) {
		if (this.showDate != showDate) {
			justNow=new Date();
		}
		this.showDate = showDate;
	}

	public boolean isShowTime() {
		return showTime;
	}

	public void setShowTime(boolean showTime) {
		if (this.showTime != showTime) {
			justNow=new Date();
		}
		this.showTime = showTime;
	}

}
