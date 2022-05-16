package com.company.lw7.example2;

public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass("Text");
        var subClassObject = new SubClass("Text ######", 255);

        System.out.println(superClassObject.toString());
        System.out.println(subClassObject.toString());
    }
}