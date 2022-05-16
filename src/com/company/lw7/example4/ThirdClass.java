package com.company.lw7.example4;

public class ThirdClass extends SecondClass implements Cloneable {
    public Integer number;

    private ThirdClass(ThirdClass object) {
        super(object.symbols, object.text);
        number = object.number;
    }

    public ThirdClass(char symbols, String text, int number) {
        super(symbols, text);
        this.number = number;
    }

    @Override
    public Object clone() {
        return new ThirdClass(this);
    }

    @Override
    public String toString() {
        return "ThirdClass{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}