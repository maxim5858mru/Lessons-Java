package com.company.lw1;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        String day_type, month;
        int day_number;
        var input = new Scanner(System.in);

        System.out.print("Введите последовательно день недели, месяц, число: ");
        day_type = input.next();
        month = input.next();
        day_number = input.nextInt();

        System.out.println("\n\rИтого, вы ввели:");
        System.out.println("\tДень недели: " + day_type);
        System.out.println("\tМесяц: " + month);
        System.out.println("\tЧисло: " + day_number);
    }
}
