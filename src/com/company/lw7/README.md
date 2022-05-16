# Отчёт по лабораторной работе №7 «Введение в наследование»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Получить представление о механизме наследования в языке
программирования Java

## Описание задачи
- Изучение справочного материала;
- Решение задач по программированию на темы:
  - Наследование классов;
  - Переопределение методов;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 5 задач по программированию. Листинг кода
представлен ниже.

#### Задание №1
Напишите программу, в которой есть суперкласс с приватным текстовым полем,
конструктором с текстовым параметром и где переопределен метод `toString()`. На основе
суперкласса путём наследования создаётся подкласс. У него появляется еще одно
приватное текстовое поле. Также подкласс должен иметь версии конструктора с одним и
двумя текстовыми аргументами, а еще в нём должен быть переопределен метод `toString()`.
В обоих классах метод `toString()` переопределяется так, что он возвращает строку с
названием класса и значение текстового поля или текстовых полей.

Код класса `SuperClass`:
```java
public class SuperClass {
    protected String firstText;

    public SuperClass(String text) {
        this.firstText = text;
    }

    @Override
    public String toString() {
        return "Superclass{" +
                "text='" + firstText + '\'' +
                '}';
    }
}
```

Код класса `SubClass`:
```java
public class SubClass extends SuperClass {
  protected String secondText;

  public SubClass(String text) {
    super(text);
  }

  public SubClass(String firstText, String secondText) {
    super(firstText);
    this.secondText = secondText;
  }

  @Override
  public String toString() {
    return "SubClass{" +
            "firstText='" + firstText + '\'' +
            ", secondText='" + secondText + '\'' +
            '}';
  }
}

```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass("Text 1");
        var firstSubClassObject = new SubClass("Text 2");
        var secondSubClassObject = new SubClass("Text 3", "Text 5");

        System.out.println(superClassObject.toString());
        System.out.println(firstSubClassObject.toString());
        System.out.println(secondSubClassObject.toString());
    }
}
```

Вывод программы:
```text
Superclass{text='Text 1'}
SubClass{firstText='Text 2', secondText='null'}
SubClass{firstText='Text 3', secondText='Text 5'}
```

#### Задание №2
Напишите программу, в которой есть суперкласс с приватным текстовым полем. В
базовом классе должен быть метод для присваивания значения полю: без параметров и с
одним текстовым параметром. Объект суперкласса создаётся передачей одного текстового
аргумента конструктору. Доступное только для чтения свойство результатом возвращает
длину текстовой строки. На основе суперкласса создаётся подкласс. В подклассе появляется
дополнительное открытое целочисленное поле. В классе должны быть такие версии метода
для присваивания значений полям (используется переопределение и перегрузка метода из
суперкласса): без параметров, с текстовым параметром, с целочисленным параметром, с
текстовым и целочисленным параметром. У конструктора подкласса два параметра
(целочисленный и текстовый).

Код класса `SuperClass`:
```java
public class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }

    public void set() {
        text = null;
    }

    public void set(String text) {
        this.text = text;
    }

    public int length() {
        return text.length();
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "text='" + text + '\'' +
                '}';
    }
}
```

Код класса `SubClass`:
```java
public class SubClass extends SuperClass {
    private Integer number;

    public SubClass(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void set() {
        super.set();
        number = null;
    }

    @Override
    public void set(String text) {
        super.set(text);
    }

    public void set(int number) {
        this.number = number;
    }

    public void set(String text, int number) {
        super.set(text);
        this.number = number;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "text.length()=" + length() +
                ", number=" + number +
                '}';
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass("Text");
        var subClassObject = new SubClass("Text ######", 255);

        System.out.println(superClassObject.toString());
        System.out.println(subClassObject.toString());
    }
}
```

Вывод программы:
```text
SuperClass{text='Text'}
SubClass{text.length()=11, number=255}
```

#### Задание №3
Напишите программу, в которой на основе суперкласса создается подкласс, а на
основе этого подкласса создаётся еще один подкласс (цепочка наследования из трёх
классов). В первом суперклассе есть открытое целочисленное поле, метод с одним
параметром для присваивания значения полю и конструктор с одним параметром. Во
втором классе появляется открытое символьное поле, метод с двумя параметрами для
присваивания значения полям (перегрузка метода из суперкласса) и конструктор с двумя
параметрами. В третьем классе появляется открытое текстовое ноле, метод с тремя
аргументами для присваивания значений полям (перегрузка метода из суперкласса) и
конструктор с тремя параметрами. Для каждого класса определите метод `toString()` так,
чтобы он возвращал строку с названием класса и значениями всех полей объекта.

Код класса `SuperClass`:
```java
public class SuperClass {
    public Integer number;

