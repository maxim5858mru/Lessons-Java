# Отчёт по лабораторной работе №4 «Работа с оператором цикла и массивами»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Укрепить навыки работы с массивами и операторами цикла.

## Описание задачи
- Изучение справочных материалов;
- Укрепление навыков работы с массивами и операторами цикла;
- Решение задач на программирование, по следующим темам:
  - работа с операторами;
  - 

## Ход работы
_

#### Задание №1
Напишите программу, которая выводить в консольное окно
прямоугольник, размеры сторон которого, ширина: 23 
колонки, высота: 11 строк.
```java
public class Example1 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        String line;

        for (int i = 0; i < HEIGHT; i++) {
            /* В цикле происходит формирование строки.
             * И только по окончанию работы цикла, она
             * выводится на экран.
             */
            line = "";
            printLineNumber(i + 1, HEIGHT);

            // Прямоугольник формируется с контуром, без заливки
            for (int j = 0; j < WIDTH; j++) {
                if ((i == 0) || (i == HEIGHT - 1))
                    line += '-';
                else if ((j == 0) || (j == WIDTH - 1))
                    line += '|';
                else
                    line += ' ';
            }

            System.out.println(line);
        }
    }

    /**
     * Вывод префикса, т.е. номера строки, который выравнен по правому краю
     * с учётом максимального возможного индекса строки.
     * @param index Текущий индекс строки.
     * @param maxIndex Максимально возможный индекс строки.
     */
    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        // Вычисление максимально возможного разряда числа, номера строки
        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }
}
```

Вывод программы:
```text
 1: -----------------------
 2: |                     |
 3: |                     |
 4: |                     |
 5: |                     |
 6: |                     |
 7: |                     |
 8: |                     |
 9: |                     |
10: |                     |
11: -----------------------
```

#### Задание №2
Напишите программу, которая выводит в консольное окно
прямоугольный треугольник.
```java
public class Example2 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        double k = (double) (WIDTH - 1) / (HEIGHT - 1);
        String line;

        for (int i = 0; i < HEIGHT; i++) {
            line = "";
            printLineNumber(i + 1, HEIGHT);

            /* Вычисление ширины каждой строки выполняется с
             * использованием коэффициента соотношения сторон
             */
            for (int j = 0; j < (int)(i * k) + 1; j++) {
                if (i == HEIGHT - 1)
                    line += '-';
                else if (j == 0)
                    line += '|';
                else if (j == (int)(i * k))
                    line += '\\';
                else
                    line += ' ';
            }
            System.out.println(line);
        }
    }

    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }
}
```

Вывод программы:
```text
 1: |
 2: | \
 3: |   \
 4: |     \
 5: |       \
 6: |          \
 7: |            \
 8: |              \
 9: |                \
10: |                  \
11: -----------------------
```

#### Задание №3
Напишите программу, в которой создаётся двумерный массив,
который выводит прямоугольник из цифр 2.
```java
public class Example3 {
    public static void main(String[] args) {
        final int WIDTH = 23, HEIGHT = 11;
        char[][] lines = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if ((i == 0) || (j == 0) || (j == WIDTH - 1) || (i == HEIGHT - 1))
                     lines[i][j] = '2';
                else
                    lines[i][j] = ' ';
            }
        }
        
        printCharArray(lines);
    }

    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }

    /**
     * Вывод массива по строчно, с указанием индекса строки
     * @param array Выводимый массив.
     */
    private static void printCharArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            printLineNumber(i + 1, array.length);

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
```

Вывод программы:
```text
 1: 22222222222222222222222
 2: 2                     2
 3: 2                     2
 4: 2                     2
 5: 2                     2
 6: 2                     2
 7: 2                     2
 8: 2                     2
 9: 2                     2
10: 2                     2
11: 22222222222222222222222
```

