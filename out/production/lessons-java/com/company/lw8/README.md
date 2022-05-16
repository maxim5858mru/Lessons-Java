# Отчёт по лабораторной работе №8 «Введение в алгоритмы и структуры данных Java»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Приобретение навыков работы с рекурсивными методами,
знакомство с динамическими структурами данных, приобретение
навыков создания и использования простейшей динамической
структуры.

## Описание задачи
- Изучение справочного материала;
- Решение задач по программированию на следующие темы:
    - Рекурсивные алгоритмы;
    - Динамические структуры данных;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 7 задач по программированию. Листинг кода
представлен ниже.

#### Задание №1
Создать приложения для демонстрации примеров 1–5 из
раздела 1. Для примера 5 дополнительно вывести последовательность
обхода дерева рекурсивных вызовов. Отработать код с помощью
отладчика и привести скриншоты минимум трёх точек обработанных
отладчиком.

![Скриншот экрана с первой точкой отладки](images/Screenshot%20№1.png)

![Скриншот экрана с второй точкой отладки](images/Screenshot%20№2.png)

![Скриншот экрана с третьей точкой отладки](images/Screenshot%20№3.png)

Код класса `Main`:
```java
public class Main {
    private static int step = 0;

    public static void main(String[] args) {
        /* ПРИМЕР №1.
        Для заданного параметра x вывести
        последовательность значений элементов числового ряда в
        соответствии со следующими требованиями:

        - очередной элемент x = 2*x+1 (новое значение вычисляется с
        использованием старого);
        - 0 ≤ x < 20.
        */
        System.out.println("Пример №1:");
        sequenceOutput(1);
        System.out.println();

        /* ПРИМЕР №2
        Вывести последовательность, представленную в
        предыдущем примере, в обратном порядке.
         */
        System.out.println("\n\rПример №2:");
        SequenceOutputReverse(1);

        /* ПРИМЕР №3
        Для вышеописанного задания сделать вывод параметра
        перед вхождением в рекурсивный вызов и после него.
         */
        System.out.println("\n\rПример №3:");
        sequenceOutputMiddle(1);

        /* ПРИМЕР №4
        Вычислить факториал числа n с использованием
        рекурсии.
        */
        System.out.println("\n\rПример №4:");
        System.out.println("7! = " + factorial(7));

        /* ПРИМЕР №5
        Вывести число Фибоначчи, заданное его номером в
        последовательности.
        */
        System.out.println("\n\rПример №5: \n\r");
        System.out.println("\n\rFibonacci_Numbers[7] = " + fibonacciNumber(7));
    }

    private static void sequenceOutput(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            sequenceOutput(2 * x + 1);
        }
    }

    private static void SequenceOutputReverse(int x) {
        if ((2 * x + 1) < 20) {
            SequenceOutputReverse(2 * x + 1);
        }

        System.out.println("x=" + x);
    }

    private static void sequenceOutputMiddle(int x) {
        for (int i = 0; i < step; i++) {
            System.out.print(' ');
        }

        System.out.println("'+x+'->" + x);
        step++;
        if ((2 * x + 1) < 20) {
            sequenceOutputMiddle(2 * x + 1);
        }
        step--;

        for (int i = 0; i < step; i++) {
            System.out.print(' ');
        }
        System.out.println("'+x+'<-" + x);
    }

    private static int factorial(int n) {
        int result;
        if (n == 1) {
            return 1;
        } else {
            result = factorial(n - 1) * n;
            return result;
        }
    }

    private static int fibonacciNumber(int n) {
        System.out.println("Вывод последовательности вызовов: ");
        return fibonacciNumber(n, 0);
    }

    private static int fibonacciNumber(int n, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print('\t');
        }
        System.out.println("Called function[" + n + "]");
        i++;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciNumber(n - 2, i) + fibonacciNumber(n - 1, i);
        }
    }
}
```

