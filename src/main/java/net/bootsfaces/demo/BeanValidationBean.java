package net.bootsfaces.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class BeanValidationBean {

    @NotNull(message = "Your name is as important as you are. Don't hesitate to fill this field!")
    @Size(min = 1, max = 10)
    private String name;

    @Min(value = 18, message = "In most countries, you're not considered a grown-up yet.")
    @Max(value = 65, message = "In many countries, you've already reached retirement age.")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
