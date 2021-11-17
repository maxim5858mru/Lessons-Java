package com.company.lw6.example5;

final class SquareNumber {
    private SquareNumber() {}

    public static int getSum(int number, boolean useRecursion) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (useRecursion) return recursiveGetSum(number);
        else return usualGetSum(number);
    }

    private static int recursiveGetSum(int number) {
        if (number == 1) return (int) Math.pow(number, 2);
        else return (int) Math.pow(number, 2) + recursiveGetSum(number - 1);
    }

    private static int usualGetSum(int number) {
        int result = 0;

        while (number > 0) {
            result += (int) Math.pow(number, 2);
            number -= 1;
        }

        return result;
    }
}
