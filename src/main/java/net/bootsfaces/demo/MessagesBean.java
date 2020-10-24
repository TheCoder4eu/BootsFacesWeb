package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import net.bootsfaces.utils.FacesMessages;

/**
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ManagedBean
@RequestScoped
public class MessagesBean implements Serializable {

    private static final long serialVersionUID = 5497787734011747081L;

    @Size(min = 1, max = 8)
    private String lastName;

    @Size(min = 3, max = 7)
    private String firstName;

    @Min(3)
    @Max(99)
    private int age;

    @Past
    private Date birthday;

    private String twoMessages;

    public MessagesBean() {
        FacesMessages.info("twoMessagesFormId:twoMessagesId", "Info message", "This is only an info message.");
        FacesMessages.error("twoMessagesFormId:twoMessagesId", "Error message", "This is an important error message.");
    }

    public void specificInfo() {
        FacesMessages.info("growlForm:ref", "Info", "This is a specific message!");
    }

    public void info() {
        FacesMessages.info("Info", "PrimeFaces <b>rocks</b>. BootsFaces <b>rocks</b>, too!");
    }

    public void warn() {
        FacesMessages.warning("Warning!", "Watch out for <i>PrimeFaces</i>. It's a good match to BootsFaces.");
    }

    public void error() {
        FacesMessages.error("Error!", "Something has gone <strong>wrong</strong>.");
    }

    public void fatal() {
        fatalSingle();
        FacesMessages.fatal("Fatal!", "Now it's too late to do anything. The system is down.");
        FacesMessages.info("Info", "Please shut down all systems!");
    }

    public void fatalSingle() {
        FacesMessages.fatal("Fatal!", "System Error. What did <u>you</u> do?");
    }

    /**
     * Create a global message of each severity.
     */
    public void messageOfEachSeverity() {
        info();
        warn();
        error();
        fatalSingle();
    }

    public void showMessages() {
        FacesMessages.info("Info message", "This is a very informative message.");
    }

    public void info(ActionEvent event) {
        String[] messages = {"<b>BootsFaces</b> rocks!", "How do you like <b>this message</b>?", "This message has been brought to <b>you</b> by an actionListener."};
        int index = (int) (Math.random() * messages.length);
        FacesMessages.info("Info", messages[index]);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void update() {

    }

    public String getTwoMessages() {
        return twoMessages;
    }

    public void setTwoMessages(String twoMessages) {
        this.twoMessages = twoMessages;
    }
}
