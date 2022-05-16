package com.company.lw10.example1;

public class Case13 {
    public static void main(String[] args) {
        try {
            /* Так как программа вызывается без передачи ей аргументов,
               то инициализация переменой l вызовет исключение
               ArithmeticException, из-за деления на 0.

               Если программе будут переданы аргументы, то попытка доступа
               к элементу массива args[l + 1] вызовет исключение
               ArrayIndexOutOfBoundsException.
             */
            int l = args.length;
            System.out.println("Размер массива = " + l);
            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}
