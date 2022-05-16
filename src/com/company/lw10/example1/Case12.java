package com.company.lw10.example1;

public class Case12 {
    public static void m(String str, double number) {
        /* В данной программе используется исключение класса
           IllegalArgumentException, из пакета java.lang. Данное
           исключение обозначает что передан неверный аргумент.
         */

        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (number > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        m(null, 0.000001);
    }
}