#### Задание №4
Напишите программу, в которой создаётся двумерный массив,
который выводит прямоугольный треугольник.
```java
public class Example4 {
    public static void main(String[] args) {
        final int WIDTH = 10, HEIGHT = 10;
        double k = (double) (WIDTH - 1) / (HEIGHT - 1);
        char[][] lines = new char[HEIGHT][];

        for (int i = 0; i < HEIGHT; i++) {
            lines[i] = new char[(int)(i * k) + 1];

            for (int j = 0; j < lines[i].length; j++) {
                if (i == HEIGHT - 1)
                    lines[i][j] = '-';
                else if (j == 0)
                    lines[i][j] = '|';
                else if (j == (int)(i * k))
                    lines[i][j] = '\\';
                else
                    lines[i][j] = ' ';
            }
        }

        printCharArray(lines);
    }

    private static void printLineNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d: ", index);
    }

    private static void printCharArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            printLineNumber(i + 1, array.length);

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
```

Вывод программы:
```text
 1: |
 2: |\
 3: | \
 4: |  \
 5: |   \
 6: |    \
 7: |     \
 8: |      \
 9: |       \
10: ----------
```

#### Задание №5
Напишите программу, в которой создаётся двумерный
целочисленный массив. Он заполняется случайными числами. Затем в этом
массиве строи и столбцы меняются местами: первая строка становится первым
столбцом, вторая строка становиться вторым столбцом и так далее. Например,
если исходный массив состоял из 3 строк и 5 столбцов, то в итоге получаем
массив из 5 строк и 3 столбцов.
```java
public class Example5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int rows, columns;
        int[][] array;

        // Считывание размера массива
        System.out.print("Введите количество строк и столбцов в массиве: ");
        rows = input.nextInt();
        columns = input.nextInt();

        // Генерация значений массива
        array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(-200, 200);
            }
        }

        // Промежуточный вывод полученного массива
        System.out.println("\n\rПолученный массив:");
        printIntArray(array);

        // Обработка и вывод окончательного массива
        System.out.println("\n\rМассив после транспонирования:");
        array = transposeIntArray(array);
        printIntArray(array);
    }

    /**
     * Вывод выравненного по правому краю числа, с учётом максимально
     * возможного числа.
     * @param number Выводимое число.
     * @param maxNumber Максимально возможное выводимое число.
     */
    private static void printFormatNumber(int number, int maxNumber) {
        int counter = 0;

        for (int z = maxNumber; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d", number);
    }

    private static void printIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printFormatNumber(i, array.length);
            System.out.print(": ");

            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[");
                printFormatNumber(array[i][j], 1000);
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /**
     * Транспонирование массива
     * @param array Исходный массив
     * @return Транспонированный массив
     */
    private static int[][] transposeIntArray(int[][] array) {
        int[][] result = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }

        return result;
    }
}
```

Вывод программы:
```text
Введите количество строк и столбцов в массиве: 3 5

Полученный массив:
0: [ 154] [  -2] [-102] [ 126] [  42] 
1: [  99] [-194] [ 127] [ -90] [  52] 
2: [ 160] [-167] [ -95] [ -32] [ 124] 

Массив после транспонирования:
0: [ 154] [  99] [ 160] 
1: [  -2] [-194] [-167] 
2: [-102] [ 127] [ -95] 
3: [ 126] [ -90] [ -32] 
4: [  42] [  52] [ 124] 
```

