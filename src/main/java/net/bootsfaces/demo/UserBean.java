package net.bootsfaces.demo;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class UserBean {

    @Size(min = 1, max = 10)
    private String name;

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
