package net.bootsfaces.issues.so01092019;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("so01092019")
@RequestScoped
public class So01092019 {

    private String msg = null;

    public void setMessage(final String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

    public void submit() {
        //do some business logic here
    }
}
