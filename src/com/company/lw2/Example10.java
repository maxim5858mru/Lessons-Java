package com.company.lw2;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int inputData, result;

        System.out.print("Введите число: ");

        inputData = input.nextInt();
        result = inputData & 0b111000;
        result >>= 3;

        System.out.printf("Во втором разряде в восьмеричной системе счисления, " +
                "число %d имеет цифру %d.\n\r", inputData, result);
    }
}
