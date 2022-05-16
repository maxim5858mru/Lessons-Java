package com.company.lw7.example2;

public class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }

    public void set() {
        text = null;
    }

    public void set(String text) {
        this.text = text;
    }

    public int length() {
        return text.length();
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "text='" + text + '\'' +
                '}';
    }
}