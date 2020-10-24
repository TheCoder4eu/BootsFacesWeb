package net.bootsfaces.demo;

/*
 * A Bean Used for Demo purposes
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author TheCoder4eu
 */
@ManagedBean
@ViewScoped
public class TestBean implements Serializable {

    private static final long serialVersionUID = -332002335165889800L;
    private int val1 = 78;
    private int val2 = 87;
    private int val3 = 34;
    private int val4 = 43;
    private int val5 = 12;
    private int val6 = 30;
    private String label1 = "Label One";
    private String label2 = "Label Two";
    private String text1 = "Text One";
    private String text2 = "Text Two";
    private List<Calculation> tabs = new ArrayList<>();

    private Calculation calc = new Calculation("static calculation");

    private boolean contentDisabled = false;

    private int index = 2;

    private Calculation selectedTab = null;

    public void nextTab() {
        index++;
        if (index > 3) {
            index = 0;
        }
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public int getVal3() {
        return val3;
    }

    public void setVal3(int val3) {
        this.val3 = val3;
    }

    public int getVal4() {
        return val4;
    }

    public void setVal4(int val4) {
        this.val4 = val4;
    }

    public int getVal5() {
        return val5;
    }

    public void setVal5(int val5) {
        this.val5 = val5;
    }

    public int getVal6() {
        return val6;
    }

    public void setVal6(int val6) {
        this.val6 = val6;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    /**
     * Creates a new instance of informBean
     */
    public TestBean() {
        tabs.add(new Calculation("first tab"));
        tabs.add(new Calculation("second tab"));
        tabs.add(new Calculation("third tab"));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isContentDisabled() {
        return contentDisabled;
    }

    public void setContentDisabled(boolean contentDisabled) {
        this.contentDisabled = contentDisabled;
    }

    // dummy method for AJAX
    public void onClick() {

    }

    public List<Calculation> getTabs() {
        return tabs;
    }

    public Calculation getCalc() {
        return calc;
    }

    public void setCalc(Calculation calc) {
        this.calc = calc;
    }

    public void removeTab() {
        String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("title");
        for (Calculation t : tabs) {
            if (t.title.equals(title)) {
                tabs.remove(t);
                break;
            }
        }

    }

    public class Calculation {

        private String title;
        private int summand1 = (int) (Math.random() * 100.0d);
        private int summand2 = (int) (Math.random() * 100.0d);
        private int sum = 0;

        public Calculation(String title) {
            this.title = title;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getSummand1() {
            return summand1;
        }

        public void setSummand1(int summand1) {
            this.summand1 = summand1;
        }

        public int getSummand2() {
            return summand2;
        }

        public void setSummand2(int summand2) {
            this.summand2 = summand2;
        }

        public void add() {
            sum = summand1 + summand2;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
}
