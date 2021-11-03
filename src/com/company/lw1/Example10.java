package com.company.lw1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int x, y;

        System.out.print("Введите x: ");
        x = input.nextInt();

        System.out.print("Введите y: ");
        y = input.nextInt();

        System.out.printf("Сумма %d и %d: %d\n\r", x, y, x + y);
        System.out.printf("Разность %d и %d: %d\n\r", x, y, x - y);
    }
}
