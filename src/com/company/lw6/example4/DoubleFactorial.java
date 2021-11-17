package com.company.lw6.example4;

final class DoubleFactorial {
    private DoubleFactorial() {}

    public static int getValue(int number, boolean useRecursion) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (useRecursion) return recursiveMethod(number);
        else return usualMethod(number);
    }

    /**
     * Рекурсивная реализация метода вычисления двойного факториала.
     * Рекурсия вызывается до тех пор, пока не дойдёт до числа
     * равного или меньше 2.
     */
    private static int recursiveMethod(int number) {
        if (number <= 2) return number;
        else return number * recursiveMethod(number - 2);
    }

    /**
     * Не рекурсивный способ, с помощью цикла.
     */
    private static int usualMethod(int number) {
        int result = (number % 2 == 1) ? 1: 2;

        while (number > 2) {
            result *= number;
            number -= 2;
        }

        return result;
    }
}
