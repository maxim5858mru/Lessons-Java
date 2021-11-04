package com.company.lw1;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String firstName, lastName, middleName;

        System.out.print("Введите последовательно ФИО: ");
        lastName = input.next();
        firstName = input.next();
        middleName = input.next();

        System.out.printf("Hello %s %s %s\n\r", lastName, firstName, middleName);
    }
}
