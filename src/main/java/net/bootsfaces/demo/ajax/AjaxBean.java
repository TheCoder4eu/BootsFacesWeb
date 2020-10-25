package net.bootsfaces.demo.ajax;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class AjaxBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> messages = new ArrayList<>();

    public AjaxBean() {
        getMessages().add("No message yet.");
        getMessages().add("Play with the AJAXified widget to add messages.");
    }
    private int jsf = 1;

    private int js = 1;

    private int desktop = 1;

    private boolean spinning = true;
    private boolean readOnly = false;
    private boolean disabled = false;

    public int getJsf() {
        return jsf;
    }

    private String now() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    }

    public void setJsf(int brand) {
        this.jsf = brand;
        String msg = "Take your time to think about the question. There's no hurry.";
        if (jsf == 1) {
            msg = "Good choice, but think again.";
        }
        if (jsf == 2) {
            msg = "Yeah, good choice. BoosFaces rocks!";
        }
        if (jsf == 3) {
            msg = "That's the spirit. BootsFaces rocks, and always bet on Prime!";
        }
        FacesMessage message = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    private int counter = 0;

    private String lastMessage = null;

    private boolean bool;

    private String input = "Ignore the text. It's not important.";

    private int brand = 1;

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
        messages.add(0, now() + " Setter has been called: " + brand);
    }

    public String onBlur() {
        String event = " blur";
        report(event);
        return "Hallo";
    }

    public String onBlur(AjaxBehaviorEvent e) {
        String event = " blur (traditional JSF)";
        report(event);
        return "Hallo";
    }

    private void report(String event) {
        if (event.equals(lastMessage)) {
            counter++;
            messages.set(0, now() + event + " (" + counter + ")");
        } else {
            counter = 1;
            messages.add(0, now() + event);
        }
        lastMessage = event;

    }

    public String onChange() {
        String event = " change";
        report(event);
        return "Hallo";
    }

    public String onChange(AjaxBehaviorEvent e) {
        String event = "  (traditional JSF)";
        report(event);
        return "Hallo";
    }

    public String onValueChange() {
        String event = " valueChange";
        report(event);
        return "Hallo";
    }

    public String onClick() {
        String event = " click";
        report(event);
        return "Hallo";
    }

    public String onDblClick() {
        String event = " dblclick";
        report(event);
        return "Hallo";
    }

    public String onFocus() {
        String event = " focus";
        report(event);
        return "Hallo";
    }

    public String onKeyDown() {
        String event = " keydown";
        report(event);
        return "Hallo";
    }

    public String onKeyPress() {
        String event = " keypress";
        report(event);
        return "Hallo";
    }

    public String onKeyUp() {
        String event = " keyup";
        report(event);
        return "Hallo";
    }

    public String onMouseDown() {
        String event = " mousedown";
        report(event);
        return "Hallo";
    }

    public String onMouseMove() {
        String event = " mousemove";
        report(event);
        return "Hallo";
    }

    public String onMouseOut() {
        String event = " mouseout";
        report(event);
        return "Hallo";
    }

    public String onMouseOver() {
        String event = " mouseover";
        report(event);
        return "Hallo";
    }

    public String onMouseUp() {
        String event = " mouseup";
        report(event);
        return "Hallo";
    }

    public String onSelect() {
        String event = " select";
        report(event);
        return "Hallo";
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getDesktop() {
        return desktop;
    }

    public void setDesktop(int desktop) {
        this.desktop = desktop;
        String msg = "Take your time to think about the question. There's no hurry.";
        if (desktop == 1) {
            msg = "Sounds like a sensible choice to me, provided you target the Windows platform.";
        }
        if (desktop == 2) {
            msg = "JavaFX is cool!";
        }
        if (desktop == 3) {
            msg = "GroovyFX is JavaFX on steroids.";
        }
        if (desktop == 4) {
            msg = "JSF is great, but don't forget about the alternatives.";
        }
        FacesMessage message = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getJs() {
        return js;
    }

    public void setJs(int js) {
        this.js = js;
        String msg = "Take your time to think about the question. There's no hurry.";
        if (js == 1) {
            msg = "It ain't that bad, you know.";
        }
        if (js == 2) {
            msg = "Indeed, rock it does.";
        }
        if (js == 3) {
            msg = "JSF still has an ace up in its sleeve.";
        }
        FacesMessage message = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String onPanelCollapseStart() {
        String event = " panel starts to collapse";
        report(event);
        return null;
    }

    public String onPanelCollapsed() {
        String event = " panel finished collapsing";
        report(event);
        return null;
    }

    public String onPanelExpandStart() {
        String event = " panel starts to expand";
        report(event);
        return null;
    }

    public String onPanelExpanded() {
        String event = " panel finished expanding";
        report(event);
        return null;
    }

    public String onCarouselSlideStart() {
        String event = " carousel started to slide";
        report(event);
        return null;
    }

    public String onCarouselSlid() {
        String event = " carousel finished sliding";
        report(event);
        return null;
    }

    public boolean isSpinning() {
        return spinning;
    }

    public void setSpinning(boolean spinning) {
        this.spinning = spinning;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
