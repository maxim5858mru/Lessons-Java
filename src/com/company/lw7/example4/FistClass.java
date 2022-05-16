package com.company.lw7.example4;

public class FistClass implements Cloneable {
    public Character symbols;

    private FistClass(FistClass object) {
        symbols = object.symbols;
    }

    public FistClass(char symbols) {
        this.symbols = symbols;
    }

    @Override
    public Object clone() {
        return new FistClass(this);
    }

    @Override
    public String toString() {
        return "FistClass{" +
                "symbols=" + symbols +
                '}';
    }
}