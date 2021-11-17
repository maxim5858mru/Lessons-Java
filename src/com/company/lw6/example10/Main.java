package com.company.lw6.example10;

public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {-10, 5, 28, 2, 0, 100, 2, 8, -2};
        var result = SequenceAnalysing.getExtremeValues(ARRAY);
        String line = "";

        for (int i = 0; i < ARRAY.length - 1; i++) {
            line += ARRAY[i]+", ";
        }
        line += ARRAY[ARRAY.length - 1];

        System.out.printf("{%s} => min = %d, max = %d\n\r", line, result[0], result[1]);
    }
}
