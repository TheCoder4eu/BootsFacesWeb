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

	private boolean modeInline = false;

	private boolean sideBySide=false;

	private boolean showTime=true;

	private boolean showDate=true;
	
	private boolean showIcon=true;
	
	private boolean iconLeft=false;
	
	private boolean allowInputToggle=false;
	
	private boolean useCurrent=true;

	public String getMode() {
		if (modeInline) {
			return "inline";
		}
		return "popup";
	}

	public boolean isModeInline() {
		return modeInline;
	}

	public void setModeInline(boolean modeInline) {
		this.modeInline = modeInline;
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

	public boolean isIconLeft() {
		return iconLeft;
	}

	public void setIconLeft(boolean iconLeft) {
		this.iconLeft = iconLeft;
	}

	public boolean isShowIcon() {
		return showIcon;
	}

	public void setShowIcon(boolean showIcon) {
		this.showIcon = showIcon;
	}
	
	public String getIconPosition() {
		if (iconLeft)
			return "left";
		else
			return "right";
	}

	public boolean isAllowInputToggle() {
		return allowInputToggle;
	}

	public void setAllowInputToggle(boolean allowInputToggle) {
		this.allowInputToggle = allowInputToggle;
	}

	public boolean isUseCurrent() {
		return useCurrent;
	}

	public void setUseCurrent(boolean useCurrent) {
		this.useCurrent = useCurrent;
	}

}
