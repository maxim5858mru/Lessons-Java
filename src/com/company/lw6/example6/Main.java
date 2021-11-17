package com.company.lw6.example6;

public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {1, 2, 3, 10, 15, 85, 13, 10},
                    LENGTHS = new int[] {0, 8, 5, 25};

        for (var item : LENGTHS) {
            SubArray.printSub(ARRAY, item);
        }
    }
}
