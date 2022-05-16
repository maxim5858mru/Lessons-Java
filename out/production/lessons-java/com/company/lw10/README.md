# Отчёт по лабораторной работе №10 «Наследование. Обработка исключительных ситуаций»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы

Знакомство с иерархией классов исключений и получение
навыков обработки ошибок.

## Описание задачи

- Изучение справочного материала;
- Решение задач по программированию на следующие темы:
    - Наследование;
    - Иерархия исключений;
    - Обработка исключений;
    - Оператор Throws;
- Оформление отчёта по лабораторной работе.

## Ход работы

В ходе работы было решено 4 задач по программированию. Листинг кода
представлен ниже.

#### Задание №1

Выполнить примеры 1-14 лабораторной работы, дав
письменно объяснения (в комментариях к коду) последовательности
выполняемых команд.

Код класса `Case1`:

```java
public class Case1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");     // Вызов исключения RuntimeException
        } catch (RuntimeException e) {                              // Перехват исключения
            System.out.println("1 " + e);                           // Обработка исключения
        }

        System.out.println("2");
    }
}
```

Код класса `Case2`:

```java
public class Case2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
      
            /* Следующий код в блоке try никогда не выполнится,
               так как вызов исключения передаёт управление блоку catch. 
            */
            // System.out.println("1");
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
```

Код класса `Case3`:

```java
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
```

Код класса `Case4`:

```java
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
               обработано вторым блоком catch, а также потому что вызванное исключение
               принадлежит другому классу и класс Error не является его суперклассом.
             */
            System.out.println("3");
        }
        System.out.println("4");
    }
}
```

Код класса `Case5`:

```java
public class Case5 {
    public static void main(String[] args) {
        /* Программа завершится с ошибкой, так как нет блока catch
           который смог бы перехватить исключение.
         */
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }
}
```

Код класса `Case6`:

```java
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
```

Код класса `Case7`:

```java
public class Case7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");

            /* Для перехвата исключения вызываемого в блоке catch
               необходим новый обработчик исключений try-catch, в
               который будет вложен текущий обработчик, вызывающий
               исключение в catch. Поэтому программа завершится с 
               ошибкой.
             */
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("2");
        }
    }
}
```

Код класса `Case8`:

```java
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
```

Код класса `Case9`:

```java
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
```

Код класса `Case10`:

```java
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
```

Код класса `Case11`:

```java
public class Case11 {
    public static void main(String[] args) {
        /* В данном случае все 3 блока обработчика исключений
           выполняются. После выполняются команда находящая 
           после блока try-catch.  
         */
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }
}
```

Код класса `Case12`:

```java
public class Case12 {
    public static void m(String str, double number) {
        /* В данной программе используется исключение класса 
           IllegalArgumentException, из пакета java.lang. Данное
           исключение обозначает что передан неверный аргумент.
         */

        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (number > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        m(null, 0.000001);
    }
}
```

Код класса `Case13`:

```java
public class Case13 {
    public static void main(String[] args) {
        try {
            /* Так как программа вызывается без передачи ей аргументов,
               то инициализация переменой l вызовет исключение 
               ArithmeticException, из-за деления на 0.
               
               Если программе будут переданы аргументы, то попытка доступа
               к элементу массива args[l + 1] вызовет исключение 
               ArrayIndexOutOfBoundsException.
             */
            int l = args.length;
            System.out.println("Размер массива = " + l);
            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}
```

Код класса `Case14`:

```java
public class Case14 {
    /* Оператор throws указывает, что метод необходимо вызывать 
       в блоке try-catch с обработчиками указанных исключений.
       Тем самым это позволит избежать завершения программы с ошибкой.
     */
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("Размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
```

Код класса `Main`:

```java

@FunctionalInterface
interface CaseInterface {
    public void main(String[] args);
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CaseInterface[] cases = new CaseInterface[]{
                str -> Case1.main(str),
                str -> Case2.main(str),
                str -> Case3.main(str),
                str -> Case4.main(str),
                str -> Case5.main(str),
                str -> Case6.main(str),
                str -> Case7.main(str),
                str -> Case8.main(str),
                str -> Case9.main(str),
                str -> Case10.main(str),
                str -> Case11.main(str),
                str -> Case12.main(str),
                str -> Case13.main(str),
                str -> Case14.main(str)
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
```

Вывод программы:

