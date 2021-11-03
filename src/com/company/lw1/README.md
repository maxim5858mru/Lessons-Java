# Отчёт по лабораторной работе №1 «Знакомство с языком программирования Java»

***УрФУ ИРИТ-РФТ  
Группа РИЗ-200016у  
Кулаков Максим Иванович***

## Цель работы
Получение представления о написании программы на языке
программирования Java с использованием командной строки.

## Описание задачи
- Изучение справочных материалов;
- Изучение примеров;
- Решение задач на программирование, которые затрагивают такие темы как:
  - ввод/вывод с консоли,
  - переменные, 
  - целочисленные и вещественные типы данных,
  - арифметические операторы,
  - условный оператор `if`,
  - методы;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было рассмотрено 7 примеров из справочного 
материала, а также было решено 13 задач по программированию.
Ниже приведён листинг примеров и решённых задач.

### Листинг программ из примеров

#### Пример №1 Шаблон консольного приложения на Java
```java
class example1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

#### Пример №2 Работа с переменными
```java
class example2 {
    public static void main(String[] args) {
        int num; // в этой строке кода объявляется

        // переменная с именем num
        num = 100; // в этой строке кода переменной num

        // присваивается значение 100
        System.out.println("num: " + num);
        num = num * 2;
        System.out.print("Znachenie num * 2 равно ");
        System.out.println(num);
    }
}
```

#### Пример №3 Использование условного оператора `if`
```java
class example3 {
    public static void main(String args[]) {
        int S, D;

        S = 10;
        D = 20;

        if (S < D) System.out.println("S < D");
        S = S * 2;

        if (S == D) System.out.println("S = D");
        S = S * D;

        if (S > D) System.out.println("S > D");
    }
}
```

#### Пример №4 Ввод данных с консоли
```java
import java.util.Scanner;

class example4 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        System.out.print("Input a number:");
        int num = InCMD.nextInt();

        System.out.printf("Your number: %d \n", num);
        InCMD.close();
    }

}
```

#### Пример №5 Ввод информации о человеке
```java
import java.util.Scanner;

public class example5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input name: ");
        String name = in.nextLine();
        
        System.out.print("Input age: ");
        int age = in.nextInt();
        
        System.out.print("Input height: ");
        float height = in.nextFloat();
        
        System.out.printf("Name: %s Age: %d Height: %.2f \n", name, age, height);
        in.close();
    }
}
```

#### Пример №6 Расчёт гипотенузы
```java
class example6 {
    static double a = 10.0, b = 4.0, c;
    
    public static double hyp() {
        return c = Math.sqrt(a*a + b*b);
    }
    
    public static void main(String[] args) {
        System.out.println("katet а=" + a);
        System.out.println("katet b=" + b);
        System.out.println("hypotenuse с=" + hyp());
    }
}
```

#### Пример №7 Расчёт радиуса круга
```java
import java.util.Scanner;

public class example7 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
 
        System.out.print("Radius kruga: ");
        int radius = in.nextInt();
        long area = Math.round(Math.PI * Math.pow(radius, 2));
        System.out.printf("S kruga s R %d = %d \n", radius, area);
    }
}
```

### Листинг программ написанных в рамках самостоятельной работы

#### Задание №1
Напишите программу, в которой Пользователь вводит сначала фамилию,
затем имя, затем отчество. После ввода программа выводит 
сообщение **«Hallo <ФАМИЛИЯ, ИМЯ, ОТЧЕСТВО>»**. 

```java
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String first_name, last_name, middle_name;

        System.out.print("Введите последовательно ФИО: ");
        last_name = input.next();
        first_name = input.next();
        middle_name = input.next();

        System.out.printf("Hello %s %s %s\n\r", last_name, first_name, middle_name);
    }
}
```

Вывод программы:
```text
Введите последовательно ФИО: Кулаков Максим Иванович
Hello Кулаков Максим Иванович
```

#### Задание №2
Напишите программу, в которой Пользователь вводит имя и возраст.
Программа отображает сообщение об имени и возрасте пользователя.

```java
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int age;
        String name;

        System.out.print("Введите ваше имя и возраст: ");
        name = input.next();
        age = input.nextInt();

        System.out.println("Итого вы ввели: ");
        System.out.println("\tВаше имя: " + name);
        System.out.println("\tВаш возраст: " + age);
    }
}
```

Вывод программы:
```text
Введите ваше имя и возраст: Максим 21
Итого вы ввели: 
	Ваше имя: Максим
	Ваш возраст: 21
