package com.company.lw2;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        boolean moreThat4, lessThat11;
        int x;

        System.out.print("Введите число: ");
        x = input.nextInt();
        moreThat4 = x >= 5;
        lessThat11 = x <= 10;

        System.out.printf("Число %d" +
                ((moreThat4 && lessThat11)?" ":" не ") +
                "принадлежит [5; 10].\n\r", x);
    }
}
