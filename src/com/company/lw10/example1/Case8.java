package com.company.lw10.example1;

public class Case8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        /* После вызова исключения обработчик исключений
           выполняет поиск соответствующего блока catch.
           В данном случае он отсутствует, поэтому будет
           выполнен в начале код блока finally, а потом
           исключение будет передано в метод main. Так как
           в main метод m выполнится не в блоке try-catch
           исключение будет необработанным и приведёт к
           завершению работы программы с ошибкой.
         */
        System.out.println(m());
    }
}
