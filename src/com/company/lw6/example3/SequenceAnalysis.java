package com.company.lw6.example3;

import java.util.Arrays;

final class SequenceAnalysis {
    private SequenceAnalysis() {}

    /**
     * Получение минимального значения из последовательности,
     * без учёта дубликатов.
     *
     * @param data Целочисленная последовательность. Минимальное
     *             количество значений в последовательности 1.
     * @return Минимальное значение.
     */
    public static int findMin(int... data) {
        /* Вызов исключения IllegalArgumentException, если в
        последовательности вообще нет значений. */
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMin() необходим хотя бы одно значение.");

        data = processing(data);

        return data[0];
    }

    /**
     * Получение максимального значения из последовательности.
     */
    public static int findMax(int... data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMax() необходим хотя бы одно значение.");

        data = processing(data);

        return data[data.length - 1];
    }

    /**
     * Получение среднего значения в последовательности.
     */
    public static int findMean(int... data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMean() необходим хотя бы одно значение.");

        data = processing(data);

        /* Если окончательная длина последовательности нечётная, то из
        двух средних значений возвращается, то значение, которое ближе к
        максимальному */
        return data[data.length / 2];
    }

    /**
     * Предварительная обработка последовательности, перед её анализом.
     *
     * @param data Исходная последовательность чисел.
     * @return Последовательность отсортированная по возрастанию и без дубликатов.
     */
    private static int[] processing(int[] data) {
        int[] result;
        int counter = data.length;

        // Вычисление размера массива без дубликатов
        Arrays.sort(data);
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] == data[i]) counter--;
        }

        // Заполнение окончательного массива
        result = new int[counter];
        result[0] = data[0];
        for (int i = 1, j = 1; i < data.length; i++) {
            if (data[i - 1] != data[i]) {
                result[j] = data[i];
                j++;
            }
        }

        return result;
    }
}
