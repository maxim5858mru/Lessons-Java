package com.company.lw7.example3;

public class FirstSubClass extends SuperClass {
    public Character symbol;

    public FirstSubClass(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void set(int number, char symbol) {
        set(number);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "FirstSubClass{" +
                "symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}