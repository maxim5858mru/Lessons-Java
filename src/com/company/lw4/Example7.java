package com.company.lw4;

import java.util.Scanner;

public class Example7 {
    private enum go {LEFT, RIGHT, UP, DONW}

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[][] array;

        System.out.print("Введите количество строк и столбцов в массиве: ");
        array = snakeFillArray(input.nextInt(), input.nextInt());

        System.out.println("\r\nПолученный массив:");
        printIntArray(array);
    }

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
                printFormatNumber(array[i][j], array[0].length * array.length);
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /**
     * Инициализация массива заполняемого "змейкой".
     * @param rows Количество строк.
     * @param columns Количество столбцов.
     * @return Заполненный массив.
     */
    private static int[][] snakeFillArray(int rows, int columns) {
        int[][] array = new int[rows][columns];

        /* Начальное значение для заполнения ячеек '1', для того чтобы определять
         * не заполненные ячейки (которые неявно инициализируются значением '0').
         */
        snakeFillArray(array, 0, 0, 1, go.RIGHT);

        return array;
    }

    /**
     * Рекурсивная функция для заполнения массива "змейкой"
     * @param array Ссылка на заполняемы массив
     * @param i Текущая строка
     * @param j Текущий столбец
     * @param inputNumber Текущее значение
     * @param direction Направление заполнения значений
     */
    private static void snakeFillArray(int[][] array, int i, int j, int inputNumber, go direction) {
        /* Если функция не заполнила ни одной ячейки (inputNumber == number), это означает
         * что массив заполнен и необходимо сделать выход из рекурсивной функции.
         */
        int number = inputNumber;

        switch (direction) {
            case RIGHT:
                // Заполнение ячеек, пока цикл не дойдёт до границы "пустых" ячеек.
                while ((j < array[i].length) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    j++;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i + 1, j - 1, number,go.DONW);
                    break;
                }
            case DONW:
                while ((i < array.length) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    i++;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i - 1, j - 1, number,go.LEFT);
                    break;
                }
            case LEFT:
                while ((j >= 0) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    j--;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i - 1, j + 1, number,go.UP);
                    break;
                }
            case UP:
                while ((i >= 0) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    i--;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i + 1, j + 1, number,go.RIGHT);
                    break;
                }
        }
    }
}
