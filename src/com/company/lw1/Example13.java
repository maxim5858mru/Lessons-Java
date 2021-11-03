package com.company.lw1;

import java.util.Scanner;

public class Example13 {
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
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
