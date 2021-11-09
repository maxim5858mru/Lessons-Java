# Отчёт по лабораторной работе №3 «Работа с операторами и одномерными массивами»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Получить представление о работе с операторами и одномерными
массивами в языке программирования Java.

## Описание задачи
- Изучение справочных материалов;
- Решение задач на программирование, по следующим темам:
  - работа с операторами,
  - одномерные массивы,
  - оператор выбора `switch`,
  - операторы цикла `for`, `while` и `do`;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 10 задач по программированию. Листинг кода 
написанных программ представлен ниже. 

#### Задание №1
Напишите программу, в которой пользователь вводит целое число
в диапазоне от 1 до 7, а программа определяет по этому числу день недели.
Если введенное пользователем число выходит за допустимый диапазон,
выводится сообщение о том, что введено некорректное значение. Используйте
оператор выбора `switch`.
```java
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int weekDayNumber;
        String weekDayName;

        System.out.print("Введите номер дня недели: ");
        weekDayNumber = input.nextInt();

        try {
            switch (weekDayNumber) {
                case 1:
                    weekDayName = "понедельник";
                    break;
                case 2:
                    weekDayName = "вторник";
                    break;
                case 3:
                    weekDayName = "среда";
                    break;
                case 4:
                    weekDayName = "четверг";
                    break;
                case 5:
                    weekDayName = "пятница";
                    break;
                case 6:
                    weekDayName = "суббота";
                    break;
                case 7:
                    weekDayName = "воскресенье";
                    break;
                default:
                    throw new Exception("Введённое число " + weekDayNumber +
                            " выходит за допустимый диапазон.");
            }

            System.out.printf("Указанный номер дня недели - это %s.\n\r", weekDayName);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
```

Вывод программы:
```text
Введите номер дня недели: 1
Указанный номер дня недели - это понедельник.
```

#### Задание №2
Напишите программу, в которой пользователю предлагается
ввести название дня недели. По введенному названию программа определяет
порядковый номер дня в неделе. Если пользователь вводит неправильное
название дня, программа выводит сообщение о том, что такого дня нет.
Предложите версию программы на основе вложенных условных операторов и
на основе оператора выбора `switch`.
```java
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int weekDayNumber;
        String weekDayName;

        System.out.print("Введите название дня недели: ");
        weekDayName = input.next();

        try {
            switch (weekDayName) {
                case "понедельник":
                    weekDayNumber = 1;
                    break;
                case "вторник":
                    weekDayNumber = 2;
                    break;
                case "среда":
                    weekDayNumber = 3;
                    break;
                case "четверг":
                    weekDayNumber = 4;
                    break;
                case "пятница":
                    weekDayNumber = 5;
                    break;
                case "суббота":
                    weekDayNumber = 6;
                    break;
                case "воскресенье":
                    weekDayNumber = 7;
                    break;
                default:
                    throw new Exception("Не существует дня недели с названием \"" + 
                            weekDayName + "\".");
            }

            System.out.printf("\"%s\" это %d день недели.\n\r", weekDayName, weekDayNumber);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}

```

Вывод программы:
```text
Введите название дня недели: вторник
"вторник" это 2 день недели.
```

#### Задание №3
Напишите программу, которая выводит последовательность чисел
Фибоначчи. Первые два числа в этой последовательности равны 1, а каждое
следующее число равно сумме двух предыдущих (получается последовательность 
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 и так далее). Количество чисел
в последовательности вводится пользователем. Предложите версии
программы, использующие разные операторы цикла.

Версия программы получающая один и тот же результат, 3 разными способами
(с помощью 3 разных операторов цикла). 
```java
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int[] fibonacciNumbers;
        int amount;

        System.out.print("Введите количество числе последовательности: ");
        amount = input.nextInt();

        if (amount <= 2) {
            System.err.println("Для вычисления последовательности Фибоначчи " +
                    "массив должен быть размером больше 2, иначе не имеет смысла.");
            return;
        }

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            fibonacciNumbers = getFibonacciNumbers(amount, cycles.FOR);
            printIntArray(fibonacciNumbers);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int[] getFibonacciNumbers(int amount, cycles waysToGet) {
        int[] numbers = new int[amount];
        numbers[0] = 1;
        numbers[1] = 1;

        switch (waysToGet) {
            case FOR:
                for (int i = 2; i < numbers.length; i++) {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                }
                break;
            case WHILE:
                int i = 2;

                while (i < numbers.length) {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                    i++;
                }
                break;
            case DO:
                i = 2;

                do {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                    i++;
                } while (i < numbers.length);
                break;
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Вывод программы:
```text
Введите количество числе последовательности: 6

