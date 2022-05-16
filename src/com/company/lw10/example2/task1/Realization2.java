package com.company.lw10.example2.task1;

import com.company.lw10.example2.HasNotPositiveIntegerException;
import com.company.lw10.example2.IsNotIntegerException;
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static int[] data = null;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        do {
            try {
                init();
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                get(i);
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
                i--;
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
                i--;
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }

        try {
            System.out.println("\n\rСреднее положительных чисел массива: " + mean());
        } catch (HasNotPositiveIntegerException exception) {
            System.err.println("Среди введённых числе нет положительных.");
        }
    }

    /**
     * Инициализация массива. Получение количества элементов в массиве
     *
     * @throws IsNotIntegerException Введенное значение не являются целочисленным числом
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void init() throws IsNotIntegerException, IsStringException {
        System.out.print("Введите количество элементов: ");
        if (scanner.hasNextInt()) {
            data = new int[scanner.nextInt()];
        } else if (scanner.hasNextBoolean() ||
                scanner.hasNextDouble()     ||
                scanner.hasNextBigDecimal() ||
                scanner.hasNextBigInteger() ||
                scanner.hasNextLong()) {
            throw new IsNotIntegerException();      // Несоответствие числового типа данных
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    /**
     * Получение значения массива с консоли
     *
     * @param index Индекс запрашиваемого элемента
     * @throws IsNotIntegerException Введенное значение не являются целочисленным числом
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void get(int index) throws IsNotIntegerException, IsStringException {
        System.out.printf("[%d] = ", index);

        if (scanner.hasNextInt()) {
            data[index] = scanner.nextInt();
        } else if (scanner.hasNextBoolean() ||
                scanner.hasNextDouble()     ||
                scanner.hasNextBigDecimal() ||
                scanner.hasNextBigInteger() ||
                scanner.hasNextLong()) {
            throw new IsNotIntegerException();
        } else {
            throw new IsStringException();
        }
    }

    /**
     * Получение среднего положительных чисел массива
     *
     * @return Среднее положительных чисел массива
     * @throws HasNotPositiveIntegerException В массиве нет положительных целочисленных чисел
     */
    private static int mean() throws  HasNotPositiveIntegerException {
        int sum = 0, counter = 0;

        for (int item : data) {
            if (item > 0) {
                sum += item;
                counter++;
            }
        }

        if (counter == 0) throw new HasNotPositiveIntegerException();
        else return sum / counter;
    }
}
