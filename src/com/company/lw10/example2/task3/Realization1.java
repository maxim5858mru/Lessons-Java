package com.company.lw10.example2.task3;

import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        byte[] data = null;
        var scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Введите количество элементов: ");
                if (scanner.hasNextInt()) {
                    data = new byte[scanner.nextInt()];
                } else {
                    throw new IsStringException();          // Ввод строки вместо числа
                }
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                System.out.printf("[%d] = ", i);
                if (scanner.hasNextByte()) {
                    data[i] = scanner.nextByte();
                } else if (scanner.hasNextBigInteger() ||
                        scanner.hasNextInt() ||
                        scanner.hasNextLong()) {
                    throw new ArithmeticException();        // Переполнение переменной
                } else {
                    throw new IsStringException();          // Ввод строки вместо числа
                }
            } catch (ArithmeticException exception) {
                System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }

        try {
            byte result = 0;

            for (byte item : data) {
                if (result + item > Byte.MAX_VALUE || result + item < Byte.MIN_VALUE) throw new ArithmeticException();
                else result += item;
            }

            System.out.println("Сумма: " + result);
        } catch (ArithmeticException exception) {
            System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
        }
    }
}
