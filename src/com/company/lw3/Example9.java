package com.company.lw3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int[] numbers, minValues;

        System.out.print("Введите размер массива: ");
        numbers = new int[input.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(5);
        }
        System.out.println("\n\rСгенерированный массив до сортировки:");
        printIntArray(numbers);

        minValues = findMinValue(numbers);
        System.out.println("Минимальное значение: " + numbers[minValues[0]]);
        System.out.print("Индексы массива с минимальным значением: ");

        for (var item: minValues) {
            System.out.printf("[%d] ", item);
        }
        System.out.println();
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }

    private static int[] findMinValue(int[] inputArray) {
        int amount = 1;
        int[] sortArray = inputArray.clone(), result;
        Arrays.sort(sortArray);

        // Подсчёт количества одинаковых минимальных значений
        for (int i = 0; i < sortArray.length; i++) {
            if (sortArray[i] == sortArray[i + 1])
                amount++;
            else
                break;
        }

        // Поиск в неотсортированном массиве одинаковых минимальных значений
        result = new int[amount];
        for (int i = 0, y = 0; i < inputArray.length; i++) {
            if (inputArray[i] == sortArray[0]) {
                result[y] = i;
                y++;
            }
        }

        return result;
    }
}
