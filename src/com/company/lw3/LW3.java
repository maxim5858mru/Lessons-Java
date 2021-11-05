package com.company.lw3;

public class LW3 {
    public static void main(int[] args) {
        if (args.length == 0)
            args = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (var example : args) {
            System.out.println("Задание №" + example);
            switch (example) {
                case 1:
                    Example1.main(new String[0]);
                    break;
                case 2:
                    Example2.main(new String[0]);
                    break;
                case 3:
                    Example3.main(new String[0]);
                    break;
                case 4:
                    Example4.main(new String[0]);
                    break;
                case 5:
                    Example5.main(new String[0]);
                    break;
                case 6:
                    Example6.main(new String[0]);
                    break;
                case 7:
                    Example7.main(new String[0]);
                    break;
                case 8:
                    Example8.main(new String[0]);
                    break;
                case 9:
                    Example9.main(new String[0]);
                    break;
                case 10:
                    Example10.main(new String[0]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            System.out.println();
        }
    }
}
