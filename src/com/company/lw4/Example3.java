package com.company.lw4;

public class Example3 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        char[][] lines = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if ((i == 0) || (j == 0) || (j == WIDTH - 1) || (i == HEIGHT - 1))
                     lines[i][j] = '2';
                else
                    lines[i][j] = ' ';
            }
        }
        
        printCharArray(lines);
    }

    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }

    /**
     * Вывод массива по строчно, с указанием индекса строки
     * @param array Выводимый массив.
     */
    private static void printCharArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            printLineNumber(i + 1, array.length);

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
