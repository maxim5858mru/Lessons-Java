package com.company.lw10.example1;

public class Case11 {
    public static void main(String[] args) {
        /* В данном случае все 3 блока обработчика исключений
           выполняются. После выполняются команда находящая
           после блока try-catch.
         */
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }
}