Вывод программы:
```text
Пример №1:
x=1
x=3
x=7
x=15


Пример №2:
x=15
x=7
x=3
x=1

Пример №3:
'+x+'->1
 '+x+'->3
  '+x+'->7
   '+x+'->15
   '+x+'<-15
  '+x+'<-7
 '+x+'<-3
'+x+'<-1

Пример №4:
7! = 5040

Пример №5: 

Вывод последовательности вызовов: 
Called function[7]
	Called function[5]
		Called function[3]
			Called function[1]
			Called function[2]
				Called function[0]
				Called function[1]
		Called function[4]
			Called function[2]
				Called function[0]
				Called function[1]
			Called function[3]
				Called function[1]
				Called function[2]
					Called function[0]
					Called function[1]
	Called function[6]
		Called function[4]
			Called function[2]
				Called function[0]
				Called function[1]
			Called function[3]
				Called function[1]
				Called function[2]
					Called function[0]
					Called function[1]
		Called function[5]
			Called function[3]
				Called function[1]
				Called function[2]
					Called function[0]
					Called function[1]
			Called function[4]
				Called function[2]
					Called function[0]
					Called function[1]
				Called function[3]
					Called function[1]
					Called function[2]
						Called function[0]
						Called function[1]

Fibonacci_Numbers[7] = 13
```

#### Задание №2
Создать приложение с использованием рекурсии для перевода
целого числа, введенного с клавиатуры, в двоичную систему счисления.

Код класса `Main`:
```java
public class Main {
   public static void main(String[] args) {
      var scanner = new Scanner(System.in);
      int n;

      System.out.print("Введите число, которое нужно перевести в двоичную систему счисления: ");
      n = scanner.nextInt();

      System.out.println(n + " = 0x" + toBinaryNumeralSystem(n));
   }

   private static String toBinaryNumeralSystem(int n) {
      if ((n == 1) || (n == 0)) return Integer.toString(n);
      else {
         return Integer.toString(n % 2) + toBinaryNumeralSystem(n / 2);
      }
   }
}
```

Вывод программы:
```text
Введите число, которое нужно перевести в двоичную систему счисления: 5
5 = 0x101
```

#### Задание №3
Создать приложение, позволяющее ввести и вывести
одномерный массив целых чисел. Для ввода и вывода массива
разработать рекурсивные методы вместо циклов `for`.

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int[] data;

        System.out.print("Введите количество элементов в массиве: ");
        data = new int[scanner.nextInt()];
        getValues(data, scanner);

        System.out.println();
        printValues(data, scanner);
    }

    private static void getValues(int[] array, Scanner scanner) {
        getValues(array, 0, scanner);
    }

    private static void getValues(int[] array, int index, Scanner scanner) {
        System.out.print("[" + index + "] = ");
        array[index] = scanner.nextInt();

        if (index != array.length - 1) getValues(array, index + 1, scanner);
    }

    private static void printValues(int[] array, Scanner scanner) {
        System.out.print("Array[] = { ");
        printValues(array, 0, scanner);
        System.out.println("}");
    }

    private static void printValues(int[] array, int index, Scanner scanner) {
        System.out.print(array[index] + ((array.length - 1 != index)?", ":" "));

        if (index != array.length - 1) printValues(array, index + 1, scanner);
    }
}
```

Вывод программы:
```text
Введите количество элементов в массиве: 4
[0] = 9
[1] = 2
[2] = 5
[3] = 6

Array[] = { 9, 2, 5, 6 }
```

#### Задание №4
Выполнить пример 1 из раздела 2. Отработать код с помощью
отладчика и привести скриншоты минимум трёх точек обработанных
отладчиком.

![Скриншот экрана с первой точкой отладки](images/Screenshot%20№4.png)

![Скриншот экрана с второй точкой отладки](images/Screenshot%20№5.png)

![Скриншот экрана с третьей точкой отладки](images/Screenshot%20№6.png)

Код класса `Node`:
```java
/**
 * Класс Node - структура элемента списка
 */
class Node {
    public int value; // Значение
    public Node next; // Поле: ссылка на следующий узел

    /**
     * Конструктор класса Node - элемента списка
     */
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
```

Код класса `Main`:
```java
/**
 * Главный класс программы
 */
public class Main {
    public static void main(String[] args) {
        // Создание несвязанных узлов с помощью конструктора
        Node node0 = new Node(0, null); // 0-й узел - будет головой в списке
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null); // Последний узел - будет хвостом в списке

