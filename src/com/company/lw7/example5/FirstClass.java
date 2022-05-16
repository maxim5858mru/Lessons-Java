package com.company.lw7.example5;

import java.io.PrintStream;

public class FirstClass {
    private String text;

    public FirstClass(String text) {
        this.text = text;
    }

    public void PrintInfo() {
        PrintInfo(System.out);
    }

    public void PrintInfo(PrintStream output) {
        output.println(this);
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "text='" + text + '\'' +
                '}';
    }
}