# Отчёт по лабораторной работе №6 «Введение в классы, часть 2»

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
- Решение задач по программированию на темы:
  - Классы;
  - Статические методы;
  - Параметры переменной длины;
  - Рекурсивные функции.
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 10 задач по программированию. Листинг кода
представлен ниже.

#### Задание №1
Напишите программу с классом, в котором есть два ноля: символьное и текстовое.
В классе должен быть перегруженный метод для присваивания значений полям. Если метод
вызывается с символьным аргументом, то соответствующее значение присваивается
символьному полю. Если метод вызывается с текстовым аргументом, то он определяет
значение текстового ноля. Методу аргументом также может передаваться символьный
массив. Если массив состоит из одного элемента, то он определяет значение символьного
поля. В противном случае (если в массиве больше одного элемента) из символов массива
формируется текстовая строка и присваивается значением текстовому полю.

Код класса `CharStringField`:
```java
import java.util.Objects;

class CharStringField {
    private String text;
    private Character symbol;

    public CharStringField(char symbol) {
        set(symbol);
    }

    public CharStringField(String text) {
        set(text);
    }

    public CharStringField(char symbol, String text) {
        this.symbol = symbol;
        this.text = text;
    }

    public CharStringField(char[] array) {
        set(array);
    }

    /**
     * Метод для присваивания значения символьному полю.
     *
     * @param symbol Присваиваемый полю символ.
     */
    public void set(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Метод для присваивания значения строковому полю.
     *
     * @param text Присваиваемая полю строка.
     */
    public void set(String text) {
        this.text = text;
    }

    /**
     * Метод присваивающий значение полю по массиву.
     * Если массив имеет только 1 элемент, то он будет
     * присвоен символьному полю. В случае, если массив
     * имеет более одного символа, значение присваивается
     * текстовому полю.
     *
     * @param array Массив с символом(ми).
     */
    public void set(char[] array) {
        if (array.length == 0) return;
        else if (array.length == 1) set(array[0]);
        else set(new String(array));
    }

    public char getSymbol() {
        return symbol;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("{'%s'; \"%s\"}",
                (symbol == null) ? "NULL" : symbol,
                (text == null) ? "NULL" : text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharStringField that = (CharStringField) o;
        return Objects.equals(text, that.text) && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, symbol);
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final char[] ARRAY_1 = new char[]{'H', 'i', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        final char[] ARRAY_2 = new char[]{'H'};
        final char SYMBOL = 'Z';
        final String TEXT = "Hello World!";
        CharStringField object;

        // Инициализация по символьному массиву с length > 1
        object = new CharStringField(ARRAY_1);
        System.out.println("Инициализация по массиву " +
                "{'H', 'i', ' ', 'W', 'o', 'r', 'l', 'd', '!'}: " + object);

        // Вызов метода изменения поля по массиву с length == 1
        object.set(ARRAY_2);
        System.out.println("Изменение значения поля по массиву {'H'}:" + object);

        // Вызов метода изменения поля по символу
        object.set(SYMBOL);
        System.out.println("Изменение значения поля символа на 'Z': " + object);

        // Вызов метода изменения поля по строке
        object.set(TEXT);
        System.out.println("Изменение значения текстового поля: " + object);
    }
}
```

Вывод программы:
```text
Инициализация по массиву {'H', 'i', ' ', 'W', 'o', 'r', 'l', 'd', '!'}: {'NULL'; "Hi World!"}
Изменение значения поля по массиву {'H'}:{'H'; "Hi World!"}
Изменение значения поля символа на 'Z': {'Z'; "Hi World!"}
Изменение значения текстового поля: {'Z'; "Hello World!"}
```

#### Задание №2
Напишите программу с классом, в котором есть закрытое статическое
целочисленное поле с начальным нулевым значением. В классе должен быть описан
статический метод, при вызове которого отображается текущее значение статического
поля, после чего значение поля увеличивается на единицу.

Код класса `Counter`:
```java
/* Т.к. класс содержит только статические методы и не подразумевает
создание объектов, используется ключевое слово final и единственный 
private конструктор*/
final class Counter {
    private static int counter = 0;
    
    private Counter() {}
    
    /**
     * Вывод значения с последующим инкриминированием.
     */
    public static void printCounter() {
      System.out.println("Счётчик сейчас равен " + counter);
      counter++;
    }
}

```

