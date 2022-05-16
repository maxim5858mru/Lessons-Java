package com.company.lw10.example1;

public class Case1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");     // Вызов исключения RuntimeException
        } catch (RuntimeException e) {                              // Перехват исключения
            System.out.println("1 " + e);                           // Обработка исключения
        }

        System.out.println("2");
    }
}