    public SuperClass(int number) {
        this.number = number;
    }

    public void set(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "number=" + number +
                '}';
    }
}
```

Код класса `FirstSubClass`:
```java
public class FirstSubClass extends SuperClass {
    public Character symbol;

    public FirstSubClass(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void set(int number, char symbol) {
        set(number);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "FirstSubClass{" +
                "symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}
```

Код класса `SecondSubClass`:
```java
public class SecondSubClass extends FirstSubClass {
    public String text;

    public SecondSubClass(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    public void set(int number, char symbol, String text) {
        set(number, symbol);
        this.text = text;
    }

    @Override
    public String toString() {
        return "SecondSubClass{" +
                "text='" + text + '\'' +
                ", symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var superClassObject = new SuperClass(5);
        var firstSubClassObject = new FirstSubClass(100, 'A');
        var secondSubClassObject = new SecondSubClass(255, 'Z', "Hello World!");

        System.out.println(superClassObject.toString());
        System.out.println(firstSubClassObject.toString());
        System.out.println(secondSubClassObject.toString());
    }
}
```

Вывод программы:
```text
SuperClass{number=5}
FirstSubClass{symbol=A, number=100}
SecondSubClass{text='Hello World!', symbol=Z, number=255}
```

#### Задание №4
Напишите программу, в которой использована цепочка наследования из трёх
классов. В первом классе есть открытое символьное поле. Во втором классе появляется
открытое текстовое поле. В третьем классе появляется открытое целочисленное поле. В
каждом из классов должен быть конструктор, позволяющий создавать объект на основе
значений полей, переданных аргументами конструктору, а также конструктор создания
копии.

Код класса `FirstClass`:
```java
public class FistClass implements Cloneable {
    public Character symbols;

    private FirstClass(FistClass object) {
        symbols = object.symbols;
    }

    public FirstClass(char symbols) {
        this.symbols = symbols;
    }

    @Override
    public Object clone() {
        return new FistClass(this);
    }

    @Override
    public String toString() {
        return "FistClass{" +
                "symbols=" + symbols +
                '}';
    }
}
```

Код класса `SecondClass`:
```java
public class SecondClass extends FirstClass implements Cloneable {
    public String text;

    private SecondClass(SecondClass object) {
        super(object.symbols);
        text = object.text;
    }

    public SecondClass(char symbols, String text) {
        super(symbols);
        this.text = text;
    }

    @Override
    public Object clone() {
        return new SecondClass(this);
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "text='" + text + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}
```

Код класса `ThirdClass`:
```java
public class ThirdClass extends SecondClass implements Cloneable {
    public Integer number;

    private ThirdClass(ThirdClass object) {
        super(object.symbols, object.text);
        number = object.number;
    }

    public ThirdClass(char symbols, String text, int number) {
        super(symbols, text);
        this.number = number;
    }

    @Override
    public Object clone() {
        return new ThirdClass(this);
    }

    @Override
    public String toString() {
        return "ThirdClass{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var firstClassObject = new FistClass('R');
        var secondClassObject = new SecondClass('U', "Hi, World!");
        var thirdClassObject = new ThirdClass('Q', "Text", 128);
        
        System.out.println(firstClassObject);
        System.out.println(secondClassObject);
        System.out.println(thirdClassObject);
        
        var clonedObject = firstClassObject.clone();
        firstClassObject.symbols = 'H';
        System.out.println("\n\rПосле клонирования и изменения исходного объекта:");
        System.out.println("\tИсходный:\t" + firstClassObject.toString());
        System.out.println("\tКлон:\t\t" + clonedObject.toString());
    }
}
```

Вывод программы:
```text
FistClass{symbols=R}
SecondClass{text='Hi, World!', symbols=U}
ThirdClass{number=128, text='Text', symbols=Q}

После клонирования и изменения исходного объекта:
	Исходный:	FistClass{symbols=H}
	Клон:		FistClass{symbols=R}
```

#### Задание №5
Напишите программу, в которой есть суперкласс с защищённым текстовым полем,
конструктор с текстовым параметром и метод, при вызове которого в консольном окне
отображается название класса и значение поля. На основе суперкласса создаются два
подкласса (оба на основе одного и того же суперкласса). В одном из классов появляется
защищенное целочисленное поле, там есть конструктор с двумя параметрами и
переопределен метод для отображения значений полей объекта и названия класса. Во
втором подклассе появляется защищенное символьное поле, конструктор с двумя
параметрами и переопределен метод, отображающий в консоли название класса и значения
полей. В главном методе создайте объекты каждого из классов. Проверьте работу метода,
отображающего значения полей объектов, для каждого из объектов. Вызовите этот же
метод через объектную переменную суперкласса, которая ссылается на объект
производного класса.

Код класса `FirstClass`:
```java
import java.io.PrintStream;

public class FirstClass {
    private String text;

    public FirstClass(String text) {
        this.text = text;
    }

    public void PrintInfo() {
        PrintInfo(System.out);
    }

    public void PrintInfo(PrintStream output) {
        output.println(this);
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "text='" + text + '\'' +
                '}';
    }
}
```

Код класса `SecondClass`:
```java
import java.io.PrintStream;
import java.util.regex.Pattern;

public class SecondClass extends FirstClass {
    private Integer number;

    public SecondClass(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void PrintInfo() {
        PrintInfo(System.out);
    }

    @Override
    public void PrintInfo(PrintStream output) {
        output.println(this.toString() + " [вызванный метод SecondClass.PrintInfo]");
    }

    @Override
    public String toString() {
        var matcher = Pattern.compile("'.*'").matcher(super.toString());
        matcher.find();
        String text = super.toString().substring(matcher.start(), matcher.end());

        return "SecondClass{" +
                "text=" + text +
                ", number=" + number +
                '}';
    }
}
```

Код класса `ThirdClass`:
```java
import java.io.PrintStream;
import java.util.regex.Pattern;

public class ThirdClass extends FirstClass {
    private Character symbols;

    public ThirdClass(String text, char symbols) {
        super(text);
        this.symbols = symbols;
    }

    @Override
    public void PrintInfo() {
        PrintInfo(System.out);
    }

    @Override
    public void PrintInfo(PrintStream output) {
        output.println(this.toString() + " [вызванный метод ThirdClass.PrintInfo]");
    }

    @Override
    public String toString() {
        var matcher = Pattern.compile("'.*'").matcher(super.toString());
        matcher.find();
        String text = super.toString().substring(matcher.start(), matcher.end());

        return "SecondClass{" +
                "text=" + text +
                ", symbols='" + symbols +
                "'}";
    }
}
```

Код класса `Main`:
```java
public class Main {
    public static void main(String[] args) {
        var firstClassObject = new FirstClass("Text");
        var secondClassObject = new SecondClass("Qwertyuiop", 64);
        var thirdClassObject = new ThirdClass("Asdfghjkl", 'F');

        firstClassObject.PrintInfo();
        secondClassObject.PrintInfo();
        thirdClassObject.PrintInfo(System.out);

        System.out.println();
        ((FirstClass) secondClassObject).PrintInfo();
        ((FirstClass) thirdClassObject).PrintInfo();
    }
}
```

Вывод программы:
```text
FirstClass{text='Text'}
SecondClass{text='Qwertyuiop', number=64} [вызванный метод SecondClass.PrintInfo]
SecondClass{text='Asdfghjkl', symbols='F'} [вызванный метод ThirdClass.PrintInfo]

SecondClass{text='Qwertyuiop', number=64} [вызванный метод SecondClass.PrintInfo]
SecondClass{text='Asdfghjkl', symbols='F'} [вызванный метод ThirdClass.PrintInfo]
```

## Вывод
В ходе лабораторной работы были получены навыки работы с суперклассами и 
производными классами. Были разработаны программы реализующие наследование 
классов.

В рамках лабораторной работы №7 было решено 5 задач на программирование,
для получения навыков работы с классами в Java. Листинг кода написанных
программ был представлен в разделе *Ход работы*. В результате лабораторной
работы поставленная цель была выполнена, а поставленные задачи достигнуты.