# Отчёт по лабораторной работе №5 «Введение в классы, часть 1»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Введение в работу с классами Java.

## Описание задачи
- Изучение справочного материала;
- Изучение синтаксиса описания класса и его элементов;
- Решение задач по программированию, на следующие темы:
  - классы,
  - поля,
  - конструкторы,
  - сеттеры и геттеры,
  - методы экземпляра класса,
  - модификаторы доступа;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 6 задач по программированию на Java.
Листинг кода представлен ниже.

#### Задание №1
Напишите программу с классом, в котором есть закрытое символьное поле
и три открытых метода. Один из методов позволяет присвоить значение полю.
Ещё один метод при вызове возвращает результатом код символа. Третий
метод позволяет вывести в консольное окно символ (значение поля) и его код.

Код класса `CharField`:

```java
import java.util.Objects;

class CharField {
  /** Закрытое символьное поле. */
  private char value;

  /**
   * Конструктор для создания новых экземпляров класса, хранящего
   * одно символьное поле.
   *
   * @param value Символ для инициализации поля.
   */
  public CharField(char value) {
    this.value = value;
  }

  /**
   * Получение значения, хранящегося в закрытом поле.
   *
   * @return Номер символа поля.
   */
  public int getValue() {
    return value;
  }

  /**
   * Изменение значения закрытого поля.
   *
   * @param value Новое значение символьного поля.
   */
  public void setValue(char value) {
    this.value = value;
  }

  /**
   * Вывод в консоль символа и его кода.
   */
  public void printField() {
    System.out.print(this);
  }

  @Override
  public String toString() {
    return String.format("{%s = 0x%h}", value, (int) value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CharField field = (CharField) o;
    return value == field.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final char CHAR_1 = 'A', CHAR_2 = 'Q';

        // Инициализация с помощью конструктора
        var field = new CharField(CHAR_1);

        // Получение значения закрытого поля, с помощью геттера
        System.out.println("Получение значения поля: " + field.getValue());

        // Изменение значения закрытого поля с помощью сеттера
        field.setValue(CHAR_2);

        // Вывод значения в консоль с помощью метода экземпляра класса
        System.out.print("\n\rНовое значение поля: ");
        field.printField();
        System.out.println();
    }
}
```

Вывод программы:
```text
Получение значения поля: 65

Новое значение поля: {Q = 0x51}
```

#### Задание №2
Напишите программу с классом, у которого есть два символьных поля и
метод. Он возвращает результат, и у него нет аргументов. При вызове метод
выводит в консольное окно все символы из кодовой таблицы, которые
находятся «между» символами, являющимися значениями полей объекта (из
которого вызывается метод). Например, если полям объекта присвоены
значения ‘A’ и ‘D’, то при вызове метода в консольное окно должны
выводиться все символы от ‘A’ до ‘D’ включительно.

Код класса `CharRange`:
```java
import java.util.Objects;

class CharRange {
    private char from, to;

    public CharRange(char from, char to) {
        this.from = from;
        this.to = to;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    /**
     * Вывод последовательности символов, согласно указанному
     * диапазону.
     *
     * @return Выводимый массив символов.
     */
    public char[] printSequence() {
        String array = "";
        String result = "[ ";

        // Вывод может осуществляться как от 'A' до 'Z', так и в обратную сторону
        if (from <= to) {
            for (int i = from; i <= to; i++) {
                result += String.format("'%s'; ", (char) i);
                array += (char) i;
            }
        } else {
            for (int i = from; i >= to; i--) {
                result += String.format("'%s'; ", (char) i);
                array += (char) i;
            }
        }
        result += "]";

        System.out.println(result);
        return array.toCharArray();
    }

    @Override
    public String toString() {
        return String.format("['%%', '%%']");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharRange range = (CharRange) o;
        return from == range.from && to == range.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final char FROM = 'Z', TO = 'A';
        var range = new CharRange(FROM, TO);

        range.printSequence();
    }
}
```
Вывод программы:
```text
[ 'Z'; 'Y'; 'X'; 'W'; 'V'; 'U'; 'T'; 'S'; 'R'; 'Q'; 'P'; 'O'; 'N'; 'M'; 'L'; 'K'; 'J'; 'I'; 'H'; 'G'; 'F'; 'E'; 'D'; 'C'; 'B'; 'A'; ]
```

#### Задание №3
Напишите программу с классом, у которого есть два целочисленных поля.
В классе должны быть описаны конструкторы, позволяющие создавать
объекты без передачи аргументов, с передачей одного аргумента и с передачей
двух аргументов.

Код класса `IntCharFields`:
```java
import java.util.Objects;

class TwoIntFields {
    private Integer a, b;

    public TwoIntFields() {
    }

    public TwoIntFields(int a) {
        this.a = a;
    }

    public TwoIntFields(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("(%s; %s)", (a != null) ? a : "NULL", (b != null) ? b : "NULL");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoIntFields that = (TwoIntFields) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
```

Код класса `Main`:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        TwoIntFields field;

        // Инициализация конструктором по умолчанию.
        field = new TwoIntFields();
        System.out.println(field);

        // Инициализация конструктором с одним параметром.
        System.out.print("\n\rВведите целочисленное число: ");
        field = new TwoIntFields(input.nextInt());
        System.out.println(field);

        // Инициализация конструктором с двумя параметрами
        System.out.print("\n\rВведите два целочисленных числа: ");
        field = new TwoIntFields(input.nextInt(), input.nextInt());
        System.out.println(field);
    }
}
```

Вывод программы:
```text
(NULL; NULL)

Введите целочисленное число: 5
(5; NULL)