        // Связывание узлов в список с помощью ссылок
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        /* Вывод списка с использованием вспомогательной переменной ref,
           соответствующей текущему значению ссылки при прохождении по списку.
           */
        Node ref = node0;                          // Для перемещения по списку достаточно помнить голову
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
```

Вывод программы:
```text
 0 1 2 3
```

#### Задание №5 и №6
Создать два проекта, в которых продемонстрировать два
способа создания линейного однонаправленного списка (с головы и с
хвоста) согласно примеру 2 из второго раздела. Отработать код с
помощью отладчика и привести скриншоты минимум трёх точек
обработанных отладчиком.
---
Разработать проект, в котором для ввода, вывода и изменения
односвязного линейного списка создать следующие методы:

1. С использованием цикла:
    - Ввод с головы `createHead()`;
    - Ввод с хвоста `createTail()`;
    - Вывод (возвращается строка, сформированная из элементов списка) `toString()`;
    - Добавление элемента в начало списка `addFirst()`;
    - Добавление элемента в конец списка `addLast()`;
    - Вставка элемента в список с указанным номером `insert()`;
    - Удаление элемента с головы списка `removeFirst()`;
    - Удаление последнего элемента списка `removeLast()`;
    - Удаление из списка элемента с указанным номером `remove()`.
2. С использованием рекурсии:
    - Ввод с головы `createHeadRec()`;
    - Ввод с хвоста `createTailRec()`;
    - Вывод (возвращается строка, сформированная из элементов списка) `toStringRec()`.

![Скриншот экрана с первой точкой отладки](images/Screenshot%20№7.png)

![Скриншот экрана с второй точкой отладки](images/Screenshot%20№8.png)

![Скриншот экрана с третьей точкой отладки](images/Screenshot%20№9.png)

Код класса `ListNode`:
```java
import java.util.Objects;

public class ListNode<T> {
    public T value;
    public ListNode next;

    /**
     * Конструктор для создания узла списка, без указания ссылки на следующий узел в списке
     *
     * @param value Значение узла списка
     */
    public ListNode(T value) {
        this.value = value;
    }

    /**
     * Конструктор для создания узла списка, с указанием ссылки на следующий узел в списке
     *
     * @param value Значение узла списка
     * @param next  Следующий элемент в списке
     */
    protected ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(value, listNode.value) && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "hashCode()=" + hashCode() +
                ", value=" + value +
                (next != null ? (", next.hashCode()=" + next.hashCode()) : ", next=null") +
                '}';
    }
}
```

Код класса `List`:
```java
import java.util.Objects;

public class List<T> {
   /**
    * Используется для определения способа реализации конструктора,
    * принимающего массив значений
    */
   private final boolean USE_DIRECT_ORDER = true;

   // --------------------------------------------------------------
   // --- Public методы
   // --------------------------------------------------------------

   /**
    * Первый узел в списке
    */
   private ListNode<T> head;

   /**
    * конструктор для инициализации пустого списка
    */
   public List() {
      head = null;
   }

   /**
    * Конструктор для инициализации списка с одним элементом
    *
    * @param value Значение первого элемента списка
    */
   public List(T value) {
      head = new ListNode<>(value);
   }

   /**
    * Конструктор для инициализации списка по массиву данных
    *
    * @param array Исходный массив данных
    */
   public List(T[] array) {
      if (USE_DIRECT_ORDER) {
         createHead(array);
      } else {
         createTail(array);
      }
   }

   /**
    * Создание (или пересоздание) списка по массиву данных.
    * Данный метод заполняет список начиная с первого элемента
    *
    * @param array Исходный массив данных
    */
   public void createHead(T[] array) {
      head = new ListNode<>(array[0]);                  // Инициализация первого элемента списка

      var node = head;
      for (int i = 1; i < array.length; i++) {
         node.next = new ListNode<>(array[i]);
         node = node.next;
      }
   }

