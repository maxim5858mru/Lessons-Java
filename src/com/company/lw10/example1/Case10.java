package com.company.lw10.example1;

public class Case10 {
    public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            /* return выполняемый в блоке finally имеет больший
               приоритет, чем return в блоке try (или catch).
             */
            System.out.println("1");
            return 20;
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
