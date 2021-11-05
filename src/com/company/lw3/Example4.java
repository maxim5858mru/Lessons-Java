package com.company.lw3;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int[] array;
        int a, b;

        System.out.print("Введите a и b: ");
        a = input.nextInt();
        b = input.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            array = getArray(a, b, item);
            printIntArray(array);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int[] getArray(int a, int b, cycles waysToGet) {
        int[] numbers = new int[b - a + 1];
        numbers[0] = a;

        switch (waysToGet) {
            case FOR:
                for (int i = 1; i < numbers.length; i++) {
                    numbers[i] = numbers[i - 1] + 1;
                }
                break;
            case WHILE:
                int i = 1;

                while (i < numbers.length) {
                    numbers[i] = numbers[i - 1] + 1;
                    i++;
                }
                break;
            case DO:
                i = 1;

                if (numbers.length == 0)
                    return numbers;

                do {
                    numbers[i] = numbers[i - 1] + 1;
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
