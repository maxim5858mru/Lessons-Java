package com.company.lw1;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int age;
        String name;

        System.out.print("Введите ваше имя и возраст: ");
        name = input.next();
        age = input.nextInt();

        System.out.println("Итого вы ввели: ");
        System.out.println("\tВаше имя: " + name);
        System.out.println("\tВаш возраст: " + age);
    }
}
