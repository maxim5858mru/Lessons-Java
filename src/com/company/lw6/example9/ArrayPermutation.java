package com.company.lw6.example9;

final class ArrayPermutation {
    private ArrayPermutation() {}

    /**
     * Попарная перестановка в массиве. Все изменения
     * выполняются в исходном массиве.
     *
     * @param array Исходный массив
     */
    public static <T> void pairwise(T[] array) {
        /* Если длина массива не чётная, то последний элемент
        остаётся на своём месте.*/
        for (int i = 0; i < array.length - 1; i += 2) {
            T temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }
}
