package com.company.lw7.example2;

public class SubClass extends SuperClass {
    private Integer number;

    public SubClass(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void set() {
        super.set();
        number = null;
    }

    @Override
    public void set(String text) {
        super.set(text);
    }

    public void set(int number) {
        this.number = number;
    }

    public void set(String text, int number) {
        super.set(text);
        this.number = number;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "text.length()=" + length() +
                ", number=" + number +
                '}';
    }
}