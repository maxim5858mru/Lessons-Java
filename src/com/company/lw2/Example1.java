package com.company.lw2;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int x;

        System.out.print("Введите число: ");
        x = input.nextInt();

        System.out.println(((x % 3) == 0)?"Число делится на 3.":"Число не делится на 3, без остатка.");
    }
}
