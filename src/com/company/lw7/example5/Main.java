package com.company.lw7.example5;

public class Main {
    public static void main(String[] args) {
        var firstClassObject = new FirstClass("Text");
        var secondClassObject = new SecondClass("Qwertyuiop", 64);
        var thirdClassObject = new ThirdClass("Asdfghjkl", 'F');

        firstClassObject.PrintInfo();
        secondClassObject.PrintInfo();
        thirdClassObject.PrintInfo(System.out);

        System.out.println();
        ((FirstClass) secondClassObject).PrintInfo();
        ((FirstClass) thirdClassObject).PrintInfo();
    }
}