Код класса `Main`:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String answer;

        /* Т.к. инкриминирование счётчика происходит только при выводе
        вывод с запросом о продолжении происходит в цикле.*/
        do {
            Counter.printCounter();
            System.out.print("Вывести значение счётчика? (yes/no): ");
            answer = input.nextLine();

            System.out.println();
        } while (answer.equals("yes") || answer.equals("y"));
    }
}
```

Вывод программы:
```text
Счётчик сейчас равен 0
Вывести значение счётчика? (yes/no): y

Счётчик сейчас равен 1
Вывести значение счётчика? (yes/no): yes

Счётчик сейчас равен 2
Вывести значение счётчика? (yes/no): yes

Счётчик сейчас равен 3
Вывести значение счётчика? (yes/no): no
```

#### Задание №3
Напишите программу с классом, в котором есть статические методы, которым
можно передавать произвольное количество целочисленных аргументов (или
целочисленный массив). Методы, на основании переданных аргументов или массива,
позволяют вычислить: наибольшее значение, наименьшее значение, а также среднее
значение из набора чисел.

Код класса `SequenceAnalysis`:
```java
import java.util.Arrays;

final class SequenceAnalysis {
    private SequenceAnalysis() {}
    
    /**
     * Получение минимального значения из последовательности,
     * без учёта дубликатов.
     *
     * @param data Целочисленная последовательность. Минимальное
     *             количество значений в последовательности 1.
     * @return Минимальное значение.
     */
    public static int findMin(int... data) {
        /* Вызов исключения IllegalArgumentException, если в
        последовательности вообще нет значений. */
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMin() необходим хотя бы одно значение.");

        data = processing(data);

        return data[0];
    }

    /**
     * Получение максимального значения из последовательности.
     */
    public static int findMax(int... data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMax() необходим хотя бы одно значение.");

        data = processing(data);

        return data[data.length - 1];
    }

    /**
     * Получение среднего значения в последовательности.
     */
    public static int findMean(int... data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Для метода findMean() необходим хотя бы одно значение.");

        data = processing(data);

        /* Если окончательная длина последовательности нечётная, то из
        двух средних значений возвращается, то значение, которое ближе к
        максимальному */
        return data[data.length / 2];
    }

    /**
     * Предварительная обработка последовательности, перед её анализом.
     *
     * @param data Исходная последовательность чисел.
     * @return Последовательность отсортированная по возрастанию и без дубликатов.
     */
    private static int[] processing(int[] data) {
        int[] result;
        int counter = data.length;

        // Вычисление размера массива без дубликатов
        Arrays.sort(data);
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] == data[i]) counter--;
        }

        // Заполнение окончательного массива
        result = new int[counter];
        result[0] = data[0];
        for (int i = 1, j = 1; i < data.length; i++) {
            if (data[i - 1] != data[i]) {
                result[j] = data[i];
                j++;
            }
        }

        return result;
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        /* Отсортированный массив: {-1, 0, 0, 0, 0, 1, 7, 8, 14, 20, 67, 86}
        Следовательно min = -1; mean = 8; max = 86 */
        final int[] ARRAY = new int[] {20, 8, 1, 86, 14, 67, 0, 7, 0, 0, 0, -1};

        System.out.println("Минимальное значение: " + SequenceAnalysis.findMin(ARRAY));
        System.out.println("Среднее значение: " + SequenceAnalysis.findMean(ARRAY));
        System.out.println("Максимальное значение: " + SequenceAnalysis.findMax(ARRAY));
    }
}
```

Вывод программы:
```text
Минимальное значение: -1
Среднее значение: 8
Максимальное значение: 86
```

#### Задание №4
Напишите программу, в которой описан статический метод для вычисления
двойного факториала числа, переданного аргументом методу. По определению, двойной
факториал числа n (обозначается как n!!) — это произведение через одно всех чисел, не
больших числа n. То есть n!! = п * (n - 2) * (п - 4) * ... (последний множитель равен 1 для
нечетного n и равен 2 для чётного n). Например, 6!! = 6 * 4 * 2 = 48 и 5!! = 5 * 3 * 1 = 15.
Предложите версию метода без рекурсии и с рекурсией.

Код класса `DoubleFactorial`:
```java
final class DoubleFactorial {
    private DoubleFactorial () {}
    
