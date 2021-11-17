package com.company.lw6.example3;

public class Main {
    public static void main(String[] args) {
        /* Отсортированный массив: {-1, 0, 0, 0, 0, 1, 7, 8, 14, 20, 67, 86}
        Следовательно min = -1; mean = 8; max = 86 */
        final int[] ARRAY = new int[] {20, 8, 1, 86, 14, 67, 0, 7, 0, 0, 0, -1};

        System.out.println("Минимальное значение: " + SequenceAnalysis.findMin(ARRAY));
        System.out.println("Среднее значение: " + SequenceAnalysis.findMean(ARRAY));
        System.out.println("Максимальное значение: " + SequenceAnalysis.findMax(ARRAY));
    }
}
