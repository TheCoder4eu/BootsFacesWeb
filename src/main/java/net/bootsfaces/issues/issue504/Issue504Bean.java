package net.bootsfaces.issues.issue504;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Issue504Bean {

    private Integer number1;
    private Integer number2;
    private Integer sum;

    public void actionAdd() {
        if (number1 != null && number2 != null){
            sum = number1 + number2;
        }
    }

    public Integer getNumber1() {
        return number1;
    }
    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }
    public Integer getNumber2() {
        return number2;
    }
    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }
    public Integer getSum() {
        return sum;
    }
    public void setSum(Integer sum) {
        this.sum = sum;
    }

}