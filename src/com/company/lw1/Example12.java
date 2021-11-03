package com.company.lw1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        double a, b;
        var input = new Scanner(System.in);

        System.out.print("Катет a = ");
        a = input.nextDouble();

        System.out.print("Катет b = ");
        b = input.nextDouble();

        System.out.println("Гипотенуза c = " + hyp(a, b));
    }

    public static double hyp(double a, double b) {
        return Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double a, double b) {
        return Math.exp(b * Math.log(a));
    }
}
