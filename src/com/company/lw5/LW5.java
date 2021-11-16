package com.company.lw5;

public class LW5 {
    public static void main(int[] args) {
        if (args.length == 0)
            args = new int[]{1, 2, 3, 4, 5, 6};

        for (var example : args) {
            System.out.println("Задание №" + example);
            switch (example) {
                case 1:
                    com.company.lw5.example1.Main.main(new String[0]);
                    break;
                case 2:
                    com.company.lw5.example2.Main.main(new String[0]);
                    break;
                case 3:
                    com.company.lw5.example3.Main.main(new String[0]);
                    break;
                case 4:
                    com.company.lw5.example4.Main.main(new String[0]);
                    break;
                case 5:
                    com.company.lw5.example5.Main.main(new String[0]);
                    break;
                case 6:
                    com.company.lw5.example6.Main.main(new String[0]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            System.out.println();
        }
    }
}

