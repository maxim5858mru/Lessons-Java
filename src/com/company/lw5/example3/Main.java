package com.company.lw5.example3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        TwoIntFields field;

        // Инициализация конструктором по умолчанию.
        field = new TwoIntFields();
        System.out.println(field);

        // Инициализация конструктором с одним параметром.
        System.out.print("\n\rВведите целочисленное число: ");
        field = new TwoIntFields(input.nextInt());
        System.out.println(field);

        // Инициализация конструктором с двумя параметрами
        System.out.print("\n\rВведите два целочисленных числа: ");
        field = new TwoIntFields(input.nextInt(), input.nextInt());
        System.out.println(field);
    }
}
