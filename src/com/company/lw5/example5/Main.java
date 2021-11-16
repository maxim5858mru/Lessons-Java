package com.company.lw5.example5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var intField = new IntField();
        int value;

        // Вывод значения, после инициализации конструктором по умолчанию.
        System.out.printf("Инициализация конструктором по умолчанию: %s\n\r\n\r", intField);

        // Инициализация конструктором с параметром.
        System.out.print("Введите значение: ");
        intField = new IntField(input.nextInt());
        System.out.printf("Инициализация с параметром: %s\n\r\n\r", intField);

        // Изменение значения, через метод.
        System.out.print("Введите значение: ");
        intField.setValue(input.nextInt());
        System.out.printf("После изменения поле стало хранить в себе значение %d. %s\n\r",
                intField.getValue(), (intField.isOverflow() ? "Что не равно исходному значению.": ""));
    }
}
