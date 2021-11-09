package com.company.lw4;

public class Example4 {
    public static void main(String[] args) {
        final int WIDTH = 10, HEIGHT = 10;
        double k = (double) (WIDTH - 1) / (HEIGHT - 1);
        char[][] lines = new char[HEIGHT][];

        for (int i = 0; i < HEIGHT; i++) {
            lines[i] = new char[(int)(i * k) + 1];

            for (int j = 0; j < lines[i].length; j++) {
                if (i == HEIGHT - 1)
                    lines[i][j] = '-';
                else if (j == 0)
                    lines[i][j] = '|';
                else if (j == (int)(i * k))
                    lines[i][j] = '\\';
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
