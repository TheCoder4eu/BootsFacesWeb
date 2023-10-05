package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
