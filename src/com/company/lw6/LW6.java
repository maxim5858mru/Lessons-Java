package com.company.lw6;

public class LW6 {
    public static void main(int[] args) {
        if (args.length == 0)
            args = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (var example : args) {
            System.out.println("Задание №" + example);
            switch (example) {
                case 1:
                    com.company.lw6.example1.Main.main(new String[0]);
                    break;
                case 2:
                    com.company.lw6.example2.Main.main(new String[0]);
                    break;
                case 3:
                    com.company.lw6.example3.Main.main(new String[0]);
                    break;
                case 4:
                    com.company.lw6.example4.Main.main(new String[0]);
                    break;
                case 5:
                    com.company.lw6.example5.Main.main(new String[0]);
                    break;
                case 6:
                    com.company.lw6.example6.Main.main(new String[0]);
                    break;
                case 7:
                    com.company.lw6.example7.Main.main(new String[0]);
                    break;
                case 8:
                    com.company.lw6.example8.Main.main(new String[0]);
                    break;
                case 9:
                    com.company.lw6.example9.Main.main(new String[0]);
                    break;
                case 10:
                    com.company.lw6.example10.Main.main(new String[0]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            System.out.println();
        }
    }
}
