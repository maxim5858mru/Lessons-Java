package com.company.lw10.example1;

public class Case7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");

            /* Для перехвата исключения вызываемого в блоке catch
               необходим новый обработчик исключений try-catch, в
               который будет вложен текущий обработчик, вызывающий
               исключение в catch. Поэтому программа завершится с
               ошибкой.
             */
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("2");
        }
    }
}
