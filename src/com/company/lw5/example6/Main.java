package com.company.lw5.example6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        IntRange range;

        // Инициализация объекта
        System.out.print("Введите два числа: ");
        range = new IntRange(input.nextInt(), input.nextInt());

        // Вывод значений в консоль
        range.print();
    }
}
