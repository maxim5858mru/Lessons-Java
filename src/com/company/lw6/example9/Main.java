package com.company.lw6.example9;

public class Main {
    public static void main(String[] args) {
        Character[] array = new Character[] {'f', 'Q', 'T', 'z', 'q', 'a', 'r'};

        System.out.print(arrayToString(array) + " => ");
        ArrayPermutation.pairwise(array);
        System.out.println(arrayToString(array));
    }

    private static String arrayToString(Character[] array) {
        String result = "{";

        for (int i = 0; i < array.length - 1; i++) {
            result += "'" + array[i] + "', ";
        }
        result += "'" + array[array.length - 1] + "'}";

        return result;
    }
}
