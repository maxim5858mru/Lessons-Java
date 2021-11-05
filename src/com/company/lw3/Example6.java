package com.company.lw3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int amount;
        int[] numbers;

        while (true) {
            try {
                System.out.print("Введите количество элементов в массиве: ");
                amount = input.nextInt();

                if (amount < 1)
                    throw new Exception("Размер массива должен быть больше, чем 0.\n\r");
                else
                    break;
            } catch (java.util.InputMismatchException exception) {
                System.err.println("Из введённой строки нельзя извлечь число.\n\r");
                input.nextLine();
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                input.nextLine();
            }
        }

        numbers = getArray(amount);
        printIntArray(numbers);
    }

    private static int[] getArray(int amount) {
        int[] numbers = new int[amount];

        for (int i = 0, y = 1; i < numbers.length;) {
            if (y % 5 == 2) {
                numbers[i] = y;
                i++;
            }
            y++;
        }
        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
