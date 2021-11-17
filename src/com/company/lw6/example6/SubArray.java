package com.company.lw6.example6;

final class SubArray {
    private SubArray() {}

    /**
     * Получение подмассива из массива.
     *
     * @param array Исходный массив.
     * @param newLength Новая длина массива.
     * @return Подмассив выделенный из исходного массива.
     */
    public static int[] getSub(int[] array, int newLength) {
        int[] result;

        /* Если новая длина больше исходного массива, то длина нового
        массива будет равна длине исходного. */
        if (newLength > array.length) result = new int[array.length];
        else result = new int[newLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }

        return result;
    }

    /**
     * Получение подмассива из исходного массива и его вывод в консоль.
     */
    public static void printSub(int[] array, int newLength) {
        String result = "{ ";
        array = getSub(array, newLength);

        for (int i = 0; i < array.length; i++) {
            result += array[i] + "; ";
        }
        result += " }";

        System.out.println(result);
    }
}
