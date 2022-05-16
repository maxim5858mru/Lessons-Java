package com.company.lw10.example1;

public class Case5 {
    public static void main(String[] args) {
        /* Программа завершится с ошибкой, так как нет блока catch
           который смог бы перехватить исключение.
         */
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }
}