    public static int getValue(int number, boolean useRecursion) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (useRecursion) return recursiveMethod(number);
        else return usualMethod(number);
    }

    /**
     * Рекурсивная реализация метода вычисления двойного факториала.
     * Рекурсия вызывается до тех пор, пока не дойдёт до числа 
     * равного или меньше 2.
     */
    private static int recursiveMethod(int number) {
        if (number <= 2) return number;
        else return number * recursiveMethod(number - 2);
    }

    /**
     * Не рекурсивный способ, с помощью цикла.
     */
    private static int usualMethod(int number) {
        int result = (number % 2 == 1) ? 1: 2;

        while (number > 2) {
            result *= number;
            number -= 2;
        }

        return result;
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final int[] FOR_USUAL_METHOD = new int[]{1, 2, 5, 7, 8};
        final int[] FOR_RECURSIVE_METHOD = new int[]{3, 7, 8, 10, 12};

        System.out.println("Вычисление двойного факториала обычным способом:");
        for (var number : FOR_USUAL_METHOD) {
            System.out.println(number + "!! = " +
                    DoubleFactorial.getValue(number, false));
        }

        System.out.println("\n\rВычисление двойного факториала рекурсивным способом:");
        for (var number : FOR_RECURSIVE_METHOD) {
            System.out.println(number + "!! = " +
                    DoubleFactorial.getValue(number, true));
        }
    }
}
```

Вывод программы:
```text
Вычисление двойного факториала обычным способом:
1!! = 1
2!! = 2
5!! = 15
7!! = 105
8!! = 384

Вычисление двойного факториала рекурсивным способом:
3!! = 3
7!! = 105
8!! = 384
10!! = 3840
12!! = 46080
```

Вариант класса `DoubleFactorial` использующего только рекурсивный способ:
```java
final class DoubleFactorial {
    private DoubleFactorial() {}
    
    public static int getValue(int number) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (number <= 2) return number;
        else return number * getValue(number - 2);
    }
}
```

Вариант класса `DoubleFactorial` использующего только нерекурсивный способ:
```java
final class DoubleFactorial {
    private DoubleFactorial() {}
  
    public static int getValue(int number) {
        int result = (number % 2 == 1) ? 1: 2;

        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");
        while (number > 2) {
            result *= number;
            number -= 2;
        }

      return result;
    }
}
```

#### Задание №5
Напишите программу со статическим методом, которым вычисляется сумма
квадратов натуральных чисел 1^2 + 2^2 + 3^2 + ... + n^2. Число n передается аргументом методу.
Предложите версию метода с рекурсией и без рекурсии. Для проверки результата можно
использовать формулу 1^2 + 2^2 + 3^2 + … + n^2 = (n+1) (2n + 1) / 6

Код класса `SquareNumber`:
```java
final class SquareNumber {
    private SquareNumber() {}
    
    public static int getSum(int number, boolean useRecursion) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (useRecursion) return recursiveGetSum(number);
        else return usualGetSum(number);
    }

    private static int recursiveGetSum(int number) {
        if (number == 1) return (int) Math.pow(number, 2);
        else return (int) Math.pow(number, 2) + recursiveGetSum(number - 1);
    }

    private static int usualGetSum(int number) {
        int result = 0;

        while (number > 0) {
            result += (int) Math.pow(number, 2);
            number -= 1;
        }

        return result;
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final int[] FOR_USUAL_METHOD = new int[]{1, 2, 5, 7, 8};
        final int[] FOR_RECURSIVE_METHOD = new int[]{3, 7, 8, 10, 12};

        System.out.println("Вычисление суммы квадратов обычным способом:");
        for (var number : FOR_USUAL_METHOD) {
            System.out.printf("f(%d) = %d\n\r", number,
                    SquareNumber.getSum(number, false));
        }

        System.out.println("\n\rВычисление суммы квадратов рекурсивным способом:");
        for (var number : FOR_RECURSIVE_METHOD) {
            System.out.printf("f(%d) = %d\n\r", number,
                    SquareNumber.getSum(number, true));
        }
    }
}