#### Задание №6
Напишите программу, в которой создаётся и инициализируется
двумерный числовой массив. Затем из этого массива удаляется строка и
столбец (создаётся новый массив, в котором по сравнению с исходным
удалена одна строка и один столбец). Индекс удаляемой строки и индекс
удаляемого столбца определяется с помощью генератора случайных чисел.
```java
import java.util.Random;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var random = new Random();
        int deletedRow, deletedColumn;
        int[][] array;

        // Считывание размера массива
        System.out.print("Введите количество строк и столбцов в массиве: ");
        array = new int[input.nextInt()][input.nextInt()];

        // Генерация значений массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(-200, 200);
            }
        }

        // Промежуточный вывод полученного массива
        System.out.println("\n\rПолученный массив:");
        printIntArray(array);

        // Генерация значений удаляемого столбца и строки, а также обработка массива
        deletedRow = random.nextInt(0, array.length - 1);
        deletedColumn = random.nextInt(0, array[0].length - 1);
        array = removeAtIntArray(array, deletedRow, deletedColumn);

        // Вывод окончательного массива
        System.out.printf("\n\rПолученный массив после удаления %d столбца и %d строки:\n\r",
                deletedColumn, deletedRow);
        printIntArray(array);
    }

    private static void printFormatNumber(int index, int maxIndex) {
        int counter = 0;

        for (int z = maxIndex; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d", index);
    }

    private static void printIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printFormatNumber(i, array.length);
            System.out.print(": ");

            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[");
                printFormatNumber(array[i][j], 1000);
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /**
     * Удаление строки и столбца из массива.
     * @param array Исходный массив.
     * @param row Удаляемая строка.
     * @param column Удаляемый столбец.
     * @return Массив без указанной строки и столбца.
     */
    private static int[][] removeAtIntArray(int[][] array, int row, int column) {
        int[][] result = new int[array.length - 1][array[0].length - 1];

        /* Цикл добавления значений из array в result, разделён на две части.
         * В начале добавляются элементы до удаляемой строки, а после все оставшиеся.
         * Аналогичный принцип используется в циклах для столбцов.
         */
        for (int i = 0; i < row; i++) {
            moveColumnsItems(array, column, result, i);
        }
        for (int i = row; i < array.length; i++) {
            moveColumnsItems(array, column, result, i - 1);
        }

        return result;
    }

    /**
     * Копирование элементов столбца без учёта элементов определённого столбца.
     * Метод выделен для оптимизации кода.
     * @param array Исходный массив
     * @param column Удаляемый столбец
     * @param result Окончательный массив
     * @param i Индекс текущей строки массива
     */
    private static void moveColumnsItems(int[][] array, int column, int[][] result, int i) {
        for (int j = 0; j < column; j++) {
            result[i][j] = array[i][j];
        }

        for (int j = column + 1; j < array[0].length; j++) {
            result[i][j - 1] = array[i][j];
        }
    }
}
```

Вывод программы:
```text
Введите количество строк и столбцов в массиве: 4 6

Полученный массив:
0: [ 139] [  39] [-151] [  -3] [  37] [ 101] 
1: [ 189] [ -73] [  -1] [ -80] [  83] [-162] 
2: [-158] [ 159] [ 131] [  81] [ -99] [ -21] 
3: [ 147] [  91] [ -74] [ -23] [  47] [-182] 

Полученный массив после удаления 4 столбца и 2 строки:
0: [ 139] [  39] [-151] [  -3] [ 101] 
1: [ 189] [ -73] [  -1] [ -80] [-162] 
2: [-158] [ 159] [ 131] [  81] [ -21] 
```

