package com.company.lw7.example3;

public class SecondSubClass extends FirstSubClass {
    public String text;

    public SecondSubClass(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    public void set(int number, char symbol, String text) {
        set(number, symbol);
        this.text = text;
    }

    @Override
    public String toString() {
        return "SecondSubClass{" +
                "text='" + text + '\'' +
                ", symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}
