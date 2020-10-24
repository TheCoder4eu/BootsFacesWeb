package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@SessionScoped
public class SliderBean implements Serializable {

    private static final long serialVersionUID = -332002335165889800L;
    private int value1 = 10;
    private int value2 = 87;
    private int value3 = 84;
    private int value4 = 43;
    private int value5 = 12;
    private int value6 = 30;

    private int min = -10;
    private int max = 10;

    private float floatValue1 = 0f;

    @Min(18)
    @Max(65)
    private int age = 0;

    /**
     * Creates a new instance of informBean
     */
    public SliderBean() {
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getValue3() {
        return value3;
    }

    public void setValue3(int value3) {
        this.value3 = value3;
    }

    public int getValue4() {
        return value4;
    }

    public void setValue4(int value4) {
        this.value4 = value4;
    }

    public int getValue5() {
        return value5;
    }

    public void setValue5(int value5) {
        this.value5 = value5;
    }

    public int getValue6() {
        return value6;
    }

    public void setValue6(int value6) {
        this.value6 = value6;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public float getFloatValue1() {
        return floatValue1;
    }

    public void setFloatValue1(float floatValue1) {
        this.floatValue1 = floatValue1;
    }

}
