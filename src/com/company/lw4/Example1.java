package com.company.lw4;

public class Example1 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        String line;

        for (int i = 0; i < HEIGHT; i++) {
            /* В цикле происходит формирование строки.
             * И только по окончанию работы цикла, она
             * выводится на экран.
             */
            line = "";
            printLineNumber(i + 1, HEIGHT);

            // Прямоугольник формируется с контуром, без заливки
            for (int j = 0; j < WIDTH; j++) {
                if ((i == 0) || (i == HEIGHT - 1))
                    line += '-';
                else if ((j == 0) || (j == WIDTH - 1))
                    line += '|';
                else
                    line += ' ';
            }

            System.out.println(line);
        }
    }

    /**
     * Вывод префикса, т.е. номера строки, который выравнен по правому краю
     * с учётом максимального возможного индекса строки.
     * @param index Текущий индекс строки.
     * @param maxIndex Максимально возможный индекс строки.
     */
    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        // Вычисление максимально возможного разряда числа, номера строки
        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }
}