   /**
    * Создание (или пересоздание) списка по массиву данных.
    * Данный метод заполняет список начиная с последнего элемента
    *
    * @param array Исходный массив данных
    */
   public void createTail(T[] array) {
      /*
       * Инициализация первого элемента списка последним
       * значением массива. В дальнейшем, по мере продвижения
       * к началу исходного списка, данное значение будет в
       * конце списка.
       */

      head = new ListNode<>(array[array.length - 1]);

      for (int i = array.length - 2; i >= 0; i--) {
         head = new ListNode<>(array[i], head);
      }
   }

   /**
    * Вставка элемента в начало списка
    *
    * @param value Значение создаваемого элемента списка
    */
   public void addFirst(T value) {
      head = new ListNode<>(value, head);
   }

   /**
    * Вставка элемента в конец списка
    *
    * @param value Значение создаваемого списка
    */
   public void addLast(T value) {
      var node = head;

      while (node.next != null) {
         node = node.next;
      }
      node.next = new ListNode<>(value);
   }

   /**
    * Удаление элемента по индексу
    *
    * @param index Индекс удаляемого элемента
    */
   public void remove(int index) {
      var node = head;

      if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
      for (int i = 1; i < index - 2; i++) {
         node = node.next;
      }
      node.next = null;
   }

   /**
    * Удаление элемента в начале списка
    */
   public void removeFirst() {
      head = head.next;
   }

   /**
    * Удаление последнего элемента в списке
    */
   public void removeLast() {
      var node = head;

      while (node.next.next != null) {
         node = node.next;
      }
      node.next = null;
   }

   /**
    * Вставка элемента согласно номеру указанного индекса
    *
    * @param value Значение вставляемого элемента
    * @param index Индекс, по которому производится вставка элемента в список
    */
   public void insert(T value, int index) {
      var node = head;

      if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
      for (int i = 1; i < index - 1; i++) {
         node = node.next;
      }
      node.next = new ListNode<>(value, node.next);
   }

   /**
    * Получение объекта узла списка по его индексу
    *
    * @param index Индекс искомого элемента
    * @return Узел списка по указанному индексу
    */
   public ListNode getByIndex(int index) {
      var node = head;

      if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
      for (int i = 1; i < index; i++) {
         node = node.next;
      }

      return node;
   }

   /**
    * Получение значение узла по
    *
    * @param index Индекс искомого элемента
    * @return Значение узла списка по указанному индексу
    */
   public T getValueByIndex(int index) {
      var node = head;

      if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
      for (int i = 1; i < index; i++) {
         node = node.next;
      }

      return node.value;
   }

   /**
    * Получение массива объектов списка
    *
    * @return Массив объектов исходного списка
    */
   public ListNode<T>[] getItems() {
      var result = new ListNode[length()];

      if (result.length != 0) {
         result[0] = head;
         for (int i = 1; i < result.length; i++) {
            result[i] = ((ListNode) result[i - 1]).next;
         }
      }

      return result;
   }

   /**
    * Изменение значение узла списка
    *
    * @param index Индекс сходного узла
    * @param value Новое значение узла списка
    */
   public void set(int index, T value) {
      var node = head;

      if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
      for (int i = 1; i < index; i++) {
         node = node.next;
      }
      node.value = value;
   }

   /**
    * Получение длины списка
    *
    * @return Целочисленное значение длины списка
    */
   public int length() {
      var node = head;
      int result = 0;

      while (node != null) {
         node = node.next;
         result++;
      }

      return result;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      List<?> list = (List<?>) o;
      return Objects.equals(head, list.head);
   }

   @Override
   public int hashCode() {
      return Objects.hash(head);
   }

   @Override
   public String toString() {
      var result = "List{" + ((head == null) ? "" : "\n\r");
      var node = head;

      if (node != null) {
         int i = 0;

         do {
            result += "\titem[" + i + "]=" + node + ((node.next != null) ? ",\n\r" : "\n\r");
            node = node.next;
            i++;
         } while (node != null);
      }
      result += "}";

      return result;
   }

   /**
    * Рекурсивный метода создание (или пересоздание)
    * списка по массиву данных. Данный метод заполняет список
    * начиная с первого элемента
    *
    * @param array Исходный массив данных
    */
   public void createHeadRec(T[] array) {
      if (array.length != 0) {
         head = new ListNode<>(array[0]);
         createHeadRec(array, 1, head);
      }
   }

