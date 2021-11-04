package com.company.lw2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        boolean divBy5, moreThat10;
        int x;

        System.out.print("Введите число: ");
        x = input.nextInt();

        divBy5 = x % 5 == 0;
        moreThat10 = x >= 10;

        System.out.printf("Число %d" + ((!divBy5)?" не ":" ") +
                "делится на 5 без остатка и" + ((moreThat10)?" не ":" ") +
                "меньше 10.\n\r", x);
    }
}
