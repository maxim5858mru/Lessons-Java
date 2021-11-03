package com.company.lw1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int number;

        System.out.print("Введите любое число: ");
        number = input.nextInt();

        System.out.printf("%d %d %d %d\n\r", number - 1, number, number + 1, number * number);
    }
}
