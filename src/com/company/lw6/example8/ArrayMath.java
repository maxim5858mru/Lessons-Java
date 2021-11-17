package com.company.lw6.example8;

final class ArrayMath {
    private ArrayMath() {}

    public static int getAverage(int[] array) {
        int result = 0;

        for (var number : array) {
            result += number;
        }
        result /= array.length;

        return result;
    }
}
