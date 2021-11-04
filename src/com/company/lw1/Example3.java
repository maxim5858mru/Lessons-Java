package com.company.lw1;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        String dayType, month;
        int dayNumber;
        var input = new Scanner(System.in);

        System.out.print("Введите последовательно день недели, месяц, число: ");
        dayType = input.next();
        month = input.next();
        dayNumber = input.nextInt();

        System.out.println("\n\rИтого, вы ввели:");
        System.out.println("\tДень недели: " + dayType);
        System.out.println("\tМесяц: " + month);
        System.out.println("\tЧисло: " + dayNumber);
    }
}
