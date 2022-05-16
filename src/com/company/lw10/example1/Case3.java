package com.company.lw10.example1;

public class Case3 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            /* Вызванное исключение RuntimeException
               не является подклассом NullPointerException.
               Поэтому этот блок catch не перехватит исключение.
            */
            System.out.println("1");
        } catch (RuntimeException e) {
            /* Данный блок catch перехватит исключение, так как
               указанный обрабатываемый тип соответствует вызванному
               исключению.
             */
            System.out.println("2");
        } catch (Exception e) {
            /* Несмотря на то, что класс Exception является суперклассом
               RuntimeException, данный блок catch не перехватит исключение,
               так как оно уже было перехвачено вторым блоком catch.
             */
            System.out.println("3");
        }
        System.out.println("4");
    }
}
