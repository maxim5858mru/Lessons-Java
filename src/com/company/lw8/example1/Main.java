package com.company.lw8.example1;

public class Main {
    private static int step = 0;

    public static void main(String[] args) {
        /* ПРИМЕР №1.
        Для заданного параметра x вывести
        последовательность значений элементов числового ряда в
        соответствии со следующими требованиями:

        - очередной элемент x = 2*x+1 (новое значение вычисляется с
        использованием старого);
        - 0 ≤ x < 20.
        */
        System.out.println("Пример №1:");
        sequenceOutput(1);
        System.out.println();

        /* ПРИМЕР №2
        Вывести последовательность, представленную в
        предыдущем примере, в обратном порядке.
         */
        System.out.println("\n\rПример №2:");
        SequenceOutputReverse(1);

        /* ПРИМЕР №3
        Для вышеописанного задания сделать вывод параметра
        перед вхождением в рекурсивный вызов и после него.
         */
        System.out.println("\n\rПример №3:");
        sequenceOutputMiddle(1);

        /* ПРИМЕР №4
        Вычислить факториал числа n с использованием
        рекурсии.
        */
        System.out.println("\n\rПример №4:");
        System.out.println("7! = " + factorial(7));

        /* ПРИМЕР №5
        Вывести число Фибоначчи, заданное его номером в
        последовательности.
        */
        System.out.println("\n\rПример №5: \n\r");
        System.out.println("\n\rFibonacci_Numbers[7] = " + fibonacciNumber(7));
    }

    private static void sequenceOutput(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            sequenceOutput(2 * x + 1);
        }
    }

    private static void SequenceOutputReverse(int x) {
        if ((2 * x + 1) < 20) {
            SequenceOutputReverse(2 * x + 1);
        }

        System.out.println("x=" + x);
    }

    private static void sequenceOutputMiddle(int x) {
        for (int i = 0; i < step; i++) {
            System.out.print(' ');
        }

        System.out.println("'+x+'->" + x);
        step++;
        if ((2 * x + 1) < 20) {
            sequenceOutputMiddle(2 * x + 1);
        }
        step--;

        for (int i = 0; i < step; i++) {
            System.out.print(' ');
        }
        System.out.println("'+x+'<-" + x);
    }

    private static int factorial(int n) {
        int result;
        if (n == 1) {
            return 1;
        } else {
            result = factorial(n - 1) * n;
            return result;
        }
    }

    private static int fibonacciNumber(int n) {
        System.out.println("Вывод последовательности вызовов: ");
        return fibonacciNumber(n, 0);
    }

    private static int fibonacciNumber(int n, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print('\t');
        }
        System.out.println("Called function[" + n + "]");
        i++;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciNumber(n - 2, i) + fibonacciNumber(n - 1, i);
        }
    }
}
