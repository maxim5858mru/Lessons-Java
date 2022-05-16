package com.company.lw7.example5;

import java.io.PrintStream;
import java.util.regex.Pattern;

public class SecondClass extends FirstClass {
    private Integer number;

    public SecondClass(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void PrintInfo() {
        PrintInfo(System.out);
    }

    @Override
    public void PrintInfo(PrintStream output) {
        output.println(this.toString() + " [вызванный метод SecondClass.PrintInfo]");
    }

    @Override
    public String toString() {
        var matcher = Pattern.compile("'.*'").matcher(super.toString());
        matcher.find();
        String text = super.toString().substring(matcher.start(), matcher.end());

        return "SecondClass{" +
                "text=" + text +
                ", number=" + number +
                '}';
    }
}