package com.company.lw12.example1;

import java.io.IOException;

@FunctionalInterface
interface CaseInterface {
    public void main(String[] args);
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var cases = new CaseInterface[]{
                str -> {
                    try {
                        Case1.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    try {
                        Case2.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    Case3.main(args);
                },
                str -> {
                    try {
                        Case4.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    try {
                        Case5.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    Case6.main(args);
                },
                str -> {
                    Case7.main(args);
                },
        };

        for (int i = 1; i < cases.length; i++) {
            try {
                System.out.println("Пример №" + i);
                cases[i].main(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(10);               // Задержка для вывода данных в консоль с потока err
            } finally {
                System.out.println();
            }
        }
    }
}