#### Задание №7
Напишите программу, в которой создаётся двумерный числовой массив
и этот массив заполняется «змейкой»: сначала первая строка (слева направо),
затем последний столбец (снизу вверх), вторая строка (слева направо) и так
далее.
```java
import java.util.Scanner;

public class Example7 {
    private enum go {LEFT, RIGHT, UP, DONW}

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int[][] array;

        System.out.print("Введите количество строк и столбцов в массиве: ");
        array = snakeFillArray(input.nextInt(), input.nextInt());

        System.out.println("\r\nПолученный массив:");
        printIntArray(array);
    }

    private static void printFormatNumber(int number, int maxNumber) {
        int counter = 0;

        for (int z = maxNumber; z > 0;) {
            z /= 10;
            counter++;
        }
        System.out.printf("%" + counter + "d", number);
    }

    private static void printIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printFormatNumber(i, array.length);
            System.out.print(": ");

            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[");
                printFormatNumber(array[i][j], array[0].length * array.length);
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /**
     * Инициализация массива заполняемого "змейкой".
     * @param rows Количество строк.
     * @param columns Количество столбцов.
     * @return Заполненный массив.
     */
    private static int[][] snakeFillArray(int rows, int columns) {
        int[][] array = new int[rows][columns];

        /* Начальное значение для заполнения ячеек '1', для того чтобы определять
         * не заполненные ячейки (которые неявно инициализируются значением '0').
         */
        snakeFillArray(array, 0, 0, 1, go.RIGHT);

        return array;
    }

    /**
     * Рекурсивная функция для заполнения массива "змейкой"
     * @param array Ссылка на заполняемы массив
     * @param i Текущая строка
     * @param j Текущий столбец
     * @param inputNumber Текущее значение
     * @param direction Направление заполнения значений
     */
    private static void snakeFillArray(int[][] array, int i, int j, int inputNumber, go direction) {
        /* Если функция не заполнила ни одной ячейки (inputNumber == number), это означает
         * что массив заполнен и необходимо сделать выход из рекурсивной функции.
         */
        int number = inputNumber;

        switch (direction) {
            case RIGHT:
                // Заполнение ячеек, пока цикл не дойдёт до границы "пустых" ячеек.
                while ((j < array[i].length) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    j++;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i + 1, j - 1, number,go.DONW);
                    break;
                }
            case DONW:
                while ((i < array.length) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    i++;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i - 1, j - 1, number,go.LEFT);
                    break;
                }
            case LEFT:
                while ((j >= 0) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    j--;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i - 1, j + 1, number,go.UP);
                    break;
                }
            case UP:
                while ((i >= 0) && (array[i][j] == 0)) {
                    array[i][j] = number;
                    number++;
                    i--;
                }

                if (inputNumber == number)
                    return;
                else {
                    snakeFillArray(array, i + 1, j + 1, number,go.RIGHT);
                    break;
                }
        }
    }
}
```

Вывод программы:
```text
Введите количество строк и столбцов в массиве: 10 5

Полученный массив:
 0: [ 1] [ 2] [ 3] [ 4] [ 5] 
 1: [26] [27] [28] [29] [ 6] 
 2: [25] [44] [45] [30] [ 7] 
 3: [24] [43] [46] [31] [ 8] 
 4: [23] [42] [47] [32] [ 9] 
 5: [22] [41] [48] [33] [10] 
 6: [21] [40] [49] [34] [11] 
 7: [20] [39] [50] [35] [12] 
 8: [19] [38] [37] [36] [13] 
 9: [18] [17] [16] [15] [14] 
```

#### Задание №8
Напишите программу «Шифр Цезаря», которая зашифровывает
введенный текст. Используете кодовую таблицу символов. При запуске
программы в консоль необходимо вывести сообщение: «Введите текст для
шифрования», после ввода текста, появляется сообщение: «Введите ключ».
После того как введены все данные, необходимо вывести преобразованную
строку с сообщением «Текст после преобразования: ». Далее необходимо
задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)»,
если пользователь вводит «y», тогда выполнить обратное преобразование.
Если пользователь вводит «n», того программа выводит сообщение «До
свидания!». Если пользователь вводит что-то другое, отличное от «y» или «n»,
то программа ему выводит сообщение: «Введите корректный ответ».
```java
import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        char[] text;
        int key;

        // 1 часть: шифрование сообщения
        System.out.print("Введите текст для шифрования: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();

        encrypt(text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
        System.out.println();

        // 2 часть: расшифровка сообщения
        while (true) {
            System.out.print("Выполнить обратное преобразование? (y/n) ");
            String answer = input.next();

            if (answer.equals("y"))
                break;
            else if (answer.equals("n")) {
                System.out.println("До свидания!");
                return;
            }
            else
                System.err.println("Введите корректный ответ");
        }

        System.out.print("Введите текст для расшифровки: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();
        input.nextLine();

        decrypt(text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
    }

    /**
     * Шифрование строки с помощью метода шифрования "Шифр Цезаря",
     * точнее шифрование массива символов.
     *
     * Результат функции представлен в массиве text.
     * @param text Массив символов.
     * @param key Ключ шифрования.
     */
    private static void encrypt(char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] + key);
        }
    }

    /**
     * Дешифрование строки с зашифрованной с помощью "Шифра Цезаря".
     * @param text Массив символов.
     * @param key Ключ расшифровки.
     */
    private static void decrypt(char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] - key);
        }
    }
}
```

