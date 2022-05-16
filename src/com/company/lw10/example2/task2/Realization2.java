package com.company.lw10.example2.task2;

import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static int[][] data = null;
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
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try {
                    get(i, j);
                } catch (IsStringException exception) {
                    System.err.println("Введена строка вместо числа.\n\r");
                    j--;
                } finally {
                    scanner.nextLine();
                    Thread.sleep(50);
                }
            }
        }
        System.out.println();

        do {
            try {
                printColumn();
                return;
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IndexOutOfBoundsException exception) {
                System.err.println("Нет столбца с таким номером.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (true);
    }

    /**
     * Инициализация матрицы. Получения количества строк и столбцов с консоли
     *
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void init() throws IsStringException {
        int columns, rows;

        System.out.print("Введите количество строк и столбцов: ");

        if (scanner.hasNextInt()) rows = scanner.nextInt();
        else throw new IsStringException();
        
        if (scanner.hasNextInt()) columns = scanner.nextInt();
        else throw new IsStringException();
        
        data = new int[rows][columns];
    }

    /**
     * Получение элемента матрицы
     *
     * @param rowIndex Индекс строки элемента
     * @param columnsIndex Индекс столбца элемента
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void get(int rowIndex, int columnsIndex) throws IsStringException {
        System.out.printf("[%d, %d] = ", rowIndex + 1, columnsIndex + 1);

        if (scanner.hasNextInt()) {
            data[rowIndex][columnsIndex] = scanner.nextInt();
        } else throw new IsStringException();
    }

    /**
     * Вывод выбранного столбца
     *
     * @throws IsStringException Вместо индекса столбца введена строка
     * @throws IndexOutOfBoundsException Отсутствует столбец с таким индексом
     */
    private static void printColumn() throws IsStringException, IndexOutOfBoundsException {
        int padding = 0, index;

        // Получение номера выводимого столбца
        System.out.print("Введите номе столбца: ");
        if (!scanner.hasNextInt()) throw new IsStringException();
        else {
            index = scanner.nextInt() - 1;
            if (data[0].length <= index || index < 0) throw new IndexOutOfBoundsException();
        }

        // Вычисления отступа для выравнивания индекса строки
        for (int i = data.length; i > 0;) {
            i /= 10;
            padding++;
            System.out.print(" ");
        }
        System.out.println("  " + (index + 1));

        // Вывод столбца
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%" + padding + "d: [%4d]\n\r", i + 1, data[i][index]);
        }
    }
}
