package com.company.lw4;

import java.util.Random;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int deletedRow, deletedColumn;
        int[][] array;

        // Считывание размера массива
        System.out.print("Введите количество строк и столбцов в массиве: ");
        array = new int[input.nextInt()][input.nextInt()];

        // Генерация значений массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(-200, 200);
            }
        }

        // Промежуточный вывод полученного массива
        System.out.println("\n\rПолученный массив:");
        printIntArray(array);

        // Генерация значений удаляемого столбца и строки, а также обработка массива
        deletedRow = random.nextInt(0, array.length - 1);
        deletedColumn = random.nextInt(0, array[0].length - 1);
        array = removeAtIntArray(array, deletedRow, deletedColumn);

        // Вывод окончательного массива
        System.out.printf("\n\rПолученный массив после удаления %d столбца и %d строки:\n\r",
                deletedColumn, deletedRow);
        printIntArray(array);
    }

    private static void printFormatNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d", index);
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
     * Удаление строки и столбца из массива.
     * @param array Исходный массив.
     * @param row Удаляемая строка.
     * @param column Удаляемый столбец.
     * @return Массив без указанной строки и столбца.
     */
    private static int[][] removeAtIntArray(int[][] array, int row, int column) {
        int[][] result = new int[array.length - 1][array[0].length - 1];

        /* Цикл добавления значений из array в result, разделён на две части.
         * В начале добавляются элементы до удаляемой строки, а после все оставшиеся.
         * Аналогичный принцип используется в циклах для столбцов.
         */
        for (int i = 0; i < row; i++) {
            moveColumnsItems(array, column, result, i);
        }
        for (int i = row; i < array.length; i++) {
            moveColumnsItems(array, column, result, i - 1);
        }

        return result;
    }

    /**
     * Копирование элементов столбца без учёта элементов определённого столбца.
     * Метод выделен для оптимизации кода.
     * @param array Исходный массив
     * @param column Удаляемый столбец
     * @param result Окончательный массив
     * @param i Индекс текущей строки массива
     */
    private static void moveColumnsItems(int[][] array, int column, int[][] result, int i) {
        for (int j = 0; j < column; j++) {
            result[i][j] = array[i][j];
        }

        for (int j = column + 1; j < array[0].length; j++) {
            result[i][j - 1] = array[i][j];
        }
    }
}
