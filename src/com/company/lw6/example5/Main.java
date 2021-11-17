package com.company.lw6.example5;

public class Main {
    public static void main(String[] args) {
        final int[] FOR_USUAL_METHOD = new int[]{1, 2, 5, 7, 8};
        final int[] FOR_RECURSIVE_METHOD = new int[]{3, 7, 8, 10, 12};

        System.out.println("Вычисление суммы квадратов обычным способом:");
        for (var number : FOR_USUAL_METHOD) {
            System.out.printf("f(%d) = %d\n\r", number,
                    SquareNumber.getSum(number, false));
        }

        System.out.println("\n\rВычисление суммы квадратов рекурсивным способом:");
        for (var number : FOR_RECURSIVE_METHOD) {
            System.out.printf("f(%d) = %d\n\r", number,
                    SquareNumber.getSum(number, true));
        }
    }
}