```text
Пример №0
0
1 java.lang.RuntimeException: Непроверяемая ошибка
2

Пример №1
0
2 java.lang.RuntimeException: Непроверяемая ошибка
3

Пример №2
0
2
4

Пример №3
0
2
4

Пример №4
0
java.lang.RuntimeException: ошибка
	at com.company.lw10.example1.Case5.main(Case5.java:10)
	at com.company.lw10.example1.Main.lambda$main$4(Main.java:15)
	at com.company.lw10.example1.Main.main(Main.java:30)

Пример №5
0
3
4

Пример №6
0
1
java.lang.ArithmeticException
	at com.company.lw10.example1.Case7.main(Case7.java:17)
	at com.company.lw10.example1.Main.lambda$main$6(Main.java:17)
	at com.company.lw10.example1.Main.main(Main.java:30)

Пример №7
0
1
java.lang.RuntimeException
	at com.company.lw10.example1.Case8.m(Case8.java:7)
	at com.company.lw10.example1.Case8.main(Case8.java:23)
	at com.company.lw10.example1.Main.lambda$main$7(Main.java:18)
	at com.company.lw10.example1.Main.main(Main.java:30)

Пример №8
0
1
55

Пример №9
0
1
20

Пример №10
0
1
2
3

Пример №11
java.lang.IllegalArgumentException: Строка введена неверно
	at com.company.lw10.example1.Case12.m(Case12.java:11)
	at com.company.lw10.example1.Case12.main(Case12.java:19)
	at com.company.lw10.example1.Main.lambda$main$11(Main.java:22)
	at com.company.lw10.example1.Main.main(Main.java:30)

Пример №12
Размер массива = 0
Деление на ноль

Пример №13
Размер массива= 0
Ошибка: Деление на ноль
```

#### Задание №2

Выполнить все задания из таблицы №2:

- Определить экспериментально, ошибки каких классов будут
  сгенерированы;
- Создать обработчики исключительных ситуаций с
  использованием выявленных классов и всех секций конструкции
  обработчика с соответствующими сообщениями, позволяющими
  корректно выполнить программу.

Каждое задание выполнить в виде двух проектов: без
использования собственных методов и с использованием методов для
каждой подзадачи, которые могут генерировать исключительную
ситуацию.

#### Задание №2.1

В программе, вычисляющей среднее значение среди положительных элементов
одномерного массива (тип элементов `int`), вводимого с клавиатуры, могут
возникать ошибки в следующих случаях:

- Ввод строки вместо числа;
- Несоответствие числового типа данных;
- Положительные элементы отсутствуют.

Код класса `Realization1`, без использования собственных методов:

```java
import com.company.lw10.example2.HasNotPositiveIntegerException;
import com.company.lw10.example2.IsNotIntegerException;
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        int sum = 0, counter = 0;
        int[] data = null;

        // Получение размера массива
        do {
            try {
                System.out.print("Введите количество элементов: ");

                if (scanner.hasNextInt()) {
                    data = new int[scanner.nextInt()];
                } else if (scanner.hasNextBoolean() ||
                        scanner.hasNextDouble() ||
                        scanner.hasNextBigDecimal() ||
                        scanner.hasNextBigInteger() ||
                        scanner.hasNextLong()) {
                    throw new IsNotIntegerException();      // Несоответствие числового типа данных
                } else {
                    throw new IsStringException();          // Ввод строки вместо числа
                }
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        // Получение элементов массива
        for (int i = 0; i < data.length; i++) {
            try {
                System.out.printf("[%d] = ", i);

                if (scanner.hasNextInt()) {
                    data[i] = scanner.nextInt();
                } else if (scanner.hasNextBoolean() ||
                        scanner.hasNextDouble() ||
                        scanner.hasNextBigDecimal() ||
                        scanner.hasNextBigInteger() ||
                        scanner.hasNextLong()) {
                    throw new IsNotIntegerException();
                } else {
                    throw new IsStringException();
                }
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
                i--;
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
                i--;
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }
        System.out.println();

        // Вычисление среднего
        for (int item : data) {
            if (item > 0) {
                sum += item;
                counter++;
            }
        }

        if (counter == 0) throw new HasNotPositiveIntegerException();
        else System.out.println("\n\rСреднее положительных чисел массива: " + sum / counter);
    }
}
```

Вывод первой реализации:

