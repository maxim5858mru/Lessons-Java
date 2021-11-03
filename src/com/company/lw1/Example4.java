package com.company.lw1;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        String month;
        int days;
        Scanner input = new Scanner(System.in);

        System.out.print("Введите месяц и количество дней в нём: ");
        month = input.next();
        days = input.nextInt();

        System.out.printf("В %s %d дней.\n\r", month, days);
    }
}
