package com.company.lw4;

public class Example2 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        double k = (double) (WIDTH - 1) / (HEIGHT - 1);
        String line;

        for (int i = 0; i < HEIGHT; i++) {
            line = "";
            printLineNumber(i + 1, HEIGHT);

            /* Вычисление ширины каждой строки выполняется с
             * использованием коэффициента соотношения сторон
             */
            for (int j = 0; j < (int)(i * k) + 1; j++) {
                if (i == HEIGHT - 1)
                    line += '-';
                else if (j == 0)
                    line += '|';
                else if (j == (int)(i * k))
                    line += '\\';
                else
                    line += ' ';
            }
            System.out.println(line);
        }
    }

    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }
}
