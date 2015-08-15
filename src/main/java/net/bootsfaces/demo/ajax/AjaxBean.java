package net.bootsfaces.demo.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AjaxBean {
	
	private List<String> messages = new ArrayList<>();
	
	public AjaxBean() {
		getMessages().add("No message yet.");
		getMessages().add("Play with the comboboxes to add messages.");
	}
	private int jsf=1;

	private int js=1;

	private int desktop=1;

	public int getJsf() {
		return jsf;
	}
	
	private String now() {
		return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
	}

	public void setJsf(int brand) {
		this.jsf = brand;
		String msg="Take your time to think about the question. There's no hurry.";
		if (jsf==1) msg="Good choice, but think again.";
		if (jsf==2) msg="Yeah, good choice. BoosFaces rocks!";
		if (jsf==3) msg="That's the spirit. BootsFaces rocks, and always bet on Prime!";
		FacesMessage message = new FacesMessage(msg);
				FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public String onBlur() {
		messages.add(0, now() + " blur");
		return null;
	}

	public String onChange() {
		messages.add(0, now() + " onChange");
		return null;
	}
	public String onValueChange() {
		messages.add(0, now() + " valueChange");
		return null;
	}
	public String onClick() {
		messages.add(0, now() + " click");
		return null;
	}
	public String onDblClick() {
		messages.add(0, now() + " dblclick");
		return null;
	}
	public String onFocus() {
		messages.add(0, now() + " focus");
		return null;
	}
	public String onKeyDown() {
		messages.add(0, now() + " keydown");
		return null;
	}
	public String onKeyPress() {
		messages.add(0, now() + " keypress");
		return null;
	}
	public String onKeyUp() {
		messages.add(0, now() + " keyup");
		return null;
	}
	public String onMouseDown() {
		messages.add(0, now() + " mousedown");
		return null;
	}
	public String onMouseMove() {
		messages.add(0, now() + " mousemove");
		return null;
	}
	public String onMouseOut() {
		messages.add(0, now() + " mouseout");
		return null;
	}
	public String onMouseOver() {
		messages.add(0, now() + " mouseover");
		return null;
	}
	public String onMouseUp() {
		messages.add(0, now() + " mouseup");
		return null;
	}
	public String onSelect() {
		messages.add(0, now() + " select");
		return null;
	}

	public int getDesktop() {
		return desktop;
	}

	public void setDesktop(int desktop) {
		this.desktop = desktop;
		String msg="Take your time to think about the question. There's no hurry.";
		if (desktop==1) msg="Sounds like a sensible choice to me, provide you target the Windows platform.";
		if (desktop==2) msg="JavaFX is cool!";
		if (desktop==3) msg="GroovyFX is JavaFX on steroids.";
		if (desktop==4) msg="JSF is great, but don't forget about the alternatives.";
		FacesMessage message = new FacesMessage(msg);
				FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
		String msg="Take your time to think about the question. There's no hurry.";
		if (js==1) msg="It ain't that bad, you know.";
		if (js==2) msg="Indeed, rock it does.";
		if (js==3) msg="JSF still has an ace up in its sleeve.";
		FacesMessage message = new FacesMessage(msg);
				FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