   /**
    * Рекурсивный метод создания (или пересоздание)
    * списка по массиву данных. Данный метод заполняет список
    * начиная с последнего элемента
    *
    * @param array Исходный массив данных
    */
   public void createTailRec(T[] array) {
      if (array.length != 0) {
         head = new ListNode<>(array[array.length - 1]);
         createTailRec(array, array.length - 2, head);
      }
   }

   /**
    * Рекурсивный метод <code>toString()</code>
    *
    * @return Многострочное текстовое представление списка
    */
   public String toStringRec() {
      return "List{" + ((head == null) ? "" : "\n\r" + toStringRec(head, 0) + "\n\r") + "}";
   }

   // --------------------------------------------------------------
   // --- Private методы
   // --------------------------------------------------------------

   /**
    * Рекурсивная реализация метода <code>createHeadRec(T[] array)</code>
    *
    * @param array Исходный массив данных
    * @param index Текущий индекс
    * @param node  Последний созданный узел
    */
   private void createHeadRec(T[] array, int index, ListNode node) {
      if (array.length > index) {
         node.next = new ListNode<>(array[index]);
         createHeadRec(array, index + 1, node.next);
      }
   }

   /**
    * Рекурсивная реализация метода <code>createTailRec(T[] array)</code>
    *
    * @param array Исходный массив данных
    * @param index Текущий индекс
    * @param node  Последний созданный узел
    */
   private void createTailRec(T[] array, int index, ListNode node) {
      if (index >= 0) {
         head = new ListNode<>(array[index], head);
         createTailRec(array, index - 1, head);
      }
   }

