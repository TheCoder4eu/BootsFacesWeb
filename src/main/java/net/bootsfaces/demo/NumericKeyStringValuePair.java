package net.bootsfaces.demo;

public class NumericKeyStringValuePair {

    private int key;
    private String value;

    public NumericKeyStringValuePair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
