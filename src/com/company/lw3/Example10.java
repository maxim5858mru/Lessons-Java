package com.company.lw3;

import java.util.Random;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int[] numbers;

        System.out.print("Введите размер массива: ");
        numbers = new int[input.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-200, 200);
        }
        System.out.println("\n\rСгенерированный массив до сортировки:");
        printIntArray(numbers);

        reverseOrderSort(numbers);
        System.out.println("\n\rМассив после сортировки по убыванию:");
        printIntArray(numbers);
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }

    private static void reverseOrderSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] > array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
