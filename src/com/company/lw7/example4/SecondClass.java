package com.company.lw7.example4;

public class SecondClass extends FistClass implements Cloneable {
    public String text;

    private SecondClass(SecondClass object) {
        super(object.symbols);
        text = object.text;
    }

    public SecondClass(char symbols, String text) {
        super(symbols);
        this.text = text;
    }

    @Override
    public Object clone() {
        return new SecondClass(this);
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "text='" + text + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}