/*
 * A Bean Used for Demo purposes
 */
package net.bootsfaces.demo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.bootsfaces.utils.BsfUtils;
import net.bootsfaces.utils.LocaleUtils;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@RequestScoped
public class DateTimeBean implements Serializable {

    private static final long serialVersionUID = -7642332089180105956L;
    private Date justNow = new Date();

    private boolean modeInline = false;

    private boolean sideBySide = false;

    private boolean showTime = true;

    private boolean showDate = true;

    private boolean showIcon = true;

    private boolean iconLeft = false;

    private boolean allowInputToggle = false;

    private boolean useCurrent = true;

    private String disabledDates = null;

    private String weekDaysDisabled = null;

    private String locale = Locale.getDefault().getLanguage();

    private String momentJSFormatString = null;

    private String javaFormatString = null;

    private static ScriptEngine scriptEngine;

    private static List<String> locales = new ArrayList<String>();

    private static final Comparator<Object> FORMAT_COMPARATOR = new Comparator<Object>() {

        @Override
        public int compare(Object o1, Object o2) {
            String k1 = (String) ((Entry) o1).getKey();
            String k2 = (String) ((Entry) o2).getKey();
            int result = k1.substring(0, 1).toUpperCase().compareTo(k2.substring(0, 1).toUpperCase());
            if (result == 0) {
                result = k1.substring(0, 1).compareTo(k2.substring(0, 1));
            }
            if (result == 0) {
                result = k1.compareTo(k2);
            }
            return result;
        }
    };

    private static final HashMap<String, String> momentToJava = new HashMap<String, String>() {
        {
            put("d", " (day in week - 0=Sunday, 6=Saturday");
            put("D", "d (day in month - one or two digits)");
            put("DD", "dd (day in month - two digits)");
            put("Do", "(day of month with ordinal)");
            put("Y", "(year - any number of digits and sign");
            put("YY", "yy (year - two digits)");
            put("YYYY", "yyyy (year - all digits)");
            put("a", "(am or pm)");
            put("A", "a (AM or PM)");
            put("M", "M (month in year - two digits, 01..12)");
            put("MM", "MM (month in year - two digits, 01..12)");
            put("MMM", "MMM (month in year - short text)");
            put("MMMM", "MMMM (month in year - full text)");
            put("h", "h (hour - one or two digits, 12 hours, 1..12)");
            put("hh", "hh (hour - two or two digits, 12 hours, 01..12)");
            put("H", "H (hour - one or two digits, 24 hours, 0..23)");
            put("HH", "HH (hour - two digits, 24 hours, 00..23)");
            put("k", "k (hour - one or two digits, 24 hours, 1..24)");
            put("kk", "kk (hour - two digits, 24 hours, 01..24)");
            put("m", "m (minutes - one or two digits)");
            put("mm", "mm (minutes - two digits)");
            put("s", "s (seconds - one or two digits)");
            put("ss", "ss (second - two digits)");
            put("S", "S (fractional seconds - 0...999");
            put("SS", "SS (fractional seconds - 00...999");
            put("SSS", "SSS (fractional seconds - 000...999");
            put("ddd", "E (day name - short)");
            put("dddd", "EEEE (day name - full)");
            put("DDD", "D (day in year)");
            put("DDDD", "DDD (day in year)");
            put("W", "w (week in year - one or two digits, 1..53)");
            put("WW", "ww (week in year - two digits, 01..53)");
            put("w", "(locale week in year - one or two digits, 1..53)");
            put("ww", "(locale week in year - two digits, 01..53)");
            put("ZZ", "ZZ (offset from UTC)");
            put("Z", "XXX (offset from UTC)");
            put("E", "u (ISO day of week - 1..7)");
            put("e", "(Locale day of week - 0..6)");
            put("Q", "(quarter in year - 1..4");
            put("X", "(UNIX timestamp)");
            put("x", "(UNIX timestamp - milliseconds)");
            put("[", "' (escape character)");
            put("]", "' (escape character)");
        }
    };