```text
Введите количество элементов: first
Введена строка вместо числа.

Введите количество элементов: 5

[0] = o
Введена строка вместо числа.

[0] = 123456789123456789123456789
Несоответствие введённого требуемому типу данных

[0] = 5
[1] = 7
[2] = -9
[3] = 2
[4] = 0

Среднее положительных чисел массива: 4
```

Код класса `Realization2`, с использованием собственных методов:

```java
import com.company.lw10.example2.HasNotPositiveIntegerException;
import com.company.lw10.example2.IsNotIntegerException;
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static int[] data = null;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        do {
            try {
                init();
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                get(i);
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
                i--;
            } catch (IsNotIntegerException exception) {
                System.err.println("Несоответствие введённого требуемому типу данных\n\r");
                i--;
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }

        try {
            System.out.println("\n\rСреднее положительных чисел массива: " + mean());
        } catch (HasNotPositiveIntegerException exception) {
            System.err.println("Среди введённых числе нет положительных.");
        }
    }

    /**
     * Инициализация массива. Получение количества элементов в массиве
     *
     * @throws IsNotIntegerException Введенное значение не являются целочисленным числом
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void init() throws IsNotIntegerException, IsStringException {
        System.out.print("Введите количество элементов: ");
        if (scanner.hasNextInt()) {
            data = new int[scanner.nextInt()];
        } else if (scanner.hasNextBoolean() ||
                scanner.hasNextDouble() ||
                scanner.hasNextBigDecimal() ||
                scanner.hasNextBigInteger() ||
                scanner.hasNextLong()) {
            throw new IsNotIntegerException();      // Несоответствие числового типа данных
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    /**
     * Получение значения массива с консоли
     *
     * @param index Индекс запрашиваемого элемента
     * @throws IsNotIntegerException Введенное значение не являются целочисленным числом
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void get(int index) throws IsNotIntegerException, IsStringException {
        System.out.printf("[%d] = ", index);

        if (scanner.hasNextInt()) {
            data[index] = scanner.nextInt();
        } else if (scanner.hasNextBoolean() ||
                scanner.hasNextDouble() ||
                scanner.hasNextBigDecimal() ||
                scanner.hasNextBigInteger() ||
                scanner.hasNextLong()) {
            throw new IsNotIntegerException();
        } else {
            throw new IsStringException();
        }
    }

    /**
     * Получение среднего положительных чисел массива
     *
     * @return Среднее положительных чисел массива
     * @throws HasNotPositiveIntegerException В массиве нет положительных целочисленных чисел
     */
    private static int mean() throws HasNotPositiveIntegerException {
        int sum = 0, counter = 0;

        for (int item : data) {
            if (item > 0) {
                sum += item;
                counter++;
            }
        }

        if (counter == 0) throw new HasNotPositiveIntegerException();
        else return sum / counter;
    }
}
```

Вывод второй реализации:

```text
Введите количество элементов: true
Несоответствие введённого требуемому типу данных

Введите количество элементов: 3
[0] = -85
[1] = 0
[2] = -25

Exception in thread "main" com.company.lw10.example2.HasNotPositiveIntegerException
	at com.company.lw10.example2.task1.Realization2.main(Realization1.java:81)

Process finished with exit code 1
```

#### Задание №2.2

В программе, где требуется из матрицы вывести столбец с номером, заданным с
клавиатуры, могут возникать ошибки в следующих случаях:

- Ввод строки вместо числа;
- Нет столбца с таким номером.

Код класса `Realization1`, без использования собственных методов:

