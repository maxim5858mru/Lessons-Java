package com.company.lw10.example2.task1;

import com.company.lw10.example2.HasNotPositiveIntegerException;
import com.company.lw10.example2.IsNotIntegerException;
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        int sum = 0, counter = 0;
        int[] data = null;

        // Получение размера массива
        do {
            try {
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
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        // Получение элементов массива
        for (int i = 0; i < data.length; i++) {
            try {
                System.out.printf("[%d] = ", i);

                if (scanner.hasNextInt()) {
                    data[i] = scanner.nextInt();
                } else if (scanner.hasNextBoolean() ||
                    scanner.hasNextDouble()     ||
                    scanner.hasNextBigDecimal() ||
                    scanner.hasNextBigInteger() ||
                    scanner.hasNextLong()) {
                    throw new IsNotIntegerException();
                } else {
                    throw new IsStringException();
                }
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

        // Вычисление среднего
        for (int item : data) {
            if (item > 0) {
                sum += item;
                counter++;
            }
        }

        if (counter == 0) throw new HasNotPositiveIntegerException();
        else System.out.println("\n\rСреднее положительных чисел массива: " + sum / counter);
    }
}