```

Вывод программы:
```text
Вычисление суммы квадратов обычным способом:
f(1) = 1
f(2) = 5
f(5) = 55
f(7) = 140
f(8) = 204

Вычисление суммы квадратов рекурсивным способом:
f(3) = 14
f(7) = 140
f(8) = 204
f(10) = 385
f(12) = 650
```

Вариант класса `SquareNumber` использующего только рекурсивный способ:
```java
final class SquareNumber {
    private SquareNumber() {}
    
    public static int getSum(int number) {
        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");

        if (number == 1) return (int) Math.pow(number, 2);
        else return (int) Math.pow(number, 2) + getSum(number - 1);
    }
}
```

Вариант класса `SquareNumber` использующего только нерекурсивный способ:
```java
final class SquareNumber {
    private SquareNumber() {}
  
    public static int getSum(int number) {
        int result = 0;

        if (number < 1) throw new IllegalArgumentException("Число " + number + " меньше единицы.");
        while (number > 0) {
          result += (int) Math.pow(number, 2);
          number -= 1;
        }
        
        return result;
    }
}
```

#### Задание №6
Напишите программу со статическим методом, которому аргументом передается
целочисленный массив и целое число. Результатом метод возвращает ссылку на новый
массив, который получается из исходного массива (переданного первым аргументом
методу), если в нём взять несколько начальных элементов. Количество элементов, которые
нужно взять из исходного массива, определяются вторым аргументом метода. Если второй
аргумент метода больше длины массива, переданного первым аргументом, то методом
создаётся копия исходного массива и возвращается ссылка на эту копию.

Код класса `SubArray`:
```java
final class SubArray {
    private SubArray() {}
    
    /**
     * Получение подмассива из массива.
     *
     * @param array Исходный массив.
     * @param newLength Новая длина массива.
     * @return Подмассив выделенный из исходного массива.
     */
    public static int[] getSub(int[] array, int newLength) {
        int[] result;

        /* Если новая длина больше исходного массива, то длина нового 
        массива будет равна длине исходного. */
        if (newLength > array.length) result = new int[array.length];
        else result = new int[newLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }

        return result;
    }

    /**
     * Получение подмассива из исходного массива и его вывод в консоль.
     */
    public static void printSub(int[] array, int newLength) {
        String result = "{ ";
        array = getSub(array, newLength);

        for (int i = 0; i < array.length; i++) {
            result += array[i] + "; ";
        }
        result += " }";

        System.out.println(result);
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {1, 2, 3, 10, 15, 85, 13, 10},
                    LENGTHS = new int[] {0, 8, 5, 25};

        for (var item : LENGTHS) {
            SubArray.printSub(ARRAY, item);
        }
    }
}
```

Вывод программы:
```text
{  }
{ 1; 2; 3; 10; 15; 85; 13; 10;  }
{ 1; 2; 3; 10; 15;  }
{ 1; 2; 3; 10; 15; 85; 13; 10;  }
```

#### Задание №7
Напишите программу со статическим методом, аргументом которому передастся
символьный массив, а результатом возвращается ссылка на целочисленным массив,
состоящий из кодов символов из массива - аргумента.

Код класса `ArrayConvert`:
```java
final class ArrayConvert {
    private ArrayConvert() {}
    
    public static int[] toCharCode(char[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        return result;
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final char[] CHAR_ARRAY = new char[]{'a', 'A', '\t', 'q', 'п', 'Й', '5'};
        int[] codeArray = ArrayConvert.toCharCode(CHAR_ARRAY);
        String line = "{ ";

        for (int i = 0; i < codeArray.length; i++) {
            line += String.format("'%s' = %d; ", CHAR_ARRAY[i], codeArray[i]);
        }
        line += "}";

        System.out.println(line);
    }
}
```

Вывод программы:
```text
{ 'a' = 97; 'A' = 65; '	' = 9; 'q' = 113; 'п' = 1087; 'Й' = 1049; '5' = 53; }
```

#### Задание №8
Напишите программу со статическим методом, аргументом которому передается
целочисленный массив, а результатом возвращается среднее значение для элементов
массива (сумма значений элементов, деленная на количество элементов в массиве).

Код класса `ArrayMath`:
```java
final class ArrayMath {
  private ArrayMath() {}

