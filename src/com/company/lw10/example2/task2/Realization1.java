package com.company.lw10.example2.task2;

import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        int[][] data = null;
        var scanner = new Scanner(System.in);

        // Получение количества строк и столбцов матрицы
        do {
            try {
                int columns, rows;

                System.out.print("Введите количество строк и столбцов: ");

                if (scanner.hasNextInt()) rows = scanner.nextInt();
                else throw new IsStringException();

                if (scanner.hasNextInt()) columns = scanner.nextInt();
                else throw new IsStringException();

                data = new int[rows][columns];
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);
        System.out.println();

        // Получение элементов матрицы
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try {
                    System.out.printf("[%d, %d] = ", i + 1, j + 1);

                    if (scanner.hasNextInt()) {
                        data[i][j] = scanner.nextInt();
                    } else {
                        throw new IsStringException();
                    }
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

        // Вывод выбранного столбца
        do {
            try {
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
}
