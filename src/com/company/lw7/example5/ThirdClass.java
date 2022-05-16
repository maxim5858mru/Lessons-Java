package com.company.lw7.example5;

import java.io.PrintStream;
import java.util.regex.Pattern;

public class ThirdClass extends FirstClass {
    private Character symbols;

    public ThirdClass(String text, char symbols) {
        super(text);
        this.symbols = symbols;
    }

    @Override
    public void PrintInfo() {
        PrintInfo(System.out);
    }

    @Override
    public void PrintInfo(PrintStream output) {
        output.println(this.toString() + " [вызванный метод ThirdClass.PrintInfo]");
    }

    @Override
    public String toString() {
        var matcher = Pattern.compile("'.*'").matcher(super.toString());
        matcher.find();
        String text = super.toString().substring(matcher.start(), matcher.end());

        return "SecondClass{" +
                "text=" + text +
                ", symbols='" + symbols +
                "'}";
    }
}