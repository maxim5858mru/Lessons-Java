package com.company.lw7.example1;

public class SuperClass {
    protected String firstText;

    public SuperClass(String text) {
        this.firstText = text;
    }

    @Override
    public String toString() {
        return "Superclass{" +
                "text='" + firstText + '\'' +
                '}';
    }
}
