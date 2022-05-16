package com.company.lw10.example1;

public class Case9 {
    public static int m() {
        try {
            System.out.println("0");
            return 55;
        } finally {
            /* Блок finally должен выполняться независимо от того, было ли
               вызованно исключения или было ли оно обработано. В данном случае
               перед выходом из метода выполняется блок finally, а после
               управление программой передаётся методу main.

               Именно поэтому работа с файлами выполняется в блоке try-catch.
               Независимо от того была ли успешно выполнена работа с файлом,
               блок finally должен закрыть файл (чтобы другие программы могли
               его потом использовать).
             */
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
