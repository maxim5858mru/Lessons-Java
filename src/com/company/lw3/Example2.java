package com.company.lw3;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int weekDayNumber;
        String weekDayName;

        System.out.print("Введите название дня недели: ");
        weekDayName = input.next();

        try {
            switch (weekDayName) {
                case "понедельник":
                    weekDayNumber = 1;
                    break;
                case "вторник":
                    weekDayNumber = 2;
                    break;
                case "среда":
                    weekDayNumber = 3;
                    break;
                case "четверг":
                    weekDayNumber = 4;
                    break;
                case "пятница":
                    weekDayNumber = 5;
                    break;
                case "суббота":
                    weekDayNumber = 6;
                    break;
                case "воскресенье":
                    weekDayNumber = 7;
                    break;
                default:
                    throw new Exception("Не существует дня недели с названием \"" +
                            weekDayName + "\".");
            }

            System.out.printf("\"%s\" это %d день недели.\n\r", weekDayName, weekDayNumber);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