```

#### Задание №3
Напишите программу, в которой Пользователь последовательно вводит
название текущего дня недели, название месяца и дату (номер дня 
в месяце). Программа выводит сообщение о сегодняшней дате (день
недели, дата, месяц).

```java
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        String day_type, month;
        int day_number;
        var input = new Scanner(System.in);

        System.out.print("Введите последовательно день недели, месяц, число: ");
        day_type = input.next();
        month = input.next();
        day_number = input.nextInt();

        System.out.println("\n\rИтого, вы ввели:");
        System.out.println("\tДень недели: " + day_type);
        System.out.println("\tМесяц: " + month);
        System.out.println("\tЧисло: " + day_number);
    }
}
```

Вывод программы:
```text
Введите последовательно день недели, месяц, число: среда ноябрь 03

Итого, вы ввели:
	День недели: среда
	Месяц: ноябрь
	Число: 3
```

#### Задание №4
Напишите программу, в которой пользователю предлагается ввести
название месяца и количество дней в этом месяце. Программа выводит
сообщение о том, что соответствующий месяц содержит указанное количество
дней.

```java
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        String month;
        int days;
        Scanner input = new Scanner(System.in);

        System.out.print("Введите месяц и количество дней в нём: ");
        month = input.next();
        days = input.nextInt();

        System.out.printf("В %s %d дней.\n\r", month, days);
    }
}
```

Вывод программы:
```text
Введите месяц и количество дней в нём: ноябрь 30
В ноябрь 30 дней.
```

#### Задание №5
Напишите программу, в которой по году рождения определяется возраст
пользователя.

```java
import java.util.Calendar;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int year, year_now = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Введите год вашего рождения: ");
        year = input.nextInt();

        System.out.println("Вам сейчас " + (year_now - year)+ ".");
    }
}
```

Вывод программы:
```text
Введите год вашего рождения: 2000
Вам сейчас 21.
```

#### Задание №6
Напишите программу, в которой Пользователь вводит имя и год рождения,
в программе отображает сообщение содержащее имя пользователя и его
возраст.

```java
import java.util.Calendar;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int year, now_year = Calendar.getInstance().get(Calendar.YEAR);
        String name;

        System.out.print("Введите ваше имя и год рождения: ");
        name = input.next();
        year = input.nextInt();

        System.out.println("Ваше имя: " + name);
        System.out.println("Вам сейчас : " + (now_year - year));
    }
}
```

Вывод программы:
```text
Введите ваше имя и год рождения: Максим 2000
Ваше имя: Максим
Вам сейчас : 21
```

#### Задание №7
Напишите программу, в которой по возрасту определяется год рождения.

```java
import java.util.Calendar;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int age, year = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Сколько вам сейчас лет? ");
        age = input.nextInt();

        System.out.println("Вы родились в " + (year - age) + "+-1 году.");
    }
}
```

Вывод программы:
```text
Сколько вам сейчас лет? 21
Вы родились в 2000+-1 году.
```

#### Задание №8
Напишите программу для вычисления суммы двух чисел. Оба числа
вводятся пользователем. Для вычисления суммы используйте оператор `+`.

```java
import java.math.BigDecimal;
import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        BigDecimal x, y, result;
        var input = new Scanner(System.in);

        System.out.print("Введите x: ");
        x = new BigDecimal(input.next());

        System.out.print("Введите y: ");
        y = new BigDecimal(input.next());

        result = x.add(y);
        System.out.printf("Сумма %s и %s = %s\n\r", x, y, result);
    }
}
```

Вывод программы:
```text
Введите x: 5.356578684618468768
Введите y: 845.246546432465768327
Сумма 5.356578684618468768 и 845.246546432465768327 = 850.603125117084237095
```

#### Задание №9
Напишите программу, в которой пользователь вводит число, а программой
отображается последовательность из четырех чисел: число, на единицу
меньше введённого, введенное число и число, на единицу больше введенного.
Четвертое число должно быть квадратом суммы первых трёх чисел.

```java
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int number;

        System.out.print("Введите любое число: ");
        number = input.nextInt();

        System.out.printf("%d %d %d %d\n\r", number - 1, number, number + 1, number * number);
    }
}
```

Вывод программы:
```text
Введите любое число: 85
84 85 86 7225
```

#### Задание №10
Напишите программу, в которой Пользователь вводит два числа, а
программой вычисляется и отображается сумма и разность этих чисел.

```java
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int x, y;

        System.out.print("Введите x: ");
        x = input.nextInt();

        System.out.print("Введите y: ");
        y = input.nextInt();

        System.out.printf("Сумма %d и %d: %d\n\r", x, y, x + y);
        System.out.printf("Разность %d и %d: %d\n\r", x, y, x - y);
    }
}
```

Вывод программы:
```text
Введите x: 67
Введите y: 24
Сумма 67 и 24: 91
Разность 67 и 24: 43
```

#### Задание №11
Добавьте в пример расчёта гипотенузы (см. раздел 2) метод, вычисляющий a^b. 
Используйте для этого функции расчёта натурального логарифма и
экспоненты `(y=exp(b*log(a));`

```java
public class Example11 {
    static double a = 10.0, b = 4.0, c;

    public static void main(String[] args) {
        System.out.println("Катет a = " + a);
        System.out.println("Катет b = " + b);
        System.out.println("Гипотенуза c = " + hyp());
    }

    public static double hyp() {
        return c = Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double a, double b) {
        return Math.exp(b * Math.log(a));
    }
}
```

Вывод программы:
```text
Катет a = 10.0
Катет b = 4.0
Гипотенуза c = 10.77032961426901
```

#### Задание №12
Используйте новый метод для расчёта гипотенузы. Сделайте вариант
метода `hyp()` с параметрами.

```java
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        double a, b;
        var input = new Scanner(System.in);

        System.out.print("Катет a = ");
        a = input.nextDouble();

        System.out.print("Катет b = ");
        b = input.nextDouble();

        System.out.println("Гипотенуза c = " + hyp(a, b));
    }

    public static double hyp(double a, double b) {
        return Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double a, double b) {
        return Math.exp(b * Math.log(a));
    }
}
```

Вывод программы:
```text
Катет a = 457,58
Катет b = 647,2
Гипотенуза c = 792.6205248414905
```

#### Задание №13
Сделайте вариант вычисление a^b с помощью встроенного метода (искать в
`Math`).

```java
import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        double a, b;
        var input = new Scanner(System.in);

        System.out.print("Катет a = ");
        a = input.nextDouble();

        System.out.print("Катет b = ");
        b = input.nextDouble();

        System.out.println("Гипотенуза c = " + hyp(a, b));
    }

    public static double hyp(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
```

Вывод программы:
```text
Катет a = 57,4
Катет b = 14,9
Гипотенуза c = 59.30236082990289
```

## Вывод
В рамках первой лабораторной работы по изучению языка
программирования Java были рассмотренные такие темы как:
структура программы, I/O с консоли, переменные, целочисленные 
и вещественные типы данных, арифметические операции,
условный оператор и создание простых методов с параметрами.

Тем самым, как минимум было рассмотрено 7 примеров программ
(в рамках изучения справочного материала). А также по выше
указанным темам было решено 13 задач. Листинг кода примеров и 
написанных программ указан в разделе **Ход работы**. Цель 
достигнута, а поставленные задачи выполнены.