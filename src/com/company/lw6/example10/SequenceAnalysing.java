package com.company.lw6.example10;

final class SequenceAnalysing {
    private SequenceAnalysing() {}

    /**
     * Поиск минимального и максимального значения в исходной
     * последовательности.
     *
     * @param array Исходная целочисленная последовательность.
     * @return Массив, в котором [0] - минимальное значение,
     *                           [1] - максимальное значение.
     */
    public static int[] getExtremeValues(int ...array) {
        int[] result;

        if (array.length == 0) throw new IllegalArgumentException("Последовательность должна иметь хотя бы один элемент.");

        result = new int[] {array[0], array[0]};
        for (var number : array) {
            if (number < result[0]) result[0] = number;
            if (number > result[1]) result[1] = number;
        }

        return result;
    }
}
