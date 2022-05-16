package com.company.lw10.example1;

public class Case2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");

            /* Следующий код в блоке try никогда не выполнится,
             так как вызов исключения передаёт управление блоку catch. */
//            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2 "+ e );
        }
        System.out.println("3");
    }
}
