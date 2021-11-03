package com.company.lw1;

import java.util.Calendar;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int year, year_now = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Введите год вашего рождения: ");
        year = input.nextInt();

        System.out.println("Вам сейчас " + (year_now - year)+ ".");
    }
}
