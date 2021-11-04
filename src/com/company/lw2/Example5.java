package com.company.lw2;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int data, thousands;

        System.out.print("Введите число: ");
        data = input.nextInt();

        thousands = (data / 1000) % 10;

        System.out.printf("Число %d имеет %d тысяч.\n\r", data ,thousands);
    }
}
