package com.company.lw3;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int sum, amount;

        System.out.print("Введите количество элементов в массиве: ");
        amount = input.nextInt();

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            sum = getSum(amount, item);
            System.out.println("Сумма элементов : " + sum);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int getSum(int amount, cycles waysToGet) {
        int[] numbers = new int[amount];
        int sum = 0;

        switch (waysToGet) {
            case FOR:
                for (int i = 0, y = 1; i < numbers.length;) {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                }
                break;
            case WHILE:
                int i = 0, y = 1;

                while (i < numbers.length) {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                }
                break;
            case DO:
                i = 0;
                y = 1;

                if (numbers.length == 0)
                    return 0;

                do {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                } while (i < numbers.length);
                break;
        }
        printIntArray(numbers);

        return sum;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
