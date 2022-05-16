package com.company.lw8.example7;

public class Main {
    public static void main(String[] args) {
        var object = new ExtendedList();

        object.readFromConsole();
        System.out.println("Количество: " + object.length());
        System.out.println("Сумма: " + object.sum());
        System.out.println("Среднее чётных чисел: " + object.sum());

        System.out.println();
        object.changePositionPositiveEvenNumbers();
        System.out.println("\n\rТеперь:\n\r" + object.toString());
    }
}
