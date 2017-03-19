/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.bootsfaces.utils.BsfUtils;
import net.bootsfaces.utils.LocaleUtils;

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
	
	private String locale = null;
	
	private String momentJSFormatString = null;
	
	private static List<String> locales = new ArrayList<String>();
	
	static {
		for (Locale locale : DateFormat.getAvailableLocales()) {
			String l = locale.getLanguage();
			if (!locales.contains(l))
				locales.add(l) ;
			Collections.sort(locales);
		}
	}

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
	
	public String showDateFormat(String locale, String format, boolean showDate, boolean showTime) {
		if ("".equals(format)) {
			format=null;
		}
		if ("".equals(locale)) {
			locale=null;
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		Locale sloc = BsfUtils.selectLocale(fc.getViewRoot().getLocale(), locale, null);
		String formatString = BsfUtils.selectDateTimeFormat(sloc, format, showDate, showTime);
		String displayFormat = (format == null ? LocaleUtils.javaToMomentFormat(formatString) : formatString);
		return displayFormat;
	}

	public String getMomentJSFormatString() {
		return momentJSFormatString;
	}

	public void setMomentJSFormatString(String momentJSFormatString) {
		this.momentJSFormatString = momentJSFormatString;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getMomentJSDateFormat() {
		return showDateFormat(locale, momentJSFormatString, showDate, showTime);
	}
	
	public String getDefaultSDFFormat() {
		FacesContext fc = FacesContext.getCurrentInstance();
		if ("".equals(locale)) {
			locale=null;
		}
		Locale sloc = BsfUtils.selectLocale(fc.getViewRoot().getLocale(), locale, null);
		String formatString = BsfUtils.selectDateTimeFormat(sloc, null, showDate, showTime);
		return formatString;
	}
	
	public String getSDFFormat() {
		String momentJSFormatString = getMomentJSDateFormat();
		return LocaleUtils.momentToJavaFormat(momentJSFormatString);
	}

	public List<String> getLocales() {
		return locales;
	}
}
