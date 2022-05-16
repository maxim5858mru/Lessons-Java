package com.company.lw11.example1;

@FunctionalInterface
interface CaseInterface {
    public void main(String[] args);
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        com.company.lw11.example1.CaseInterface[] cases = new com.company.lw11.example1.CaseInterface[] {
                str -> Case1.main(str),
                str -> Case2.main(str),
                str -> Case3.main(str),
                str -> Case4.main(str),
                str -> Case5.main(str),
                str -> Case6.main(str),
                str -> Case7.main(str),
                str -> Case8.main(str),
                str -> Case9.main(str),
                str -> Case10.main(str)
        };

        for (int i = 0; i < cases.length; i++) {
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