  public static int getAverage(int[] array) {
    int result = 0;

    for (var number : array) {
      result += number;
    }
    result /= array.length;

    return result;
  }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {5, 27, 0, -9, 68, 2, 7, 2, 224};
        String line = "";

        for (int i = 0; i < ARRAY.length - 1; i++) {
            line += ARRAY[i]+", ";
        }
        line += ARRAY[ARRAY.length - 1];

        System.out.printf("¯{%s} = %d\n\r", line, ArrayMath.getAverage(ARRAY));
    }
}
```

Вывод программы:
```text
¯{5, 27, 0, -9, 68, 2, 7, 2, 224} = 36
```

#### Задание №9
Напишите программу со статическим методом, аргументом которому передается
одномерный символьный массив. В результате вызова метода элементы массива попарно
меняются местами: первый — с последним, второй — с предпоследним и так далее.

Код класса `ArrayMath`:
```java
final class ArrayPermutation {
  private ArrayPermutation() {}

  /**
   * Попарная перестановка в массиве. Все изменения
   * выполняются в исходном массиве.
   *
   * @param array Исходный массив
   */
  public static <T> void pairwise(T[] array) {
        /* Если длина массива не чётная, то последний элемент
        остаётся на своём месте.*/
    for (int i = 0; i < array.length - 1; i += 2) {
      T temp = array[i];
      array[i] = array[i + 1];
      array[i + 1] = temp;
    }
  }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        Character[] array = new Character[] {'f', 'Q', 'T', 'z', 'q', 'a', 'r'};
        
        System.out.print(arrayToString(array) + " => ");
        ArrayPermutation.pairwise(array);
        System.out.println(arrayToString(array));
    }

    private static String arrayToString(Character[] array) {
        String result = "{";
        
        for (int i = 0; i < array.length - 1; i++) {
          result += "'" + array[i] + "', ";
        }
        result += "'" + array[array.length - 1] + "'}";
        
        return result;
    }
}
```

Вывод программы:
```text
{'f', 'Q', 'T', 'z', 'q', 'a', 'r'} => {'Q', 'f', 'z', 'T', 'a', 'q', 'r'}
```

#### Задание №10
Напишите программу со статическим методом, аргументом которому передается
произвольное количество целочисленных аргументов. Результатом метод возвращает
массив из двух элементов: это значения наибольшего и наименьшего значений среди
аргументов, переданных методу.

Код класса `SequenceAnalysing`:
```java
final class SequenceAnalysing {
    private SequenceAnalysing() {}

    /**
     * Поиск минимального и максимального значения в исходной
     * последовательности.
     *
     * @param array Исходная целочисленная последовательность.
     * @return Массив, в котором [0] - минимальное значение,
     *                           [1] - максимальное значение.
     */
    public static int[] getExtremeValues(int ...array) {
        int[] result;

        if (array.length == 0) throw new IllegalArgumentException("Последовательность должна иметь хотя бы один элемент.");

        result = new int[] {array[0], array[0]};
        for (var number : array) {
            if (number < result[0]) result[0] = number;
            if (number > result[1]) result[1] = number;
        }

        return result;
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        final int[] ARRAY = new int[] {-10, 5, 28, 2, 0, 100, 2, 8, -2};
        var result = SequenceAnalysing.getExtremeValues(ARRAY);
        String line = "";

        for (int i = 0; i < ARRAY.length - 1; i++) {
            line += ARRAY[i]+", ";
        }
        line += ARRAY[ARRAY.length - 1];

        System.out.printf("{%s} => min = %d, max = %d\n\r", line, result[0], result[1]);
    }
}
```

Вывод программы:
```text
{-10, 5, 28, 2, 0, 100, 2, 8, -2} => min = -10, max = 100
```

## Вывод
В ходе лабораторной работы были получены навыки работы с классами в
Java, а также с его элементами. Были разработаны программы реализующие 
статические и рекурсивные методы, а также методы с параметрами переменной 
длины.

В рамках лабораторной работы №5 было решено 10 задач на программирование,
для получения навыков работы с классами в Java. Листинг кода написанных
программ был представлен в разделе *Ход работы*. В результате лабораторной
работы поставленная цель была выполнена, а поставленные задачи достигнуты.