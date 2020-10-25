package net.bootsfaces.demo.forms;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FormBean {

    private int inputText = 0;
    private int inputTextarea = 0;
    private String color = "#ff0000";
    private Date date = new Date();
    private String combobox = "1";

    public int getInputText() {
        return inputText;
    }

    public void setInputText(int inputText) {
        this.inputText = inputText;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCombobox() {
        return combobox;
    }

    public void setCombobox(String combobox) {
        this.combobox = combobox;
    }

    public void updateInputText() {
        inputText = (int) (Math.random() * 1000);
    }

    public void updateInputTextarea() {
        inputTextarea = (int) (Math.random() * 1000);
    }

    public void updateCombobox() {
        combobox = String.valueOf((int) (Math.random() * 3.0));
    }

    public void updateColor() {
        color = "#" + Integer.toHexString((int) (Math.random() * 0xffffff));
    }

    public void updateDate() {
        date = new Date(date.getTime() + 86400 * 1000);
    }

    public int getInputTextarea() {
        return inputTextarea;
    }

    public void setInputTextarea(int inputTextarea) {
        this.inputTextarea = inputTextarea;
    }

}
