package com.company.lw3;

public class Example7 {
    public static void main(String[] args) {
        int amount = 10;
        char[] chars;

        System.out.printf("Длина массива символов: %d.\n\r", amount);

        chars = getCharArray(amount);

        System.out.println("\n\rВывод массива символов, в прямом порядке:");
        printCharArray(chars, true);

        System.out.println("\n\rВывод массива символов, в обратном порядке:");
        printCharArray(chars, false);
    }

    private static char[] getCharArray(int amount) {
        char[] chars = new char[amount];

        chars[0] = 'a';

        for (int i = 1; i < chars.length; i++) {
            chars[i] = (char)(chars[i - 1] + 2);
        }

        return chars;
    }

    private static void printCharArray(char[] array, boolean isDirectOrder) {
        if (isDirectOrder) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("[%d] = %s\n\r", i, array[i]);
            }
        }
        else {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.printf("[%d] = %s\n\r", i, array[i]);
            }
        }
    }
}