    @SuppressWarnings("serial")
    public static final HashMap<String, String> javaToMoment = new HashMap<String, String>() {
        {
            put("d", "D (day in month - one or two digits)");
            put("dd", "DD (day in month - two digits)");
            put("D", "DDD (day in year - one to three digits)");
            put("DD", "(day in year- two or three digits)");
            put("DDD", "DDDD (day in year- three digits)");
            put("F", "(day of week in month)");
            put("y", "YYYY (year - every digit)");
            put("yy", "YY (year - two digits)");
            put("yyy", "YYYY (year - three digits)");
            put("yyyy", "YYYY (year - every digit)");
            put("Y", "(week year - two digits)");
            put("YY", "gg (week year - two digits)");
            put("YYY", "(week year - three digits)");
            put("YYYY", "gggg (week year - all digits)");
            put("a", "A (AM or PM)");
            put("G", "(era - AD or BC)");
            put("M", "M (month in year - two digits, 1..12)");
            put("MM", "MM (month in year - two digits, 01..12)");
            put("MMM", "MMM (month in year - short text)");
            put("MMMM", "MMMM  (month in year - full text)");
            put("h", "h (hour - one or two digits, 12 hours, 1..12)");
            put("hh", "hh (hour - two digits, 12 hours, 01..12)");
            put("H", "H  (hour - one or two digits, 24 hours, 0..23)");
            put("HH", "HH (hour - two digits, 24 hours, 00..23)");
            put("k", "k (hour - one or two digits, 12 hours, 1..24)");
            put("kk", "kk (hour - two digits, 24 hours, 01..24)");
            put("K", "(hour - one or two digits, 12 hours, 0..11)");
            put("KK", "(hour - two digits, 12 hours, 00..11)");
            put("m", "m (minutes - one or two digits)");
            put("mm", "mm (minutes - two digits)");
            put("s", "s (seconds- one or two digits)");
            put("ss", "ss (seconds - two digits)");
            put("S", "S (millisecond)");
            put("SS", "SS  (millisecond)");
            put("SSS", "SSS  (millisecond)");
            put("E", "ddd (day name in week - short)");
            put("EE", "ddd  (day name in week - short)");
            put("EEE", "ddd  (day name in week - short)");
            put("EEEE", "dddd  (day name in week - full)");
            put("w", "W (week in year - one or two digits)");
            put("ww", "WW (week in year - two digits, zero-padded)");
            put("W", "(week in month - one or two digits)");
            put("WW", "(week in month - two digits, zero-padded)");
            put("z", "(General time zone)");
            put("zz", "(General time zone)");
            put("zzz", "(General time zone)");
            put("zzzz", "(General time zone)");
            put("Z", "ZZ (RFC 822 time zone)");
            put("X", "(ISO 8601 time zone -  - hours only)");
            put("XX", "ZZ (ISO 8601 time zone - short)");
            put("XXX", "Z (ISO 8601 time zone - long)");
            put("u", "E (day number of week - 1=Monday, 7=Sunday)");
            put("'", "[] (escape character)");
        }
    };

    static Map<Integer, String> predefinedJavaFormats = new HashMap<Integer, String>();
    static List<String> predefinedMomentjsFormats = new ArrayList<String>();

    static {
        for (Locale locale : DateFormat.getAvailableLocales()) {
            String l = locale.getLanguage();
            if (!locales.contains(l)) {
                locales.add(l);
            }
            Collections.sort(locales);
        }
        predefinedJavaFormats.put(SimpleDateFormat.SHORT, "SimpleDateFormat.SHORT");
        predefinedJavaFormats.put(SimpleDateFormat.MEDIUM, "SimpleDateFormat.MEDIUM");
        predefinedJavaFormats.put(SimpleDateFormat.LONG, "SimpleDateFormat.LONG");
        predefinedJavaFormats.put(SimpleDateFormat.FULL, "SimpleDateFormat.FULL");

        predefinedMomentjsFormats.add("LT");
        predefinedMomentjsFormats.add("LTS");
        predefinedMomentjsFormats.add("L");
        predefinedMomentjsFormats.add("l");
        predefinedMomentjsFormats.add("LL");
        predefinedMomentjsFormats.add("ll");
        predefinedMomentjsFormats.add("LLL");
        predefinedMomentjsFormats.add("lll");
        predefinedMomentjsFormats.add("LLLL");
        predefinedMomentjsFormats.add("llll");

        loadMomentSource();

    }