   /**
    * Рекурсивная реализация метода <code>toStringRec()</code>
    *
    * @param node Текущий узел списка
    * @param index Порядковый номер узла
    * @return Многострочное текстовое представление списка
    */
   private String toStringRec(ListNode node, int index) {
      return "\titem[" + index + "]=" + node + ((node.next != null) ? (",\n\r" + toStringRec(node.next, index + 1)) : "");
   }
}
```

Код класса `Main`:
```java
public class Main {
   public static void main(String[] args) {
      // 1. Создание пустого списка
      var list = new List<Integer>();
      System.out.println("1: " + list.toString() + "\n\r");

      // 2. Создание списка, с указанием значения первого элемента
      list = new List<Integer>(5);
      System.out.println("2: " + list.toString() + "\n\r");

      // 3. Добавление значения 100 в начало списка
      list.addFirst(100);
      System.out.println("3: " + list.toString() + "\n\r");

      // 4. Добавление значения VALUE = 100 в конец списка
      list.addLast(100);
      System.out.println("4: " + list.toString() + "\n\r");

      // 5. Вставка значения 150 в ячейку с индексом 2
      list.insert(150, 2);
      System.out.println("5: " + list.toString() + "\n\r");

      // 6. Удаление элемента в начале списка
      list.removeFirst();
      System.out.println("6: " + list.toString() + "\n\r");

      // 7. Удаление элемента в конце списка
      list.removeLast();
      System.out.println("7: " + list.toString() + "\n\r");

      // 8. Удаление элемента по индексу 1
      list.remove(1);
      System.out.println("8: " + list.toString() + "\n\r");

      // 9. Создание списка, с головы по указанным значениям
      list.createHead(new Integer[] {1, 5, 10, 15, 20, 25});
      System.out.println("9: " + list.toString() + "\n\r");

      // 10. Создание списка, с хвоста по указанным значениям
      list.createTail(new Integer[] {1, 5, 10, 15, 20, 25});
      System.out.println("10: " + list.toString() + "\n\r");

      // 11: Рекурсивная реализация метода создания списка с головы
      var list1 = new List<Integer>();
      list1.createHeadRec(new Integer[] {1, 5, 10, 15, 20, 25});
      System.out.println("11: " + list1.toString() + "\n\r");

      // 12: Рекурсивная реализация метода создания списка с хвоста
      var list2 = new List<Integer>();
      list2.createTailRec(new Integer[] {1, 5, 10, 15, 20, 25});
      System.out.println("12: " + list2.toString() + "\n\r");

      // 13: Рекурсивная реализация метода toString()
      System.out.println("13: " + list.toStringRec() + "\n\r");
   }
}
```

Вывод программы:
```text
1: List{}

2: List{
	item[0]=ListNode{hashCode()=1116, value=5, next=null}
}

3: List{
	item[0]=ListNode{hashCode()=5177, value=100, next.hashCode()=1116},
	item[1]=ListNode{hashCode()=1116, value=5, next=null}
}

4: List{
	item[0]=ListNode{hashCode()=9238, value=100, next.hashCode()=5177},
	item[1]=ListNode{hashCode()=5177, value=5, next.hashCode()=4061},
	item[2]=ListNode{hashCode()=4061, value=100, next=null}
}

5: List{
	item[0]=ListNode{hashCode()=14849, value=100, next.hashCode()=10788},
	item[1]=ListNode{hashCode()=10788, value=150, next.hashCode()=5177},
	item[2]=ListNode{hashCode()=5177, value=5, next.hashCode()=4061},
	item[3]=ListNode{hashCode()=4061, value=100, next=null}
}

6: List{
	item[0]=ListNode{hashCode()=10788, value=150, next.hashCode()=5177},
	item[1]=ListNode{hashCode()=5177, value=5, next.hashCode()=4061},
	item[2]=ListNode{hashCode()=4061, value=100, next=null}
}

7: List{
	item[0]=ListNode{hashCode()=6727, value=150, next.hashCode()=1116},
	item[1]=ListNode{hashCode()=1116, value=5, next=null}
}

8: List{
	item[0]=ListNode{hashCode()=5611, value=150, next=null}
}

9: List{
	item[0]=ListNode{hashCode()=8122, value=1, next.hashCode()=7130},
	item[1]=ListNode{hashCode()=7130, value=5, next.hashCode()=6014},
	item[2]=ListNode{hashCode()=6014, value=10, next.hashCode()=4743},
	item[3]=ListNode{hashCode()=4743, value=15, next.hashCode()=3317},
	item[4]=ListNode{hashCode()=3317, value=20, next.hashCode()=1736},
	item[5]=ListNode{hashCode()=1736, value=25, next=null}
}

10: List{
	item[0]=ListNode{hashCode()=8122, value=1, next.hashCode()=7130},
	item[1]=ListNode{hashCode()=7130, value=5, next.hashCode()=6014},
	item[2]=ListNode{hashCode()=6014, value=10, next.hashCode()=4743},
	item[3]=ListNode{hashCode()=4743, value=15, next.hashCode()=3317},
	item[4]=ListNode{hashCode()=3317, value=20, next.hashCode()=1736},
	item[5]=ListNode{hashCode()=1736, value=25, next=null}
}

11: List{
	item[0]=ListNode{hashCode()=8122, value=1, next.hashCode()=7130},
	item[1]=ListNode{hashCode()=7130, value=5, next.hashCode()=6014},
	item[2]=ListNode{hashCode()=6014, value=10, next.hashCode()=4743},
	item[3]=ListNode{hashCode()=4743, value=15, next.hashCode()=3317},
	item[4]=ListNode{hashCode()=3317, value=20, next.hashCode()=1736},
	item[5]=ListNode{hashCode()=1736, value=25, next=null}
}

12: List{
	item[0]=ListNode{hashCode()=8122, value=1, next.hashCode()=7130},
	item[1]=ListNode{hashCode()=7130, value=5, next.hashCode()=6014},
	item[2]=ListNode{hashCode()=6014, value=10, next.hashCode()=4743},
	item[3]=ListNode{hashCode()=4743, value=15, next.hashCode()=3317},
	item[4]=ListNode{hashCode()=3317, value=20, next.hashCode()=1736},
	item[5]=ListNode{hashCode()=1736, value=25, next=null}
}

13: List{
	item[0]=ListNode{hashCode()=8122, value=1, next.hashCode()=7130},
	item[1]=ListNode{hashCode()=7130, value=5, next.hashCode()=6014},
	item[2]=ListNode{hashCode()=6014, value=10, next.hashCode()=4743},
	item[3]=ListNode{hashCode()=4743, value=15, next.hashCode()=3317},
	item[4]=ListNode{hashCode()=3317, value=20, next.hashCode()=1736},
	item[5]=ListNode{hashCode()=1736, value=25, next=null}
}
```

#### Задание №7
Разработать проект согласно любому варианту (табл. 1). 
Для вычислений требуемых величин использовать методы.

***Вариант №5***

Ввести с клавиатуры список из n целых чисел.
1. Найти сумму, количество и среднее значение среди чётных чисел.
2. Найти среди чётных положительных чисел данного массива минимальное и
максимальное значения и их номера и поменять их местами.

Код класса `ExtendedList`:
```java
import com.company.lw8.example5.List;

import java.util.Scanner;

public class ExtendedList extends List<Integer> {
    public ExtendedList() {
        super();
    }

