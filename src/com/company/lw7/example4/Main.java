package com.company.lw7.example4;

public class Main {
    public static void main(String[] args) {
        var firstClassObject = new FistClass('R');
        var secondClassObject = new SecondClass('U', "Hi, World!");
        var thirdClassObject = new ThirdClass('Q', "Text", 128);

        System.out.println(firstClassObject);
        System.out.println(secondClassObject);
        System.out.println(thirdClassObject);

        var clonedObject = firstClassObject.clone();
        firstClassObject.symbols = 'H';
        System.out.println("\n\rПосле клонирования и изменения исходного объекта:");
        System.out.println("\tИсходный:\t" + firstClassObject.toString());
        System.out.println("\tКлон:\t\t" + clonedObject.toString());
    }
}