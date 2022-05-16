package com.company.lw10.example1;

public class Case14 {
    /* Оператор throws указывает, что метод необходимо вызывать
       в блоке try-catch с обработчиками указанных исключений.
       Тем самым это позволит избежать завершения программы с ошибкой.
     */
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("Размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
