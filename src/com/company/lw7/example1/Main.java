package com.company.lw7.example1;

public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass("Text 1");
        var firstSubClassObject = new SubClass("Text 2");
        var secondSubClassObject = new SubClass("Text 3", "Text 5");

        System.out.println(superClassObject.toString());
        System.out.println(firstSubClassObject.toString());
        System.out.println(secondSubClassObject.toString());
    }
}
