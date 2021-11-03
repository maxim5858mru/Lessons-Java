package com.company.lw1;

public class Example11 {
    static double a = 10.0, b = 4.0, c;

    public static void main(String[] args) {
        System.out.println("Катет a = " + a);
        System.out.println("Катет b = " + b);
        System.out.println("Гипотенуза c = " + hyp());
    }

    public static double hyp() {
        return c = Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double a, double b) {
        return Math.exp(b * Math.log(a));
    }
}
