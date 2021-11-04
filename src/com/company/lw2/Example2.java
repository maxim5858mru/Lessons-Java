package com.company.lw2;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        boolean modBy5Is2, modBy7Is1;
        int x;

        System.out.print("Введите число: ");
        x = input.nextInt();
        modBy5Is2 = x % 5 == 2;
        modBy7Is1 = x % 7 == 1;

        System.out.printf("Число %d при делении на 5" + ((!modBy5Is2)?" не ":" ") + "имеет остаток 2\n\r", x);
        System.out.printf("Число %d при делении на 7" + ((!modBy7Is1)?" не ":" ") + "имеет остаток 1\n\r", x);
    }
}
