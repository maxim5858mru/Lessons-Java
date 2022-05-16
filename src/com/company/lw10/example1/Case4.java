package com.company.lw10.example1;

public class Case4 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            /* Вызванное исключение не является исключением класса
               NullPointerException и класс NullPointerException не
               является суперклассом вызываемого исключения. Поэтому
               исключение не будет перехвачено этим блоком catch.
             */
            System.out.println("1");
        } catch (Exception e) {
            /* Класс Exception является суперклассом NullPointerException.
               Поэтому исключение будет перехвачено этим блоком catch.
             */
            System.out.println("2");
        } catch (Error e) {
            /* Данный блок не сможет перехватить исключение так как оно будет
               обработано вторым блоком catch, а также потому вызванное исключение
               принадлежит другому классу и класс Error не является его суперклассом.
             */
            System.out.println("3");
        }
        System.out.println("4");
    }
}