Введите два целочисленных числа: 5 10
(5; 10)
```

#### Задание №4
Напишите программу с классом, у которого есть символьное и
целочисленное поле. В классе должны быть описаны версии конструктора с
двумя аргументами (целое число и символ – определяют значения полей), а
также с одним аргументом типа double. В последнем случае действительная
часть аргумента определяет код символа (значение символьного поля), а
дробная часть (с учётом десятых и сотых) определяет значение
целочисленного поля. Например, если аргументом передается число 65.1267,
то значением символьного поля будет символ ‘A’ с годом 65, а целочисленное
поле получит значение 12 (в дробной части учитываются только десятые и
сотые).

Код класса `IntCharFields`:
```java
import java.util.Objects;

public class IntCharFields {
    private int number;
    private char symbol;

    public IntCharFields(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public IntCharFields(double data) {
        number = (int) data;
        symbol = (char) (int) (data % 1 * 100);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("{'%s', %d}", symbol, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntCharFields that = (IntCharFields) o;
        return number == that.number && symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, symbol);
    }
}
```

Код класса `Main`:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        IntCharFields x;

        // Инициализация объекта с помощью конструктора принимающего int и char
        System.out.print("Введите число и символ: ");
        x = new IntCharFields(input.nextInt(), input.next().charAt(0));
        System.out.println(x);

        // Инициализация объекта с помощью конструктора принимающего double
        System.out.print("\n\rВведите вещественное число: ");
        x = new IntCharFields(input.nextDouble());
        System.out.println(x);
    }
}
```

Вывод программы:
```text
Введите число и символ: 157 B
{'B', 157}

Введите вещественное число: 25,70
{'E', 25}
```

#### Задание №5
Напишите программу с классом, у которого есть закрытое целочисленное
поле. Значение полю присваивается с помощью открытого метода. Методу
аргументом может передаваться целое число, а также метод может вызываться
без аргументов. Если методы вызывается без аргументов, то поле получает
нулевое значение. Если метод вызывается с целочисленным аргументом, то
это значение присваивается полю. Однако если переданное аргументом
методу значение превышает 100, то значением полю присваивается число 100.
Предусмотрите в классе конструктор, который работает по тому же принципу
что и метод для присваивания значения полю. Также в классе должен быть
метод, позволяющий проверить значение поля.

Код класса `IntField`:
```java
import java.util.Objects;

public class IntField {
    private int value;
    private boolean isOverflow = false;

    public IntField() {
        value = 0;
    }

    public IntField(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > 100) {
            this.value = 100;
            isOverflow = true;
        } else {
            this.value = value;
            isOverflow = false;
        }
    }

    public boolean isOverflow() {
        return isOverflow;
    }

    @Override
    public String toString() {
        return (isOverflow) ? "+" : "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntField intField = (IntField) o;
        return value == intField.value && isOverflow == intField.isOverflow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isOverflow);
    }
}
```

Код класса `Main`:
```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    var intField = new IntField();
    int value;

    // Вывод значения, после инициализации конструктором по умолчанию.
    System.out.printf("Инициализация конструктором по умолчанию: %s\n\r\n\r", intField);

    // Инициализация конструктором с параметром.
    System.out.print("Введите значение: ");
    intField = new IntField(input.nextInt());
    System.out.printf("Инициализация с параметром: %s\n\r\n\r", intField);

    // Изменение значения, через метод.
    System.out.print("Введите значение: ");
    intField.setValue(input.nextInt());
    System.out.printf("После изменения поле стало хранить в себе значение %d. %s\n\r",
            intField.getValue(), (intField.isOverflow() ? "Что не равно исходному значению.": ""));
  }
}
```

Вывод программы:
```text
Инициализация конструктором по умолчанию: 0

Введите значение: 68
Инициализация с параметром: 68

Введите значение: 150
После изменения поле стало хранить в себе значение 100. Что не равно исходному значению.
```

#### Задание №6
Напишите программу с классом, в котором есть два закрытых
целочисленных поля (назовём их `max` и `min`). Значение поля `max` не может
быть меньше значения поля `min`. Значения полям присваиваются с помощью
открытого метода. Метод может вызываться с одним или двумя
целочисленными аргументами. При вызове метода значения полям
присваиваются так: сравниваются текущие значения полей и значения
аргументов, переданных методу. Самое большое из значений присваивается
полю `max`, а самое маленькое из значений присваивается полю `min`.
Предусмотрите конструктор, который работает по тому же принципу, что и
метод для присваивания значений полям. В классе также должен быть метод,
отображающий в консольном окне значения полей объекта.

Код класса `IntRange`:
```java
import java.util.Objects;

public class IntRange {
    private int min, max;

    public IntRange(int a, int b) {
        change(a, b);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void change(int a, int b) {
        if (a <= b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
    }

    public void print() {
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", min, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntRange intRange = (IntRange) o;
        return min == intRange.min && max == intRange.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
```

Код класса `Main`:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        IntRange range;

        // Инициализация объекта
        System.out.print("Введите два числа: ");
        range = new IntRange(input.nextInt(), input.nextInt());

        // Вывод значений в консоль
        range.print();
    }
}
```

Вывод программы:
```text
Введите два числа: 359 65
Минимальное значение: 65
Максимальное значение: 359
```

## Вывод
В ходе лабораторной работы были получены навыки работы с классами в
Java, а также с его элементами.

В рамках лабораторной работы №5 было решено 6 задач на программирование, 
для получения навыков работы с классами в Java. Листинг кода написанных 
программ был представлен в разделе *Ход работы*. В результате лабораторной 
работы поставленная цель была выполнена, а поставленные задачи достигнуты.