package com.company.lw10.example1;

public class Case6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        }

        /* Закомментированный код вызывает ошибку, так как
           в Java запрещено указывать catch обрабатывающий
           исключения суперкласса выше catch-ей для обработки
           исключений подклассов. Указание catch подклассов
           после catch суперкласса является бессмысленным,
           так как обработка исключений выполняется последовательно.
         */
//        catch (Exception e) {
//            System.out.println("2");
//        } catch (RuntimeException e) {
//            System.out.println("3");
//        }

        // Правильный порядок
        catch (RuntimeException e) {
            System.out.println("3");
        } catch (Exception e) {
            System.out.println("2");
        }
        System.out.println("4");
    }
}
