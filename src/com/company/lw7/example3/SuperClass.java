package com.company.lw7.example3;

public class SuperClass {
    public Integer number;

    public SuperClass(int number) {
        this.number = number;
    }

    public void set(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "number=" + number +
                '}';
    }
}