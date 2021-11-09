package com.company.lw4;

import java.util.Random;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int rows, columns;
        int[][] array;

        // Считывание размера массива
        System.out.print("Введите количество строк и столбцов в массиве: ");
        rows = input.nextInt();
        columns = input.nextInt();

        // Генерация значений массива
        array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(-200, 200);
            }
        }

        // Промежуточный вывод полученного массива
        System.out.println("\n\rПолученный массив:");
        printIntArray(array);

        // Обработка и вывод окончательного массива
        System.out.println("\n\rМассив после транспонирования:");
        array = transposeIntArray(array);
        printIntArray(array);
    }

    /**
     * Вывод выравненного по правому краю числа, с учётом максимально
     * возможного числа.
     * @param number Выводимое число.
     * @param maxNumber Максимально возможное выводимое число.
     */
    private static void printFormatNumber(int number, int maxNumber) {
        int counter = 0;

        for (int z = maxNumber; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d", number);
    }

    private static void printIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printFormatNumber(i, array.length);
            System.out.print(": ");

            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[");
                printFormatNumber(array[i][j], 1000);
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /**
     * Транспонирование массива
     * @param array Исходный массив
     * @return Транспонированный массив
     */
    private static int[][] transposeIntArray(int[][] array) {
        int[][] result = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }

        return result;
    }
}
