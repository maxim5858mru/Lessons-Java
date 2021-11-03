package com.company.lw1;

import java.util.Calendar;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int year, now_year = Calendar.getInstance().get(Calendar.YEAR);
        String name;

        System.out.print("Введите ваше имя и год рождения: ");
        name = input.next();
        year = input.nextInt();

        System.out.println("Ваше имя: " + name);
        System.out.println("Вам сейчас : " + (now_year - year));
    }
}
