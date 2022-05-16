package com.company.lw7.example3;

public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass(5);
        var firstSubClassObject = new FirstSubClass(100, 'A');
        var secondSubClassObject = new SecondSubClass(255, 'Z', "Hello World!");

        System.out.println(superClassObject.toString());
        System.out.println(firstSubClassObject.toString());
        System.out.println(secondSubClassObject.toString());
    }
}