    private static void loadMomentSource() {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("META-INF/resources/bsf/js/moment-with-locales.min.js");
        Reader reader = new InputStreamReader(is);
        ScriptEngineManager manager = new ScriptEngineManager();
        scriptEngine = manager.getEngineByName("JavaScript");
        try {
            scriptEngine.eval(reader);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public String formatDateAsMomentJSDate() {
        if (momentJSFormatString == null || momentJSFormatString.equals("")) {
            return "";
        }
        try {
            String variableName = "z" + (new Date()).getTime();
            String jsFormat = momentJSFormatString.replace("'", "\\'");
            String javascript = "moment.locale('" + locale + "');" + "var " + variableName + " = moment().lang('"
                    + locale + "').format('" + jsFormat + "');";
            scriptEngine.eval(javascript);
            String variable = (String) scriptEngine.get(variableName);
            return variable;
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    public String formatDateAsJavaDate() {
        if (javaFormatString == null || javaFormatString.equals("")) {
            return "";
        }
        Date date = new Date();
        try {
            return new SimpleDateFormat(javaFormatString).format(date);
        } catch (IllegalArgumentException ex) {
            return "wrong date pattern: " + javaFormatString + " more details: " + ex.getMessage();
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

    public String updateSettings2() {
        return "index.jsf#interactiveCheatSheet";
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
            justNow = new Date();
        }
        this.showDate = showDate;
    }

    public boolean isShowTime() {
        return showTime;
    }

    public void setShowTime(boolean showTime) {
        if (this.showTime != showTime) {
            justNow = new Date();
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
        if (iconLeft) {
            return "left";
        } else {
            return "right";
        }
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
            format = null;
        }
        if ("".equals(locale)) {
            locale = null;
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        Locale sloc = BsfUtils.selectLocale(fc.getViewRoot().getLocale(), locale, null);
        String formatString = BsfUtils.selectJavaDateTimeFormatFromMomentJSFormatOrDefault(sloc, format, showDate,
                showTime);
        String displayFormat = (format == null ? LocaleUtils.javaToMomentFormat(formatString) : formatString);
        return displayFormat;
    }

    public String getMomentJSFormatFromJavaFormat() {
        if (javaFormatString == null) {
            return "";
        }

        String displayFormat = LocaleUtils.javaToMomentFormat(javaFormatString);
        return displayFormat;
    }

    public String getJavaFormatFromMomentJSFormat() {
        if (momentJSFormatString == null) {
            return "";
        }

        String displayFormat = LocaleUtils.momentToJavaFormat(momentJSFormatString);
        return displayFormat;
    }

    public String getMomentJSFormatString() {
        return momentJSFormatString;
    }

    public void setMomentJSFormatString(String momentJSFormatString) {
        try {
            this.momentJSFormatString = momentJSFormatString;
            if (momentJSFormatString == null || momentJSFormatString.equals("")) {
                this.javaFormatString = "";
            } else {
                this.javaFormatString = LocaleUtils.momentToJavaFormat(momentJSFormatString);
            }
        } catch (Exception e) {
            javaFormatString = "(an error occurred: " + e.getClass().getSimpleName() + " " + e.getMessage() + ")";
        }
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
            locale = null;
        }
        Locale sloc = BsfUtils.selectLocale(fc.getViewRoot().getLocale(), locale, null);
        String formatString = BsfUtils.selectJavaDateTimeFormatFromMomentJSFormatOrDefault(sloc, null, showDate,
                showTime);
        return formatString;
    }

    public String getSDFFormat() {
        String momentJSFormatString = getMomentJSDateFormat();
        return LocaleUtils.momentToJavaFormat(momentJSFormatString);
    }

    public List<String> getLocales() {
        return locales;
    }

    public HashMap<String, String> getJavaToMoment() {
        return javaToMoment;
    }

    public HashMap<String, String> getMomentToJava() {
        return momentToJava;
    }

    public String getFormattedDate(String formatString) {
        try {
            if (formatString == null || formatString.length() == 0) {
                return "";
            }
            if (formatString.trim().startsWith("(")) {
                return "";
            }
            if (formatString.contains("(")) {
                formatString = formatString.substring(0, formatString.indexOf("("));
            }
            formatString = formatString.trim();
            if ("'".equals(formatString) || "''".equals(formatString)) {
                return "(not printed)";
            }
            return new SimpleDateFormat(formatString, new Locale(locale)).format(new Date()).trim();
        } catch (Exception e) {
            return "illegal pattern: " + formatString;
        }
    }

    public String pattern(String s) {
        String[] parts = s.split("\\(");
        return parts[0];
    }

    public String description(String s) {
        String[] parts = s.split("\\(");
        return parts[1].substring(0, parts[1].length() - 1);
    }

    public Object[] sortedJavaToMoment() {
        Object[] entries = javaToMoment.entrySet().toArray();
        Arrays.sort(entries, FORMAT_COMPARATOR);
        return entries;
    }

    public Object[] sortedMomentToJava() {

        Object[] entries = momentToJava.entrySet().toArray();
        Arrays.sort(entries, FORMAT_COMPARATOR);
        return entries;
    }

    public String getPredefinedDate(int format) {
        return DateFormat.getDateInstance(format, new Locale(locale)).format(new Date());
    }

    public String getPredefinedDateTime(int df, int tf) {
        return DateFormat.getDateTimeInstance(df, tf, new Locale(locale)).format(new Date());
    }

    public String getPredefinedTime(int format) {
        return DateFormat.getTimeInstance(format, new Locale(locale)).format(new Date());
    }

    public String getJavaFormatString() {
        return javaFormatString;
    }

    public void setJavaFormatString(String javaFormatString) {
        try {
            this.javaFormatString = javaFormatString;
            if (javaFormatString == null || javaFormatString.equals("")) {
                momentJSFormatString = "";
            } else {
                momentJSFormatString = LocaleUtils.javaToMomentFormat(javaFormatString);
            }
        } catch (Exception e) {
            momentJSFormatString = "(an error occurred: " + e.getClass().getSimpleName() + " " + e.getMessage() + ")";
        }
    }

    public String getWeekDaysDisabled() {
        return weekDaysDisabled;
    }

    public boolean isDisableWeekend() {
        return weekDaysDisabled != null;
    }

    public void setDisableWeekend(boolean value) {
        if (value) {
            this.weekDaysDisabled = "6,0";
        } else {
            this.weekDaysDisabled = null;
        }
    }

    public String getDisabledDates() {
        return this.disabledDates;
    }

    public boolean isDisabledDatesActive() {
        return null != this.disabledDates;
    }

    public void setDisabledDatesActive(boolean value) {
        if (value) {
            this.disabledDates = "'08/03/2019', new Date(2019, 8-1,4), moment('08/05/2019')";
        } else {
            this.disabledDates = null;
        }
    }
}