Вывод программы:
```text
Введите текст для шифрования: Hello World!
Введите ключ: 3
Текст после преобразования: 'Khoor#Zruog$'

Выполнить обратное преобразование? (y/n) y
Введите текст для расшифровки: Khoor#Zruog$
Введите ключ: 3
Текст после преобразования: 'Hello World!'
```

#### Задание №9
Напишите программу «Шифр Цезаря», в которой необходимо реализовать 
собственный алфавит, остальные условия идентичны задаче 8.
```java
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        char[] text, alphabet;
        int key;

        // 0 часть: получение символов алфавита
        System.out.print("Введите последовательно символы алфавита: ");
        alphabet = input.nextLine().toCharArray();

        // 1 часть: шифрование сообщения
        System.out.print("Введите текст для шифрования: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();
        input.nextLine();

        encrypt(alphabet, text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
        System.out.println();

        // 2 часть: расшифровка сообщения
        while (true) {
            System.out.print("Выполнить обратное преобразование? (y/n) ");
            String answer = input.nextLine();

            if (answer.equals("y"))
                break;
            else if (answer.equals("n")) {
                System.out.println("До свидания!");
                return;
            }
            else
                System.err.println("Введите корректный ответ");
        }

        System.out.print("Введите текст для расшифровки: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();

        decrypt(alphabet, text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
    }

    private static void encrypt(char[] alphabet, char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            /* Если символ не существует в алфавите, то вызывается исключение.
             * Для отслеживания этого используется флаг, в виде boolean переменной.
             */
            boolean isCharChanged = false;

            // Поиск текущего символа в массиве алфавита.
            for (int j = 0; j < alphabet.length; j++) {
                if (text[i] == alphabet[j]) {
                    /* Вычисление порядково номера нового символа и
                     * замена исходного символа в массиве.
                     */
                    j = (j + key) % alphabet.length;
                    text[i] = alphabet[j];

                    isCharChanged = true;
                    break;
                }
            }

            if (!isCharChanged)
                throw new IllegalArgumentException("В заданном алфавите нет символа '" + text[i] +"'.");
        }
    }

    private static void decrypt(char[] alphabet, char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            boolean isCharChanged = false;

            for (int j = 0; j < alphabet.length; j++) {
                if (text[i] == alphabet[j]) {
                    /* Для вычисления нового символа необходимо дополнить
                     * порядковы номер исходного, до значения больше key.
                     */
                    while (j < key) {
                        j += alphabet.length;
                    }

                    text[i] = alphabet[j - key];

                    isCharChanged = true;
                    break;
                }
            }

            if (!isCharChanged)
                throw new IllegalArgumentException("В заданном алфавите нет символа '" + text[i] + "'.");
        }
    }
}
```

Вывод программы:
```text
Введите последовательно символы алфавита: qwertyuiopasdfghjklzxcvbnm
Введите текст для шифрования: java
Введите ключ: 3
Текст после преобразования: 'zfmf'

Выполнить обратное преобразование? (y/n) YN
Введите корректный ответ
Выполнить обратное преобразование? (y/n) y
Введите текст для расшифровки: zfmf
Введите ключ: 3
Текст после преобразования: 'java'
```

## Вывод
_