package com.company.lw10.example2.task3;

import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static byte[] data = null;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        do {
            try {
                init();
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                get(i);
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
            System.out.println("Сумма: " + sum());
        } catch (ArithmeticException exception) {
            System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
        }
    }

    private static void init() throws ArithmeticException, IsStringException {
        System.out.print("Введите количество элементов: ");
        if (scanner.hasNextInt()) {
            data = new byte[scanner.nextInt()];
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    private static void get(int index) throws ArithmeticException, IsStringException {
        System.out.printf("[%d] = ", index);
        if (scanner.hasNextByte()) {
            data[index] = scanner.nextByte();
        } else if (scanner.hasNextBigInteger() ||
                scanner.hasNextInt() ||
                scanner.hasNextLong()) {
            throw new ArithmeticException();        // Переполнение переменной
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    private static int sum() throws ArithmeticException {
        byte result = 0;

        for (byte item : data) {
            if (result + item > Byte.MAX_VALUE || result + item < Byte.MIN_VALUE) throw new ArithmeticException();
            else result += item;
        }
        return result;
    }
}