Полученный массив, с помощью FOR:
[0] = 1
[1] = 1
[2] = 2
[3] = 3
[4] = 5
[5] = 8

Полученный массив, с помощью WHILE:
[0] = 1
[1] = 1
[2] = 2
[3] = 3
[4] = 5
[5] = 8

Полученный массив, с помощью DO:
[0] = 1
[1] = 1
[2] = 2
[3] = 3
[4] = 5
[5] = 8
```

Версия программы, использующая цикл `for`, для получения результат:
```java
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] fibonacciNumbers;
        int amount;

        System.out.print("Введите количество числе последовательности: ");
        amount = input.nextInt();

        if (amount <= 2) {
            System.err.println("Для вычисления последовательности Фибоначчи " +
                    "массив должен быть размером больше 2, иначе не имеет смысла.");
            return;
        }

        fibonacciNumbers = getFibonacciNumbers(amount);
        printIntArray(fibonacciNumbers);
    }

    private static int[] getFibonacciNumbers(int amount) {
        int[] numbers = new int[amount];
        numbers[0] = 1;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы, использующая цикл `while`, для получения результата:
```java
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] fibonacciNumbers;
        int amount;

        System.out.print("Введите количество числе последовательности: ");
        amount = input.nextInt();

        if (amount <= 2) {
            System.err.println("Для вычисления последовательности Фибоначчи " +
                    "массив должен быть размером больше 2, иначе не имеет смысла.");
            return;
        }

        fibonacciNumbers = getFibonacciNumbers(amount);
        printIntArray(fibonacciNumbers);
    }

    private static int[] getFibonacciNumbers(int amount) {
        int[] numbers = new int[amount];
        int i = 2;
        numbers[0] = 1;
        numbers[1] = 1;

        while (i < numbers.length) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
            i++;
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы использующая цикл `do`, для получения результата:
```java
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] fibonacciNumbers;
        int amount;

        System.out.print("Введите количество числе последовательности: ");
        amount = input.nextInt();

        if (amount <= 2) {
            System.err.println("Для вычисления последовательности Фибоначчи " +
                    "массив должен быть размером больше 2, иначе не имеет смысла.");
            return;
        }

        fibonacciNumbers = getFibonacciNumbers(amount);
        printIntArray(fibonacciNumbers);
    }

    private static int[] getFibonacciNumbers(int amount) {
        int[] numbers = new int[amount];
        int i = 2;
        numbers[0] = 1;
        numbers[1] = 1;

        do {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
            i++;
        } while (i < numbers.length);

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

#### Задание №4
Напишите программу, в которой пользователем вводится два
целых числа. Программа выводит все целые числа — начиная с наименьшего
(из двух введенных чисел) и заканчивая наибольшим (из двух введенных
чисел). Предложите разные версии программы (с использованием разных
операторов цикла).
```java
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int[] array;
        int a, b;

        System.out.print("Введите a и b: ");
        a = input.nextInt();
        b = input.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            array = getArray(a, b, item);
            printIntArray(array);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int[] getArray(int a, int b, cycles waysToGet) {
        int[] numbers = new int[b - a + 1];
        numbers[0] = a;

        switch (waysToGet) {
            case FOR:
                for (int i = 1; i < numbers.length; i++) {
                    numbers[i] = numbers[i - 1] + 1;
                }
                break;
            case WHILE:
                int i = 1;

                while (i < numbers.length) {
                    numbers[i] = numbers[i - 1] + 1;
                    i++;
                }
                break;
            case DO:
                i = 1;

                if (numbers.length == 0)
                    return numbers;

                do {
                    numbers[i] = numbers[i - 1] + 1;
                    i++;
                } while (i < numbers.length);
                break;
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Вывод программы:
```text
Введите a и b: 10 5

Полученный массив, с помощью FOR:
[0] = 5
[1] = 6
[2] = 7
[3] = 8
[4] = 9
[5] = 10

Полученный массив, с помощью WHILE:
[0] = 5
[1] = 6
[2] = 7
[3] = 8
[4] = 9
[5] = 10

Полученный массив, с помощью DO:
[0] = 5
[1] = 6
[2] = 7
[3] = 8
[4] = 9
[5] = 10
```

Версия программы, использующая цикл `for`, для получения результат:
```java
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] array;
        int a, b;

        System.out.print("Введите a и b: ");
        a = input.nextInt();
        b = input.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        array = getArray(a, b);
        printIntArray(array);
    }

    private static int[] getArray(int a, int b) {
        int[] numbers = new int[b - a + 1];
        numbers[0] = a;

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + 1;
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы, использующая цикл `while`, для получения результат:
```java
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] array;
        int a, b;

        System.out.print("Введите a и b: ");
        a = input.nextInt();
        b = input.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        array = getArray(a, b);
        printIntArray(array);
    }

    private static int[] getArray(int a, int b) {
        int[] numbers = new int[b - a + 1];
        int i = 1;
        numbers[0] = a;

        while (i < numbers.length) {
            numbers[i] = numbers[i - 1] + 1;
            i++;
        }

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы, использующая цикл `do`, для получения результат:
```java
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[] array;
        int a, b;

        System.out.print("Введите a и b: ");
        a = input.nextInt();
        b = input.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        array = getArray(a, b);
        printIntArray(array);
    }

    private static int[] getArray(int a, int b) {
        int[] numbers = new int[b - a + 1];
        int i = 1;
        numbers[0] = a;

        if (numbers.length == 0)
            return numbers;

        do {
            numbers[i] = numbers[i - 1] + 1;
            i++;
        } while (i < numbers.length);

        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

#### Задание №5
Напишите программу, в которой вычисляется сумма чисел,
удовлетворяющих таким критериям: при делении числа на 5 в остатке 
получается 2, или при делении на 3 в остатке получается 1. 
Количество чисел в сумме вводится пользователем. Программа 
отображает числа, которые суммируются, и значение суммы. 
Предложите версии программы, использующие разные операторы цикла.
```java
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        final cycles[] WAYSTOGET = new cycles[] {cycles.FOR, cycles.WHILE, cycles.DO};

        var input = new Scanner(System.in);
        int sum, amount;

        System.out.print("Введите количество элементов в массиве: ");
        amount = input.nextInt();

        for (var item: WAYSTOGET) {
            System.out.printf("\n\rПолученный массив, с помощью %s:\n\r", item);
            sum = getSum(amount, item);
            System.out.println("Сумма элементов : " + sum);
        }
    }

    private enum cycles { FOR, WHILE, DO }

    private static int getSum(int amount, cycles waysToGet) {
        int[] numbers = new int[amount];
        int sum = 0;

        switch (waysToGet) {
            case FOR:
                for (int i = 0, y = 1; i < numbers.length;) {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                }
                break;
            case WHILE:
                int i = 0, y = 1;

                while (i < numbers.length) {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                }
                break;
            case DO:
                i = 0;
                y = 1;

                if (numbers.length == 0)
                    return 0;

                do {
                    if ((y % 5 == 2) || (y % 3 == 1)) {
                        numbers[i] = y;
                        sum += y;
                        i++;
                    }
                    y++;
                } while (i < numbers.length);
                break;
        }
        printIntArray(numbers);

        return sum;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Вывод программы:
```text
Введите количество элементов в массиве: 6

Полученный массив, с помощью FOR:
[0] = 1
[1] = 2
[2] = 4
[3] = 7
[4] = 10
[5] = 12
Сумма элементов : 36

Полученный массив, с помощью WHILE:
[0] = 1
[1] = 2
[2] = 4
[3] = 7
[4] = 10
[5] = 12
Сумма элементов : 36

Полученный массив, с помощью DO:
[0] = 1
[1] = 2
[2] = 4
[3] = 7
[4] = 10
[5] = 12
Сумма элементов : 36
```

Версия программы, использующая цикл `for`, для получения результат:
```java
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int sum, amount;

        System.out.print("Введите количество элементов в массиве: ");
        amount = input.nextInt();

        sum = getSum(amount, item);
        System.out.println("Сумма элементов : " + sum);
    }

    private static int getSum(int amount) {
        int[] numbers = new int[amount];
        int sum = 0;

        for (int i = 0, y = 1; i < numbers.length;) {
            if ((y % 5 == 2) || (y % 3 == 1)) {
                numbers[i] = y;
                sum += y;
                i++;
            }
            y++;
        }
        printIntArray(numbers);

        return sum;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы, использующая цикл `while`, для получения результат:
```java
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int sum, amount;

        System.out.print("Введите количество элементов в массиве: ");
        amount = input.nextInt();

        sum = getSum(amount, item);
        System.out.println("Сумма элементов : " + sum);
    }

    private static int getSum(int amount) {
        int[] numbers = new int[amount];
        int sum = 0, i = 0, y = 1;

        while (i < numbers.length) {
            if ((y % 5 == 2) || (y % 3 == 1)) {
                numbers[i] = y;
                sum += y;
                i++;
            }
            y++;
        }
        printIntArray(numbers);

        return sum;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Версия программы, использующая цикл `do`, для получения результат:
```java
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int sum, amount;

        System.out.print("Введите количество элементов в массиве: ");
        amount = input.nextInt();

        sum = getSum(amount, item);
        System.out.println("Сумма элементов : " + sum);
    }

    private static int getSum(int amount) {
        int[] numbers = new int[amount];
        int sum = 0, i = 0, y = 1;

        if (numbers.length == 0)
            return 0;

        do {
            if ((y % 5 == 2) || (y % 3 == 1)) {
                numbers[i] = y;
                sum += y;
                i++;
            }
            y++;
        } while (i < numbers.length);
        printIntArray(numbers);

        return sum;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

#### Задание №6
Напишите программу, в которой создаётся одномерный числовой
массив и заполняется числами, которые при делении на 5 дают в остатке 2
(числа 2, 7, 12, 17 и так далее). Размер массива вводится пользователем.
Предусмотреть обработку ошибки, связанной с вводом некорректного
значения.
```java
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int amount;
        int[] numbers;

        while (true) {
            try {
                System.out.print("Введите количество элементов в массиве: ");
                amount = input.nextInt();

                if (amount < 1)
                    throw new Exception("Размер массива должен быть больше, чем 0.\n\r");
                else
                    break;
            } catch (java.util.InputMismatchException exception) {
                System.err.println("Из введённой строки нельзя извлечь число.\n\r");
                input.nextLine();
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                input.nextLine();
            }
        }

        numbers = getArray(amount);
        printIntArray(numbers);
    }

    private static int[] getArray(int amount) {
        int[] numbers = new int[amount];

        for (int i = 0, y = 1; i < numbers.length;) {
            if (y % 5 == 2) {
                numbers[i] = y;
                i++;
            }
            y++;
        }
        return numbers;
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }
}
```

Вывод программы:
```text
Введите количество элементов в массиве: Hello World!
Из введённой строки нельзя извлечь число.

Введите количество элементов в массиве: 0
Размер массива должен быть больше, чем 0.

Введите количество элементов в массиве: 5
[0] = 2
[1] = 7
[2] = 12
[3] = 17
[4] = 22
```

#### Задание №7
Напишите программу, в которой создаётся одномерный
символьный массив из 10 элементов. Массив заполняется буквами «через
одну», начиная с буквы 'а': то есть массив заполняется буквами 'а', 'с', 'е',
'д' и так далее. Отобразите массив в консольном окне в прямом и обратном
порядке. Размер массива задаётся переменной.

```java
public class Example7 {
    public static void main(String[] args) {
        int amount = 10;
        char[] chars;

        System.out.printf("Длина массива символов: %d.\n\r", amount);

        chars = getCharArray(amount);

        System.out.println("\n\rВывод массива символов, в прямом порядке.");
        PrintCharArray(chars, true);

        System.out.println("\n\rВывод массива символов, в обратном порядке.");
        PrintCharArray(chars, false);
    }

    private static char[] getCharArray(int amount) {
        char[] chars = new char[amount];

        chars[0] = 'a';

        for (int i = 1; i < chars.length; i++) {
            chars[i] = (char)(chars[i - 1] + 2);
        }

        return chars;
    }

    private static void PrintCharArray(char[] array, boolean isDirectOrder) {
        if (isDirectOrder) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("[%d] = %s\n\r", i, array[i]);
            }
        }
        else {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.printf("[%d] = %s\n\r", i, array[i]);
            }
        }
    }
}
```

Вывод программы:
```text
Длина массива символов: 10.

Вывод массива символов, в прямом порядке:
[0] = a
[1] = c
[2] = e
[3] = g
[4] = i
[5] = k
[6] = m
[7] = o
[8] = q
[9] = s

Вывод массива символов, в обратном порядке:
[9] = s
[8] = q
[7] = o
[6] = m
[5] = k
[4] = i
[3] = g
[2] = e
[1] = c
[0] = a
```

#### Задание №8
Напишите программу, в которой создаётся символьный массив из 10 элементов. 
Массив заполнить большими (прописными) буквами английского алфавита. 
Буквы берутся подряд, но только согласные (то есть гласные буквы ’А', 'Е' 
и 'I' при присваивании значений элементам массива нужно пропустить). 
Отобразите содержимое созданного массива в консольном окне.

```java
public class Example8 {
    public static void main(String[] args) {
        int amount = 10;
        char[] chars;

        System.out.printf("Длина массива символов: %d.\n\r", amount);

        chars = getCharArray(amount);
        printIntArray(chars);
    }

    private static char[] getCharArray(int amount) {
        final char[]  VOWELS = new char[] {'A', 'E', 'I', 'O', 'U', 'Y'};
        char[] chars = new char[amount];

        for (int i = 0, y = 0, z = 'A'; i < chars.length; z++) {
            if (z != VOWELS[y]) {
                chars[i] = (char)z;
                i++;
            }
            else {
                if (y != VOWELS.length -1)
                    y++;
            }
        }

        return chars;
    }

    private static void printIntArray(char[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %s\n\r", i, item);
            i++;
        }
    }
}
```

Вывод программы:
```text
Длина массива символов: 10.
[0] = B
[1] = C
[2] = D
[3] = F
[4] = G
[5] = H
[6] = J
[7] = K
[8] = L
[9] = M
```

#### Задание №9
Напишите программу, в которой создаётся массив n, заполняется
случайными числами. Массив отображается в консольном окне. В этом
массиве необходимо определить элемент с минимальным значением. В
частности, программа должна вывести значение элемента с минимальным
значением и индекс этого элемента. Если элементов с минимальным
значением несколько, должны быть выведены индексы всех этих элементов.
```java
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int[] numbers, minValues;

        System.out.print("Введите размер массива: ");
        numbers = new int[input.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(5);
        }
        System.out.println("\n\rСгенерированный массив до сортировки:");
        printIntArray(numbers);

        minValues = findMinValue(numbers);
        System.out.println("Минимальное значение: " + numbers[minValues[0]]);
        System.out.print("Индексы массива с минимальным значением: ");

        for (var item: minValues) {
            System.out.printf("[%d] ", item);
        }
        System.out.println();
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }

    private static int[] findMinValue(int[] inputArray) {
        int amount = 1;
        int[] sortArray = inputArray.clone(), result;
        Arrays.sort(sortArray);

        // Подсчёт количества одинаковых минимальных значений
        for (int i = 0; i < sortArray.length; i++) {
            if (sortArray[i] == sortArray[i + 1])
                amount++;
            else
                break;
        }

        // Поиск в неотсортированном массиве одинаковых минимальных значений
        result = new int[amount];
        for (int i = 0, y = 0; i < inputArray.length; i++) {
            if (inputArray[i] == sortArray[0]) {
                result[y] = i;
                y++;
            }
        }

        return result;
    }
}
```

Вывод программы:
```text
Введите размер массива: 10

Сгенерированный массив до сортировки:
[0] = 3
[1] = 0
[2] = 1
[3] = 1
[4] = 4
[5] = 2
[6] = 3
[7] = 1
[8] = 1
[9] = 0
Минимальное значение: 0
Индексы массива с минимальным значением: [1] [9] 
```

#### Задание №10
Напишите программу, в которой создаётся целочисленный
массив, заполняется случайными числами и после этого значения 
элементов в массиве сортируются в порядке убывания значений.
```java
import java.util.Random;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int[] numbers;

        System.out.print("Введите размер массива: ");
        numbers = new int[input.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-200, 200);
        }
        System.out.println("\n\rСгенерированный массив до сортировки:");
        printIntArray(numbers);

        reverseOrderSort(numbers);
        System.out.println("\n\rМассив после сортировки по убыванию:");
        printIntArray(numbers);
    }

    private static void printIntArray(int[] array) {
        int i = 0;
        for (var item: array) {
            System.out.printf("[%d] = %d\n\r", i, item);
            i++;
        }
    }

    private static void reverseOrderSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] > array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
```

Вывод программы:
```text
Введите размер массива: 10

Сгенерированный массив до сортировки:
[0] = 115
[1] = -39
[2] = -132
[3] = -36
[4] = -199
[5] = 119
[6] = 199
[7] = -146
[8] = -60
[9] = 128

Массив после сортировки по убыванию:
[0] = 199
[1] = 128
[2] = 119
[3] = 115
[4] = -36
[5] = -39
[6] = -60
[7] = -132
[8] = -146
[9] = -199
```

## Вывод
В рамках лабораторной работы по изучению языка программирования 
Java были рассмотрена работа с операторами и одномерными массивами.
Кроме этого были затронуты такие темы как обработка ошибок при вводе 
данных пользователем, оператор выбора `switch`, класс `Random`, 
операторы цикла `for`, `while`, `do`, а также тема сортировки массива.

В рамках лабораторной работы было решено 10 задач. Листинг кода всех 
написанных программ был представлен в этом отчёте. В результате 
можно сказать, что цель лабораторной работы была достигнута, а 
поставленные задачи выполнены.