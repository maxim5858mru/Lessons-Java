package com.company.lw3;

public class Example8 {
    public static void main(String[] args) {
        int amount = 10;
        char[] chars;

        System.out.printf("Длина массива символов: %d.\n\r", amount);

        chars = getCharArray(amount);
        printIntArray(chars);
    }

    private static char[] getCharArray(int amount) {
        final char[]  VOWELS = new char[] {'A', 'E', 'I', 'O', 'U', 'Y'};
        char[] chars = new char[amount];

        for (int i = 0, y = 0, z = 'A'; i < chars.length; z++) {
            if (z != VOWELS[y]) {
                chars[i] = (char)z;
                i++;
            }
            else {
                if (y != VOWELS.length -1)
                    y++;
            }
        }

        return chars;
    }

    private static void printIntArray(char[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %s\n\r", i, item);
            i++;
        }
    }
}
