package net.bootsfaces.demo.highFaces;

public class Birth {

    protected String year;
    protected Integer amount;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Birth() {
    }

    public Birth(String year, Integer amount) {
        this.year = year;
        this.amount = amount;
    }
}
