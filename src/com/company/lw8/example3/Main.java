package com.company.lw8.example3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int[] data;

        System.out.print("Введите количество элементов в массиве: ");
        data = new int[scanner.nextInt()];
        getValues(data, scanner);

        System.out.println();
        printValues(data, scanner);
    }

    private static void getValues(int[] array, Scanner scanner) {
        getValues(array, 0, scanner);
    }

    private static void getValues(int[] array, int index, Scanner scanner) {
        System.out.print("[" + index + "] = ");
        array[index] = scanner.nextInt();

        if (index != array.length - 1) getValues(array, index + 1, scanner);
    }

    private static void printValues(int[] array, Scanner scanner) {
        System.out.print("Array[] = { ");
        printValues(array, 0, scanner);
        System.out.println("}");
    }

    private static void printValues(int[] array, int index, Scanner scanner) {
        System.out.print(array[index] + ((array.length - 1 != index)?", ":" "));

        if (index != array.length - 1) printValues(array, index + 1, scanner);
    }
}
