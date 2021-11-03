package com.company.lw1;

import java.util.Calendar;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int age, year = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Сколько вам сейчас лет? ");
        age = input.nextInt();

        System.out.println("Вы родились в " + (year - age) + "+-1 году.");
    }
}
