package com.company.lw3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int[] fibonacciNumbers;
        int amount;

        System.out.print("Введите количество числе последовательности: ");
        amount = input.nextInt();

        if (amount <= 2) {
            System.err.println("Для вычисления последовательности Фибоначчи " +
                    "массив должен быть размером больше 2, иначе не имеет смысла.");
            return;
        }

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            fibonacciNumbers = getFibonacciNumbers(amount, cycles.FOR);
            printIntArray(fibonacciNumbers);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int[] getFibonacciNumbers(int amount, cycles waysToGet) {
        int[] numbers = new int[amount];
        numbers[0] = 1;
        numbers[1] = 1;

        switch (waysToGet) {
            case FOR:
                for (int i = 2; i < numbers.length; i++) {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                }
                break;
            case WHILE:
                int i = 2;

                while (i < numbers.length) {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                    i++;
                }
                break;
            case DO:
                i = 2;

                do {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                    i++;
                } while (i < numbers.length);
                break;
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