```java
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        int[][] data = null;
        var scanner = new Scanner(System.in);

        // Получение количества строк и столбцов матрицы
        do {
            try {
                int columns, rows;

                System.out.print("Введите количество строк и столбцов: ");

                if (scanner.hasNextInt()) rows = scanner.nextInt();
                else throw new IsStringException();

                if (scanner.hasNextInt()) columns = scanner.nextInt();
                else throw new IsStringException();

                data = new int[rows][columns];
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);
        System.out.println();

        // Получение элементов матрицы
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try {
                    System.out.printf("[%d, %d] = ", i + 1, j + 1);

                    if (scanner.hasNextInt()) {
                        data[i][j] = scanner.nextInt();
                    } else {
                        throw new IsStringException();
                    }
                } catch (IsStringException exception) {
                    System.err.println("Введена строка вместо числа.\n\r");
                    j--;
                } finally {
                    scanner.nextLine();
                    Thread.sleep(50);
                }
            }
        }
        System.out.println();

        // Вывод выбранного столбца
        do {
            try {
                int padding = 0, index;

                // Получение номера выводимого столбца
                System.out.print("Введите номе столбца: ");
                if (!scanner.hasNextInt()) throw new IsStringException();
                else {
                    index = scanner.nextInt() - 1;
                    if (data[0].length <= index || index < 0) throw new IndexOutOfBoundsException();
                }

                // Вычисления отступа для выравнивания индекса строки
                for (int i = data.length; i > 0; ) {
                    i /= 10;
                    padding++;
                    System.out.print(" ");
                }
                System.out.println("  " + (index + 1));

                // Вывод столбца
                for (int i = 0; i < data.length; i++) {
                    System.out.printf("%" + padding + "d: [%4d]\n\r", i + 1, data[i][index]);
                }

                return;
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IndexOutOfBoundsException exception) {
                System.err.println("Нет столбца с таким номером.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (true);
    }
}
```

Вывод первой реализации:

```text
Введите количество строк и столбцов: 5 3

[1, 1] = one
Введена строка вместо числа.

[1, 1] = 1
[1, 2] = 8
[1, 3] = 145
[2, 1] = 62
[2, 2] = 4
[2, 3] = -8
[3, 1] = -10
[3, 2] = 82
[3, 3] = 4
[4, 1] = 2
[4, 2] = 35
[4, 3] = 85
[5, 1] = 25
[5, 2] = 42
[5, 3] = 63

Введите номе столбца: 3
   3
1: [ 145]
2: [  -8]
3: [   4]
4: [  85]
5: [  63]
```

Код класса `Realization2`, с использованием собственных методов:

```java
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static int[][] data = null;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        do {
            try {
                init();
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try {
                    get(i, j);
                } catch (IsStringException exception) {
                    System.err.println("Введена строка вместо числа.\n\r");
                    j--;
                } finally {
                    scanner.nextLine();
                    Thread.sleep(50);
                }
            }
        }
        System.out.println();

        do {
            try {
                printColumn();
                return;
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } catch (IndexOutOfBoundsException exception) {
                System.err.println("Нет столбца с таким номером.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (true);
    }

    /**
     * Инициализация матрицы. Получения количества строк и столбцов с консоли
     *
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void init() throws IsStringException {
        int columns, rows;

        System.out.print("Введите количество строк и столбцов: ");

        if (scanner.hasNextInt()) rows = scanner.nextInt();
        else throw new IsStringException();

        if (scanner.hasNextInt()) columns = scanner.nextInt();
        else throw new IsStringException();

        data = new int[rows][columns];
    }

    /**
     * Получение элемента матрицы
     *
     * @param rowIndex Индекс строки элемента
     * @param columnsIndex Индекс столбца элемента
     * @throws IsStringException Введена строка вместо целочисленного числа
     */
    private static void get(int rowIndex, int columnsIndex) throws IsStringException {
        System.out.printf("[%d, %d] = ", rowIndex + 1, columnsIndex + 1);

        if (scanner.hasNextInt()) {
            data[rowIndex][columnsIndex] = scanner.nextInt();
        } else throw new IsStringException();
    }

    /**
     * Вывод выбранного столбца
     *
     * @throws IsStringException Вместо индекса столбца введена строка
     * @throws IndexOutOfBoundsException Отсутствует столбец с таким индексом
     */
    private static void printColumn() throws IsStringException, IndexOutOfBoundsException {
        int padding = 0, index;

        // Получение номера выводимого столбца
        System.out.print("Введите номе столбца: ");
        if (!scanner.hasNextInt()) throw new IsStringException();
        else {
            index = scanner.nextInt() - 1;
            if (data[0].length <= index || index < 0) throw new IndexOutOfBoundsException();
        }

        // Вычисления отступа для выравнивания индекса строки
        for (int i = data.length; i > 0; ) {
            i /= 10;
            padding++;
            System.out.print(" ");
        }
        System.out.println("  " + (index + 1));

        // Вывод столбца
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%" + padding + "d: [%4d]\n\r", i + 1, data[i][index]);
        }
    }
}
```

Вывод второй реализации:

