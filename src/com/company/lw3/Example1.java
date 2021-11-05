package com.company.lw3;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int weekDayNumber;
        String weekDayName;

        System.out.print("Введите номер дня недели: ");
        weekDayNumber = input.nextInt();

        try {
            switch (weekDayNumber) {
                case 1:
                    weekDayName = "понедельник";
                    break;
                case 2:
                    weekDayName = "вторник";
                    break;
                case 3:
                    weekDayName = "среда";
                    break;
                case 4:
                    weekDayName = "четверг";
                    break;
                case 5:
                    weekDayName = "пятница";
                    break;
                case 6:
                    weekDayName = "суббота";
                    break;
                case 7:
                    weekDayName = "воскресенье";
                    break;
                default:
                    throw new Exception("Введённое число " + weekDayNumber +
                            " выходит за допустимый диапазон.");
            }

            System.out.printf("Указанный номер дня недели - это %s.\n\r", weekDayName);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
