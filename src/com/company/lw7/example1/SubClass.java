package com.company.lw7.example1;

public class SubClass extends SuperClass {
    protected String secondText;

    public SubClass(String text) {
        super(text);
    }

    public SubClass(String firstText, String secondText) {
        super(firstText);
        this.secondText = secondText;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "firstText='" + firstText + '\'' +
                ", secondText='" + secondText + '\'' +
                '}';
    }
}
