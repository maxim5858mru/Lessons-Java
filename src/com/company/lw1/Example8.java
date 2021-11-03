package com.company.lw1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        BigDecimal x, y, result;
        var input = new Scanner(System.in);

        System.out.print("Введите x: ");
        x = new BigDecimal(input.next());

        System.out.print("Введите y: ");
        y = new BigDecimal(input.next());

        result = x.add(y);
        System.out.printf("Сумма %s и %s = %s\n\r", x, y, result);
    }
}
