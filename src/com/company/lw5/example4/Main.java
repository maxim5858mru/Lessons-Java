package com.company.lw5.example4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        IntCharFields x;

        // Инициализация объекта с помощью конструктора принимающего int и char
        System.out.print("Введите число и символ: ");
        x = new IntCharFields(input.nextInt(), input.next().charAt(0));
        System.out.println(x);

        // Инициализация объекта с помощью конструктора принимающего double
        System.out.print("\n\rВведите вещественное число: ");
        x = new IntCharFields(input.nextDouble());
        System.out.println(x);
    }
}