```text
Введите количество строк и столбцов: 2 2

[1, 1] = 52
[1, 2] = 52
[2, 1] = 02
[2, 2] = 65

Введите номе столбца: 100
Нет столбца с таким номером.

Введите номе столбца: 2
   2
1: [  52]
2: [  65]
```

#### Задание №2.3

В программе, вычисляющей сумму элементов типа `byte` одномерного массива,
вводимого с клавиатуры, могут возникать ошибки в следующих случаях:

- Ввод строки вместо числа;
- Ввод или вычисление значения за границами диапазона типа.

Код класса `Realization1`, без использования собственных методов:

```java
import com.company.lw10.example2.IsStringException;

import java.util.Scanner;

/**
 * Реализация без использования собственных методов.
 */
public class Realization1 {
    public static void main(String[] args) throws InterruptedException {
        byte[] data = null;
        var scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Введите количество элементов: ");
                if (scanner.hasNextInt()) {
                    data = new byte[scanner.nextInt()];
                } else {
                    throw new IsStringException();          // Ввод строки вместо числа
                }
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                System.out.printf("[%d] = ", i);
                if (scanner.hasNextByte()) {
                    data[i] = scanner.nextByte();
                } else if (scanner.hasNextBigInteger() ||
                        scanner.hasNextInt() ||
                        scanner.hasNextLong()) {
                    throw new ArithmeticException();        // Переполнение переменной
                } else {
                    throw new IsStringException();          // Ввод строки вместо числа
                }
            } catch (ArithmeticException exception) {
                System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }

        try {
            byte result = 0;

            for (byte item : data) {
                if (result + item > Byte.MAX_VALUE || result + item < Byte.MIN_VALUE) throw new ArithmeticException();
                else result += item;
            }
            
            System.out.println("Сумма: " + result);
        } catch (ArithmeticException exception) {
            System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
        }
    }
}
```

Вывод первой реализации:

```text
Введите количество элементов: 3
[0] = 125
[1] = 124
[2] = 100
Вводимое значение выходит за границы переменой типа byte.
```

Код класса `Realization2`, с использованием собственных методов:

```java
import java.util.Scanner;

/**
 * Реализация с использованием собственных методов.
 */
public class Realization2 {
    private static byte[] data = null;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        do {
            try {
                init();
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        } while (data == null);

        for (int i = 0; i < data.length; i++) {
            try {
                get(i);
            } catch (ArithmeticException exception) {
                System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
            } catch (IsStringException exception) {
                System.err.println("Введена строка вместо числа.\n\r");
            } finally {
                scanner.nextLine();
                Thread.sleep(50);
            }
        }

        try {
            System.out.println("Сумма: " + sum());
        } catch (ArithmeticException exception) {
            System.err.println("Вводимое значение выходит за границы переменой типа byte.\n\r");
        }
    }

    private static void init() throws ArithmeticException, IsStringException {
        System.out.print("Введите количество элементов: ");
        if (scanner.hasNextInt()) {
            data = new byte[scanner.nextInt()];
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    private static void get(int index) throws ArithmeticException, IsStringException {
        System.out.printf("[%d] = ", index);
        if (scanner.hasNextByte()) {
            data[index] = scanner.nextByte();
        } else if (scanner.hasNextBigInteger() ||
                scanner.hasNextInt() ||
                scanner.hasNextLong()) {
            throw new ArithmeticException();        // Переполнение переменной
        } else {
            throw new IsStringException();          // Ввод строки вместо числа
        }
    }

    private static int sum() throws ArithmeticException {
        byte result = 0;

        for (byte item : data) {
            if (result + item > Byte.MAX_VALUE || result + item < Byte.MIN_VALUE) throw new ArithmeticException();
            else result += item;
        }
        return result;
    }
}
```

Вывод второй реализации:

```text
Введите количество элементов: 5
[0] = ывап
Введена строка вместо числа.

[1] = 15455
Вводимое значение выходит за границы переменой типа byte.

[2] = 2
[3] = 82
[4] = -6
Сумма: 78
```

## Вывод

В ходе лабораторной работы были получены навыки работы с исключениями в Java.
Были разработаны программы реализующие обработку исключений.

В рамках лабораторной работы №10 было решено 4 задач на программирование,
для получения навыков работы с исключениями в Java. Листинг кода написанных
программ был представлен в разделе *Ход работы*. В результате лабораторной
работы поставленная цель была выполнена, а поставленные задачи достигнуты.