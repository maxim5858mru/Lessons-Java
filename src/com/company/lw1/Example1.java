package com.company.lw1;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String first_name, last_name, middle_name;

        System.out.print("Введите последовательно ФИО: ");
        last_name = input.next();
        first_name = input.next();
        middle_name = input.next();

        System.out.printf("Hello %s %s %s\n\r", last_name, first_name, middle_name);
    }
}
