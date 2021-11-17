package com.company.lw6.example8;

public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {5, 27, 0, -9, 68, 2, 7, 2, 224};
        String line = "";

        for (int i = 0; i < ARRAY.length - 1; i++) {
            line += ARRAY[i]+", ";
        }
        line += ARRAY[ARRAY.length - 1];

        System.out.printf("¯{%s} = %d\n\r", line, ArrayMath.getAverage(ARRAY));
    }
}
