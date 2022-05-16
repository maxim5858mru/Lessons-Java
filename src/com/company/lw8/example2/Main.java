package com.company.lw8.example2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n;

        System.out.print("Введите число, которое нужно перевести в двоичную систему счисления: ");
        n = scanner.nextInt();

        System.out.println(n + " = 0x" + toBinaryNumeralSystem(n));
    }

    private static String toBinaryNumeralSystem(int n) {
        if ((n == 1) || (n == 0)) return Integer.toString(n);
        else {
            return Integer.toString(n % 2) + toBinaryNumeralSystem(n / 2);
        }
    }
}