    public ExtendedList(Integer value) {
        super(value);
    }

    public ExtendedList(Integer[] array) {
        super(array);
    }

    public void readFromConsole() {
        var scanner = new Scanner(System.in);
        Integer[] data;

        System.out.print("Введите количество значений: ");
        data = new Integer[scanner.nextInt()];

        for (int i = 0; i < data.length; i++) {
            System.out.printf("[%d] = ", i);
            data[i] = scanner.nextInt();
        }

        createHead(data);
    }

    public int sum() {
        Integer result = 0;

        for (var item : getItems()) {
            result += item.value;
        }
        return result;
    }

    public int meanEven() {
        int result = 0, y = 1;
        var data = getItems();

        for (int i = 0; i < data.length; i += 2) {
            result += data[i].value;
            y++;
        }
        return result / y;
    }

    public void changePositionPositiveEvenNumbers() {
        var data = getItems();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int indexMin = 0, indexMax = 0;

        for (int i = 0; i < data.length; i += 2) {
            if (data[i].value % 2 == 1) continue;

            if (data[i].value < min) {
                min = data[i].value;
                indexMin = i;
            }
            if (data[i].value > max) {
                max = data[i].value;
                indexMax = i;
            }
        }

        System.out.printf("Минимальное: [%d]=%d\n\r", indexMin, min);
        System.out.printf("Максимальное: [%d]=%d\n\r", indexMax, max);

        set(indexMin, max);
        set(indexMax, min);
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var object = new ExtendedList();

        object.readFromConsole();
        System.out.println("Количество: " + object.length());
        System.out.println("Сумма: " + object.sum());
        System.out.println("Среднее чётных чисел: " + object.sum());

        System.out.println();
        object.changePositionPositiveEvenNumbers();
        System.out.println("\n\rТеперь:\n\r" + object.toString());
    }
}
```

Вывод программы:
```text
Введите количество значений: 6
[0] = -5
[1] = 1
[2] = 8
[3] = 2
[4] = 4
[5] = -3
Количество: 6
Сумма: 7
Среднее чётных чисел: 7

Минимальное: [0]=-5
Максимальное: [2]=8

Теперь:
List{
	item[0]=ListNode{hashCode()=6200, value=8, next.hashCode()=4991},
	item[1]=ListNode{hashCode()=4991, value=-5, next.hashCode()=4185},
	item[2]=ListNode{hashCode()=4185, value=8, next.hashCode()=2976},
	item[3]=ListNode{hashCode()=2976, value=2, next.hashCode()=1953},
	item[4]=ListNode{hashCode()=1953, value=4, next.hashCode()=868},
	item[5]=ListNode{hashCode()=868, value=-3, next=null}
}
```

## Вывод
В ходе лабораторной работы были получены навыки работы с рекурсивными алгоритмами
и динамическими структурами данных. Также были приобретены навыки использования
простейших динамических структур.

В рамках лабораторной работы №8 было решено 7 задач на программирование в Java.
Листинг кода написанных программ был представлен в разделе *Ход работы*. 
В результате лабораторной работы поставленная цель была выполнена, а поставленные 
задачи достигнуты.