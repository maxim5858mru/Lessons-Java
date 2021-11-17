package com.company.lw6.example2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String answer;

        /* Т.к. инкриминирование счётчика происходит только при выводе
        вывод с запросом о продолжении происходит в цикле.*/
        do {
            Counter.printCounter();
            System.out.print("Вывести значение счётчика? (yes/no): ");
            answer = input.nextLine();

            System.out.println();
        } while (answer.equals("yes") || answer.equals("y"));
    }
}
