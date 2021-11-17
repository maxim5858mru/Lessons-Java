package com.company.lw6.example7;

final class ArrayConvert {
    private ArrayConvert() {}

    public static int[] toCharCode(char[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        return result;
    }
}
