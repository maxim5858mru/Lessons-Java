package com.company.lw8;

public class LW8 {
    public static void main(int[] args) {
        if (args.length == 0)
            args = new int[]{1, 2, 3, 4, 5};

        for (var example : args) {
            System.out.println("Задание №" + example);
            switch (example) {
                case 1 -> com.company.lw8.example1.Main.main(new String[0]);
                case 2 -> com.company.lw8.example2.Main.main(new String[0]);
                case 3 -> com.company.lw8.example3.Main.main(new String[0]);
                case 4 -> com.company.lw8.example4.Main.main(new String[0]);
                case 5 -> com.company.lw8.example5.Main.main(new String[0]);
                case 6 -> com.company.lw8.example6.Main.main(new String[0]);
                case 7 -> com.company.lw8.example7.Main.main(new String[0]);
                default -> throw new IllegalArgumentException();
            }
            System.out.println();
        }
    }
}
