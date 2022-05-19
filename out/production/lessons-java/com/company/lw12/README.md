# Отчёт по лабораторной работе №12 «Работа с текстовыми файлами. Файлы с произвольным доступом и файлы для записи объектов»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Получение навыков ввода/вывода данных файла через
символьные потоки. Получение навыков работы с файлами с
произвольным доступом, содержащими данные какого-то одного
примитивного типа или данные разных примитивных типов. Знакомство
с механизмом сериализации и десериализации объектов собственных
разработанных классов.

## Описание задачи
- Изучение справочного материала;
- Изучение функциональных возможностей следующих классов:
    - Классов иерархии символьных потоков;
    - Класса `File`;
    - Класса `PrintWriter`;
- Изучение понятий **сериализация** и **десериализация**;
- Изучение примеров записи объектов в файл и чтение из файла;
- Решение задач по программированию на следующие темы:
    - Посимвольный ввод/вывод;
    - Буферизированный ввод/вывод данных текстового файла;
    - Преобразование байтовых потоков в символьные;
    - Файлы с произвольным доступом;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 3 задачи по программированию. Листинг кода
представлен ниже.

#### Задание №1
В отдельных проектах выполнить примеры 1–7 (8 и 9
не надо). Протестировать программы с помощью отладчика. Выявить
различие в работе программ в примерах 2 и 3. Заменить тип данных
переменных `int` на другие числовые типы по выбору и ознакомиться с
методами их чтения/записи и определения положения указателя.

Код класса `Case1`:
```java
import java.io.*;

/**
 * ПРИМЕР №1
 * Чтение из одного файла и запись в другой файл данных посимвольно.
 */
public class Case1 {
    public static void main(String[] args) throws IOException {
        Reader in = null;       // Можно сразу записать FileReader in = null;
        Writer out = null;      // Можно сразу записать FileWriter out = null;

        try {
            in = new FileReader("E:\\File1.txt");                 // Файл для чтения
            out = new FileWriter("E:\\File2.txt", true);

            /* Данные считываются и записываются побайтно, как и для
               InputStream/OutputStream
             */
            int oneByte;        // Переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
                // Запись с уничтожением ранее существующих данных
                // out.write((char)oneByte);

                // Запись с добавлением данных в конец
                out.append((char) oneByte);
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.err.println("Ошибка! ");
        } finally {
            in.close();
            out.close();
        }
    }
}
```

Код класса `Case2`:
```java
import java.io.*;

/**
 * ПРИМЕР №2
 * Чтение из одного файла и запись в другой файл данных
 * построчно с использованием буфера в 1 килобайт.
 */
public class Case2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // Создание файловых символьных потоков для чтения и записи
            br = new BufferedReader(new FileReader("E:\\FileOld.txt"), 1024);
            bw = new BufferedWriter(new FileWriter("E:\\FileNew.txt"));

            int lineCount = 0;                      // Счётчик строк
            String s;

            // Переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(s);
                bw.newLine();                       // Перевод на новую строку
            }
        } catch (IOException exception) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
```

Код класса `Case3`:
```java
import java.io.*;
import java.net.URL;

/**
 * ПРИМЕР №3
 * Прочитать и вывести на экран информацию из трёх источников: файла
 * на диске, интернет-страницы и массива данных типа byte. Указать кодировку,
 * поддерживающую кириллицу.
 */
public class Case3 {
    public static void readAllByByte(Reader in) throws IOException {
        while (true) {
            int oneByte = in.read();                // Читает 1 байт
            if (oneByte != -1) {                    // Признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\FileOld.txt");    // Байтовый поток
            Reader rFile = new InputStreamReader(inFile, "cp1251");         // Символьный поток
            readAllByByte(rFile);
            System.out.print("\n\n\n");
            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница
            InputStream inUrl = new URL("https://google.com").openStream();  // Байтовый поток
            Reader rUrl = new InputStreamReader(inUrl, "cp1251");            // Символьный поток
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251");        // Символьный поток
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.err.println("Ошибка: " + e);
        }
    }
}
```

Код класса `Case4`:
```java
import java.io.*;

/**
 * ПРИМЕР №4
 * Чтение из одного файла и запись в другой файл данных
 * построчно с использованием буферизации символьных потоков основанных на
 * байтовых файловых потоках.
 */
public class Case4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // Создание потоков для чтения и записи с нужной кодировкой
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\FileOld.txt"), "cp1251"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\FileNew.txt"), "cp1251"));

            // Переписывание информации из одного файла в другой
            int lineCount = 0;                      // Счётчик строк
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s);     // Запись без перевода строки
                bw.newLine();                       // Принудительный переход на новую строку
            }
        } catch (IOException e) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
```

Код класса `Case5`:
```java
import java.io.*;

/**
 * ПРИМЕР №5
 * Выполнить чтение из одного файла и запись в другой
 * файл с использованием класса PrintWriter
 */
public class Case5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            // Создание потоков
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\FileOld.txt"), "cp1251"));
            out = new PrintWriter("E:\\FileNew.txt", "cp1251");

            // Переписывание информации из одного файла в другой
            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        } catch (IOException e) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
```

Код класса `Case6`:
```java
import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №6
 * Работа с числовыми данными в файле с произвольным доступом.
 * Выполнить следующие подзадачи:
 * - записать в файл заданное количество чисел с плавающей точкой (1 число = 8 байта);
 * - прочитать данные в прямом и обратном порядке;
 * - получить информацию о файле и указателе до ввода и после ввода данных;
 * - отсортировать по возрастанию числа непосредственно в файле.
 */
public class Case6 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            File folder = new File("E:\\Folder");
            if (!folder.exists()) {                  // Создание папки на диске, если она не существует
                folder.mkdir();
            }

            File file = new File("E:\\Folder\\num1Mart.txt");
            file.createNewFile();                    // Создание файла в папке

            System.out.print("Сколько чисел надо записать в файл? => ");
            int count = scanner.nextInt();           // Введение количества чисел

            // Открытие файла одновременно для чтения и записи "rw"
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            System.out.println("Исходный размер файла в байтах = " + randomAccessFile.length() + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте.");
            System.out.println("Введите числа: ");
            for (int i = 0; i < count; i++) {
                // Запись числа в файл
                System.out.print("\t");
                randomAccessFile.writeDouble(scanner.nextDouble());
            }
            System.out.println("\n\rНовый размер файла в байтах = " + randomAccessFile.length() + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте");
            System.out.println("Количество байт на 1 число = " + randomAccessFile.length() / count);
            randomAccessFile.close();

            // Открыть файл только для чтения "r"
            randomAccessFile = new RandomAccessFile(file, "r");

            // Прочитать числа из файла и вывести на экран
            System.out.println("\n\rЧисла в файле:");
            for (int i = 0; i < count; i++) {        // i – текущий номер числа
                randomAccessFile.seek(i * 8);        /* Перевод указателя на текущее число i * 8 байта
                                                        в данной ситуации при последовательном считывании
                                                        операцию seek() можно было не использовать
                                                     */
                System.out.println("Число " + i + ": " + randomAccessFile.readDouble());
            }

            System.out.println("\n\rЧисла в обратном порядке:");
            for (int i = count - 1; i >= 0; i--) {
                randomAccessFile.seek(i * 8);        // Операцию использовать обязательно!
                System.out.println("Число " + i + ": " + randomAccessFile.readDouble());
            }
            // Перевод указателя на последнее число
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 8);
            System.out.println("\n\rКоличество чисел в файле = " + randomAccessFile.length() / 8 + ", последнее число= " + randomAccessFile.readInt());

            // Поиск заданного числа в файле и определение его номера (номеров)
            System.out.print("\n\rВведите число, которое нужно найти в файле => ");
            double x = scanner.nextDouble();
            int kol = 0;                             // Количество искомых чисел в файле
            for (int i = 0; i < count; i++) {
                randomAccessFile.seek(i * 8);
                double number = randomAccessFile.readDouble();
                if (number == x) {
                    kol++;
                    System.out.print("Номер " + i + ", ");
                }
            } System.out.println("количество искомых чисел = " + kol);
            randomAccessFile.close();

            // Сортировка чисел в файле методом "Пузырька"
            randomAccessFile = new RandomAccessFile(file, "rw");
            for (int k = 0; k < count; k++) {               // k – номер просмотра
                for (int i = 0; i < count - k - 1; i++) {   // i – номер числа
                    randomAccessFile.seek(i * 8);           // Переход к i-тому числу
                    double number1 = randomAccessFile.readDouble();
                    double number2 = randomAccessFile.readDouble();

                    if (number1 > number2) {                // Условие для сортировки по возрастанию
                        randomAccessFile.seek(i * 8);
                        randomAccessFile.writeDouble(number2);
                        randomAccessFile.writeDouble(number1);
                    }
                }
            }

            System.out.println("\n\rЧисла, отсортированные в файле:");
            for (int i = 0; i < count; i++) {
                randomAccessFile.seek(i * 8);
                System.out.println("\t" + randomAccessFile.readDouble());
            }

            randomAccessFile.close();
        } catch (IOException exception) {
            System.err.println("Конец файла " + exception);
        }
    }
}
```

Код класса `Case7`:
```java
import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №7
 * Выполнить запись строк и чтение их из файла с произвольным доступом.
 */
public class Case7 {
    public static void main(String[] args) {
        try {
            File folder = new File("E:\\Folder");
            if (!folder.exists()) folder.mkdir();

            File file = new File("E:\\Folder\\strokiRand.txt");
            file.createNewFile();

            Scanner scanner = new Scanner(System.in, "cp1251");
            System.out.print("Сколько строк надо записать в файл? => ");
            int count = scanner.nextInt();
            scanner.nextLine();                                         // Очистка буфера после ввода числа

            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw"); // Чтение/запись
            randomAccessFile.setLength(0);
            long length = randomAccessFile.length();
            System.out.println("\n\rОткрыт файл размером " + length + " байт");
            System.out.println("Введите строки:");
            int countSymbol = 0;                                        // Счётчик букв

            // Записать строки в файл
            for (int i = 0; i < count; i++) {
                String s = scanner.nextLine();
                randomAccessFile.writeUTF(s);
                countSymbol += s.length();
            }
            length = randomAccessFile.length();

            System.out.println("\n\rРазмер файла в байтах = " + length);
            randomAccessFile.close();

            // Открыть файл для чтения "r"
            randomAccessFile = new RandomAccessFile(file, "r");

            // Вывод строк из файла на экран
            System.out.println("\n\rСтроки из файла:");

            // Перевести указатель в начало файла (на первое слово)
            randomAccessFile.seek(0);
            for (int i = 0; i < count; i++) {
                System.out.println("Строка " + i + " начинается с байта " + 
                        randomAccessFile.getFilePointer() + " - " + 
                        randomAccessFile.readUTF() + " - заканчивается байтом " + 
                        (randomAccessFile.getFilePointer() - 1)
                );
            }
            randomAccessFile.close();
        } catch (IOException exception) {
            System.err.println("Конец файла " + exception);
        }
    }
}
```

Код класса `Main`:
```java
import java.io.IOException;

@FunctionalInterface
interface CaseInterface {
    public void main(String[] args);
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var cases = new CaseInterface[]{
                str -> {
                    try {
                        Case1.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    try {
                        Case2.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    Case3.main(args);
                },
                str -> {
                    try {
                        Case4.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    try {
                        Case5.main(args);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                str -> {
                    Case6.main(args);
                },
                str -> {
                    Case7.main(args);
                },
        };

        for (int i = 1; i < cases.length; i++) {
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
Пример №1
1: First line.
2: Second line.
3: Third line.

Пример №2
First line.
Second line.
Third line.
 конец 


<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ru"><head><meta content="&#1055;&#1086;&#1080;&#1089;&#1082; &#1080;&#1085;&#1092;&#1086;&#1088;&#1084;&#1072;&#1094;&#1080;&#1080; &#1074; &#1080;&#1085;&#1090;&#1077;&#1088;&#1085;&#1077;&#1090;&#1077;: &#1074;&#1077;&#1073; &#1089;&#1090;&#1088;&#1072;&#1085;&#1080;&#1094;&#1099;, &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;, &#1074;&#1080;&#1076;&#1077;&#1086; &#1080; &#1084;&#1085;&#1086;&#1075;&#1086;&#1077; &#1076;&#1088;&#1091;&#1075;&#1086;&#1077;." name="description"><meta content="noodp" name="robots"><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){window.google={kEI:'gtSEYqnwJMqSxc8PuOug4As',kEXPI:'0,1302536,56873,6058,207,4804,2316,383,246,5,1353,4014,1123753,1197779,622,380090,16114,28684,17572,4859,1361,283,9007,3029,17580,4998,13228,3847,10622,7432,15309,5081,885,708,1279,2742,149,1103,842,6295,3514,606,2023,1777,520,6342,8328,3227,2845,8,17449,15767,553,1851,15756,3,346,230,6460,149,13974,4,1528,656,1648,7039,20309,4764,2658,7357,13658,4437,16786,5821,2536,4094,4052,3,3541,1,42154,2,14022,1931,4317,7868,11623,5679,1021,2380,2718,18279,2,6,7736,4569,5815,437,2990,3739,14077,2618,1246,4612,2,6,1221,14968,1554,2778,4255,1834,1395,445,2,2,1,17306,6521,799,153,1416,1,8591,2566,4015,99,539,162,1401,1048,593,11638,7341,3218,6405,1,6621,139,773,261,844,1398,596,6,739,2006,916,141,158,841,490,610,24,804,76,2316,3667,1095,1846,3,350,756,380,4197,210,1916,4139,2872,2798,260,1430,620,1040,1508,775,506,21,1588,73,3,101,1202,909,62,134,913,233,2903,469,2067,894,88,55,101,941,352,89,5419847,3297,161,8796584,1326,3,1877,1,2562,1,748,141,795,6164,6751,155,17,13,72,139,4,2,20,2,169,13,19,46,5,39,644,29,2,2,1,2,1,2,2,7,4,1,2,2,2,2,2,2,1052,1,1,158,3,2,2,2,2,2,4,2,3,3,2011,1002,312,615,3,3,3,1,1,1,1,206,1,1,78,13,2,29,3,8,13,8,41,12,26,7,10,30,1,8,15,17,23650701,16,299793,4042142,4899,159,1358,7393,4828,2554,851,936899',kBL:'s79p'};google.sn='webhp';google.kHL='ru';})();(function(){
var f=this||self;var h,k=[];function l(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||h}function m(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b}
function n(a,b,c,d,g){var e="";c||-1!==b.search("&ei=")||(e="&ei="+l(d),-1===b.search("&lei=")&&(d=m(d))&&(e+="&lei="+d));d="";!c&&f._cshid&&-1===b.search("&cshid=")&&"slh"!==a&&(d="&cshid="+f._cshid);c=c||"/"+(g||"gen_204")+"?atyp=i&ct="+a+"&cad="+b+e+"&zx="+Date.now()+d;/^http:/i.test(c)&&"https:"===window.location.protocol&&(google.ml&&google.ml(Error("a"),!1,{src:c,glmm:1}),c="");return c};h=google.kEI;google.getEI=l;google.getLEI=m;google.ml=function(){return null};google.log=function(a,b,c,d,g){if(c=n(a,b,c,d,g)){a=new Image;var e=k.length;k[e]=a;a.onerror=a.onload=a.onabort=function(){delete k[e]};a.src=c}};google.logUrl=n;}).call(this);(function(){
google.y={};google.sy=[];google.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1};google.sx=function(a){google.sy.push(a)};google.lm=[];google.plm=function(a){google.lm.push.apply(google.lm,a)};google.lq=[];google.load=function(a,b,c){google.lq.push([[a],b,c])};google.loadAll=function(a,b){google.lq.push([a,b])};google.bx=!1;google.lx=function(){};}).call(this);google.f={};(function(){
document.documentElement.addEventListener("submit",function(b){var a;if(a=b.target){var c=a.getAttribute("data-submitfalse");a="1"===c||"q"===c&&!a.elements.q.value?!0:!1}else a=!1;a&&(b.preventDefault(),b.stopPropagation())},!0);document.documentElement.addEventListener("click",function(b){var a;a:{for(a=b.target;a&&a!==document.documentElement;a=a.parentElement)if("A"===a.tagName){a="1"===a.getAttribute("data-nohref");break a}a=!1}a&&b.preventDefault()},!0);}).call(this);</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
</style><style>body,td,a,p,.h{font-family:arial,sans-serif}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#1558d6}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}body{background:#fff;color:#000}a{color:#4b11a8;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#1558d6}a:visited{color:#4b11a8}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#f8f9fa;border:solid 1px;border-color:#dadce0 #70757a #70757a #dadce0;height:30px}.lsbb{display:block}#WqQANb a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#dadce0}.lst:focus{outline:none}.tiah{width:458px}</style><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){window.google.erd={jsr:1,bv:1582,de:true};
var f=this||self;var g,h=null!=(g=f.mei)?g:1,m,n=null!=(m=f.sdo)?m:!0,p=0,q,r=google.erd,u=r.jsr;google.ml=function(a,b,d,k,c){c=void 0===c?2:c;b&&(q=a&&a.message);if(google.dl)return google.dl(a,c,d),null;if(0>u){window.console&&console.error(a,d);if(-2===u)throw a;b=!1}else b=!a||!a.message||"Error loading script"===a.message||p>=h&&!k?!1:!0;if(!b)return null;p++;d=d||{};var e=c;c=encodeURIComponent;b="/gen_204?atyp=i&ei="+c(google.kEI);google.kEXPI&&(b+="&jexpid="+c(google.kEXPI));b+="&srcpg="+c(google.sn)+"&jsr="+c(r.jsr)+"&bver="+c(r.bv)+("&jsel="+e);e=a.lineNumber;void 0!==e&&(b+="&line="+
e);var l=a.fileName;l&&(b+="&script="+c(l),e&&l===window.location.href&&(e=document.documentElement.outerHTML.split("\n")[e],b+="&cad="+c(e?e.substring(0,300):"No script found.")));for(var t in d)b+="&",b+=c(t),b+="=",b+=c(d[t]);b=b+"&emsg="+c(a.name+": "+a.message);b=b+"&jsst="+c(a.stack||"N/A");12288<=b.length&&(b=b.substr(0,12288));a=b;k||google.log(0,"",a);return a};window.onerror=function(a,b,d,k,c){q!==a&&(a=c instanceof Error?c:Error(a),void 0===d||"lineNumber"in a||(a.lineNumber=d),void 0===b||"fileName"in a||(a.fileName=b),google.ml(a,!1,void 0,!1,"SyntaxError"===a.name||"SyntaxError"===a.message.substring(0,11)?2:0));q=null;n&&p>=h&&(window.onerror=null)};})();</script></head><body bgcolor="#fff"><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
}
})();</script><div id="mngb"><div id=gbar><nobr><b class=gb1>&#1055;&#1086;&#1080;&#1089;&#1082;</b> <a class=gb1 href="https://www.google.ru/imghp?hl=ru&tab=wi">&#1050;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;</a> <a class=gb1 href="https://maps.google.ru/maps?hl=ru&tab=wl">&#1050;&#1072;&#1088;&#1090;&#1099;</a> <a class=gb1 href="https://play.google.com/?hl=ru&tab=w8">Play</a> <a class=gb1 href="https://www.youtube.com/?gl=RU&tab=w1">YouTube</a> <a class=gb1 href="https://news.google.com/?tab=wn">&#1053;&#1086;&#1074;&#1086;&#1089;&#1090;&#1080;</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">&#1055;&#1086;&#1095;&#1090;&#1072;</a> <a class=gb1 href="https://drive.google.com/?tab=wo">&#1044;&#1080;&#1089;&#1082;</a> <a class=gb1 style="text-decoration:none" href="https://www.google.ru/intl/ru/about/products?tab=wh"><u>&#1045;&#1097;&#1105;</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.ru/history/optout?hl=ru" class=gb4>&#1048;&#1089;&#1090;&#1086;&#1088;&#1080;&#1103; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;</a> | <a  href="/preferences?hl=ru" class=gb4>&#1053;&#1072;&#1089;&#1090;&#1088;&#1086;&#1081;&#1082;&#1080;</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=ru&passive=true&continue=https://www.google.com/&ec=GAZAAQ" class=gb4>&#1042;&#1086;&#1081;&#1090;&#1080;</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div></div><center><br clear="all" id="lgpd"><div id="lga"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="ru" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input class="lst tiah" style="margin:0;padding:5px 8px 0 6px;vertical-align:top;color:#000;padding-right:38px" autocomplete="off" value="" title="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" maxlength="2048" name="q" size="57"><img src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" data-script-url="/textinputassistant/11/ru_tia.js" id="tsuid1" alt="" height="23" width="27"><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){var id='tsuid1';document.getElementById(id).onclick = function(){var s = document.createElement('script');s.src = this.getAttribute('data-script-url');(document.getElementById('xjsc')||document.body).appendChild(s);};})();</script></div></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" id="tsuid2" value="&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!" name="btnI" type="submit"><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){var id='tsuid2';document.getElementById(id).onclick = function(){if (this.form.q.value){this.checked = 1;if (this.form.iflsig)this.form.iflsig.disabled = false;}
else top.location='/doodles/';};})();</script><input value="AJiK0e8AAAAAYoTikn1LijrhDsRiV1JW_ZFhleEpBJEA" name="iflsig" type="hidden"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=ru&amp;authuser=0">&#1056;&#1072;&#1089;&#1096;&#1080;&#1088;&#1077;&#1085;&#1085;&#1099;&#1081; &#1087;&#1086;&#1080;&#1089;&#1082;</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){
var a,b="1";if(document&&document.getElementById)if("undefined"!=typeof XMLHttpRequest)b="2";else if("undefined"!=typeof ActiveXObject){var c,d,e=["MSXML2.XMLHTTP.6.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP","Microsoft.XMLHTTP"];for(c=0;d=e[c++];)try{new ActiveXObject(d),b="2"}catch(h){}}a=b;if("2"==a&&-1==location.search.indexOf("&gbv=2")){var f=google.gbvu,g=document.getElementById("gbv");g&&(g.value=a);f&&window.setTimeout(function(){location.href=f},0)};}).call(this);</script></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="WqQANb"><a href="http://www.google.ru/intl/ru/services/">&#1056;&#1077;&#1096;&#1077;&#1085;&#1080;&#1103; &#1076;&#1083;&#1103; &#1073;&#1080;&#1079;&#1085;&#1077;&#1089;&#1072;</a><a href="/intl/ru/about.html">&#1042;&#1089;&#1105; &#1086; Google</a><a href="https://www.google.com/setprefdomain?prefdom=RU&amp;prev=https://www.google.ru/&amp;sig=K_VVeqyDFK94JBMwqV_NeBvu3bE54%3D">Google.ru</a></div></div><p style="font-size:8pt;color:#70757a">&copy; 2022 - <a href="/intl/ru/policies/privacy/">&#1050;&#1086;&#1085;&#1092;&#1080;&#1076;&#1077;&#1085;&#1094;&#1080;&#1072;&#1083;&#1100;&#1085;&#1086;&#1089;&#1090;&#1100;</a> - <a href="/intl/ru/policies/terms/">&#1059;&#1089;&#1083;&#1086;&#1074;&#1080;&#1103;</a></p></span></center><script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){window.google.cdo={height:757,width:1440};(function(){
var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d="CSS1Compat"==c.compatMode?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}a&&b&&(a!=google.cdo.width||b!=google.cdo.height)&&google.log("","","/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI);}).call(this);})();</script> <script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){google.xjs={ck:'',cs:'',excm:[]};})();</script>  <script nonce="tPXt4aN51nhBfumbz8-QFg">(function(){var u='/xjs/_/js/k\x3dxjs.hp.en.xQGN1MgPiCE.O/am\x3dAOAJAEACkA/d\x3d1/ed\x3d1/esmo\x3d1/rs\x3dACT90oGxtNEiWCRJlccJPu5jZPK51FgSxw/m\x3dsb_he,d';
var d=this||self,e=function(a){return a};var g;var l=function(a,b){this.g=b===h?a:""};l.prototype.toString=function(){return this.g+""};var h={};
function n(){var a=u;google.lx=function(){p(a);google.lx=function(){}};google.bx||google.lx()}
function p(a){google.timers&&google.timers.load&&google.tick&&google.tick("load","xjsls");var b=document;var c="SCRIPT";"application/xhtml+xml"===b.contentType&&(c=c.toLowerCase());c=b.createElement(c);if(void 0===g){b=null;var k=d.trustedTypes;if(k&&k.createPolicy){try{b=k.createPolicy("goog#html",{createHTML:e,createScript:e,createScriptURL:e})}catch(q){d.console&&d.console.error(q.message)}g=b}else g=b}a=(b=g)?b.createScriptURL(a):a;a=new l(a,h);c.src=a instanceof l&&a.constructor===l?a.g:"type_error:TrustedResourceUrl";var f,m;(f=(a=null==(m=(f=(c.ownerDocument&&c.ownerDocument.defaultView||window).document).querySelector)?void 0:m.call(f,"script[nonce]"))?a.nonce||a.getAttribute("nonce")||"":"")&&c.setAttribute("nonce",f);document.body.appendChild(c);google.psa=!0};google.xjsu=u;setTimeout(function(){n()},0);})();function _DumpException(e){throw e;}
function _F_installCss(c){}
(function(){google.jl={attn:false,blt:'none',chnk:0,dw:false,dwu:true,emtn:0,end:0,ine:false,injs:'none',injt:0,lls:'default',pdt:0,rep:0,snet:true,strt:0,ubm:false,uwp:true};})();(function(){var pmc='{\x22d\x22:{},\x22sb_he\x22:{\x22agen\x22:true,\x22cgen\x22:true,\x22client\x22:\x22heirloom-hp\x22,\x22dh\x22:true,\x22dhqt\x22:true,\x22ds\x22:\x22\x22,\x22ffql\x22:\x22ru\x22,\x22fl\x22:true,\x22host\x22:\x22google.com\x22,\x22isbh\x22:28,\x22jsonp\x22:true,\x22msgs\x22:{\x22cibl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100; &#1087;&#1086;&#1080;&#1089;&#1082;&#1086;&#1074;&#1099;&#1081; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;\x22,\x22dym\x22:\x22&#1042;&#1086;&#1079;&#1084;&#1086;&#1078;&#1085;&#1086;, &#1074;&#1099; &#1080;&#1084;&#1077;&#1083;&#1080; &#1074; &#1074;&#1080;&#1076;&#1091;:\x22,\x22lcky\x22:\x22&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!\x22,\x22lml\x22:\x22&#1055;&#1086;&#1076;&#1088;&#1086;&#1073;&#1085;&#1077;&#1077;...\x22,\x22oskt\x22:\x22&#1069;&#1082;&#1088;&#1072;&#1085;&#1085;&#1072;&#1103; &#1082;&#1083;&#1072;&#1074;&#1080;&#1072;&#1090;&#1091;&#1088;&#1072;\x22,\x22psrc\x22:\x22&#1069;&#1090;&#1086;&#1090; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089; &#1073;&#1099;&#1083; &#1091;&#1076;&#1072;&#1083;&#1077;&#1085; &#1080;&#1079; &#1074;&#1072;&#1096;&#1077;&#1081; \\u003Ca href\x3d\\\x22/history\\\x22\\u003E&#1080;&#1089;&#1090;&#1086;&#1088;&#1080;&#1080; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;\\u003C/a\\u003E\x22,\x22psrl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100;\x22,\x22sbit\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1087;&#1086; &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1077;\x22,\x22srch\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google\x22},\x22ovr\x22:{},\x22pq\x22:\x22\x22,\x22refpd\x22:true,\x22rfs\x22:[],\x22sbas\x22:\x220 3px 8px 0 rgba(0,0,0,0.2),0 0 0 1px rgba(0,0,0,0.08)\x22,\x22sbpl\x22:16,\x22sbpr\x22:16,\x22scd\x22:10,\x22stok\x22:\x22Pz-R57r0cu9iStmwgF33t-21qEQ\x22,\x22uhde\x22:false}}';google.pmc=JSON.parse(pmc);})();</script>        </body></html>
 конец 


	
 конец 



Пример №3
1: First line.
2: Second line.
3: Third line.

Пример №4

Пример №5
Сколько чисел надо записать в файл? => 5
Исходный размер файла в байтах = 0, указатель стоит на 0-м байте.
Введите числа: 
	584,54
	-58,21
	0
	0,456
	822

Новый размер файла в байтах = 40, указатель стоит на 40-м байте
Количество байт на 1 число = 8

Числа в файле:
Число 0: 584.54
Число 1: -58.21
Число 2: 0.0
Число 3: 0.456
Число 4: 822.0

Числа в обратном порядке:
Число 4: 822.0
Число 3: 0.456
Число 2: 0.0
Число 1: -58.21
Число 0: 584.54

Количество чисел в файле = 5, последнее число= 1082278993

Введите число, которое нужно найти в файле => 0
Номер 2, количество искомых чисел = 1

Числа, отсортированные в файле:
	-58.21
	0.0
	0.456
	584.54
	822.0

Пример №6
Сколько строк надо записать в файл? => 4

Открыт файл размером 0 байт
Введите строки:
asdfghj
qwertyuio
zxcvbnm

Размер файла в байтах = 24

Строки из файла:
Строка 0 начинается с байта 0 - asdfghj - заканчивается байтом 8
Строка 1 начинается с байта 9 -  - заканчивается байтом 10
Строка 2 начинается с байта 11 - qwertyuio - заканчивается байтом 21
Строка 3 начинается с байта 22 -  - заканчивается байтом 23
```

Пример №2 показывает, что буферизированные символьные потоки позволяют считывать
файл строками, в то время как простой символьный поток в примере №3 позволяет
выполнять считывание только по одному символу.

#### Задание №2
Создать проект, позволяющий из одного текстового
файла, содержащего несколько строк (тип `String`) заранее
подготовленного текста на русском языке (обратитесь к классике),
построчно переписать в другой текстовый файл слова, отвечающие
условию.

*Условие*:

Переписать в результирующий файл слова, которые начинаются с той же
буквы, что и первое слово.

*Требования*:
- Слова из предложения выделять методом `split()`;
- В новом файле следует указать номер строки, в которой искомые
слова находились в исходном файле;
- Для каждой строки указать количество выбранных слов.

Код класса `Main`:
```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessInputFile = null, accessOutputFile = null;
        var inputFile = new File("E:\\InputText.txt");
        var outputFile = new File("E:\\Output.txt");

        // Пересоздание файла Output.txt
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        try {
            accessInputFile = new RandomAccessFile(inputFile, "r");
            accessOutputFile = new RandomAccessFile(outputFile, "rw");

            var line = accessInputFile.readLine();
            var smallLetter = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8).toLowerCase().charAt(0);
            var bigLetter = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8).charAt(0);
            var counters = new ArrayList<Integer>();

            // Поиск и запись найденных слов
            while (line != null) {
                line = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8);
                var words = line.split("[\s.!?\"«»;,]");
                var counter = 0;

                for (var word : words) {
                    if (word == "") continue;
                    else if (word.charAt(0) == smallLetter || word.charAt(0) == bigLetter) {
                        // $НОМЕР_СТРОКИ: $СЛОВО
                        accessOutputFile.writeUTF((counters.size() + 1) + ":\t" + word + "\n");
                        counter++;
                    }
                }

                counters.add(counter);
                line = accessInputFile.readLine();
            }

            // Запись количества найденных слов для каждой строки
            accessOutputFile.writeUTF("\n");
            for (int i = 0; i < counters.size(); i++) {
                accessOutputFile.writeUTF("### В строке №" + i + " найдено " + counters.get(i) + " слов.\n");
            }

            // Считывание записанного
            accessOutputFile.seek(2);
            line = accessOutputFile.readLine();
            while (line != null) {
                System.out.println(new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8));
                accessOutputFile.skipBytes(2);
                line = accessOutputFile.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            // Закрытие потоков
            if (accessOutputFile != null) {
                accessOutputFile.close();
            }
            if (accessInputFile != null) {
                accessInputFile.close();
            }
        }
    }
}
```

Вывод программы:
```text
1:	В
7:	Воспоминают
14:	в
15:	в
16:	вдруг
18:	влачил
19:	Вот
19:	возопил
25:	врагов
25:	видит
30:	в
32:	в
32:	веселом
33:	в
34:	в
37:	взор
38:	видит:
39:	воздвигнулась
41:	вольности
42:	Воспомнил
44:	вдруг
46:	Всё
46:	всё

### В строке №0 найдено 1 слов.
### В строке №1 найдено 0 слов.
### В строке №2 найдено 0 слов.
### В строке №3 найдено 0 слов.
### В строке №4 найдено 0 слов.
### В строке №5 найдено 0 слов.
### В строке №6 найдено 1 слов.
### В строке №7 найдено 0 слов.
### В строке №8 найдено 0 слов.
### В строке №9 найдено 0 слов.
### В строке №10 найдено 0 слов.
### В строке №11 найдено 0 слов.
### В строке №12 найдено 0 слов.
### В строке №13 найдено 1 слов.
### В строке №14 найдено 1 слов.
### В строке №15 найдено 1 слов.
### В строке №16 найдено 0 слов.
### В строке №17 найдено 1 слов.
### В строке №18 найдено 2 слов.
### В строке №19 найдено 0 слов.
### В строке №20 найдено 0 слов.
### В строке №21 найдено 0 слов.
### В строке №22 найдено 0 слов.
### В строке №23 найдено 0 слов.
### В строке №24 найдено 2 слов.
### В строке №25 найдено 0 слов.
### В строке №26 найдено 0 слов.
### В строке №27 найдено 0 слов.
### В строке №28 найдено 0 слов.
### В строке №29 найдено 1 слов.
### В строке №30 найдено 0 слов.
### В строке №31 найдено 2 слов.
### В строке №32 найдено 1 слов.
### В строке №33 найдено 1 слов.
### В строке №34 найдено 0 слов.
### В строке №35 найдено 0 слов.
### В строке №36 найдено 1 слов.
### В строке №37 найдено 1 слов.
### В строке №38 найдено 1 слов.
### В строке №39 найдено 0 слов.
### В строке №40 найдено 1 слов.
### В строке №41 найдено 1 слов.
### В строке №42 найдено 0 слов.
### В строке №43 найдено 1 слов.
### В строке №44 найдено 0 слов.
### В строке №45 найдено 2 слов.
### В строке №46 найдено 0 слов.
### В строке №47 найдено 0 слов.
### В строке №48 найдено 0 слов.
```

#### Задание №3
Используя рассмотренные в данной работе примеры 8 и 9, 
выполнить задание согласно условию в виде двух проектов:

- 1-й проект – работа с файлом с произвольным доступом;
- 2-й проект – работа через сериализацию.

*Условие*:

Записать в исходный файл информацию о фильмах:
- Название фильма;
- Год выпуска;
- Страна;
- Жанр;
- Стоимость проката.

Количество фильмов задать с клавиатуры.

Создать программным способом другой файл и переписать в него
информацию о фильмах, выпущенных в России.

---

*Реализация №1, через файл с произвольным доступом:*

Код класса `Main`:
```java
import java.io.*;
import java.util.Scanner;

/**
 * Через файл с произвольным доступом
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final int NAME_SIZE = 25, COUNTRY_SIZE = 15, GENRE_SIZE = 10;
        RandomAccessFile accessOutputFile = null;
        var scanner = new Scanner(System.in);
        var outputFile = new File("E:\\Output.txt");

        // Пересоздание файла Output.txt
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        System.out.print("Введите количество фильмов: ");
        var count = scanner.nextInt();
        scanner.nextLine();                         // Очистка буфера

        try {
            accessOutputFile = new RandomAccessFile(outputFile, "rw");

            // Запись
            for (int i = 0; i < count; i++) {
                String name, country, genre;
                double cost;
                int year;

                do {
                    System.out.print((i + 1) + ":\t Название фильма [< 25 символов]: ");
                    name = scanner.nextLine();
                } while (name.length() > NAME_SIZE);
                accessOutputFile.writeUTF(name);
                for (int j = 0; j < NAME_SIZE - name.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Год выпуска [>= 1895]: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                } while (year < 1895);
                accessOutputFile.writeInt(year);

                do {
                    System.out.print((i + 1) + ":\t Страна [< 15 символов]: ");
                    country = scanner.nextLine();
                } while (country.length() > COUNTRY_SIZE);
                accessOutputFile.writeUTF(country);
                for (int j = 0; j < COUNTRY_SIZE - country.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Жанр [< 10 символов]: ");
                    genre = scanner.nextLine();
                } while (genre.length() > GENRE_SIZE);
                accessOutputFile.writeUTF(genre);
                for (int j = 0; j < GENRE_SIZE - genre.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Стоимость [>= 0]: ");
                    cost = scanner.nextDouble();
                    scanner.nextLine();
                } while (cost < 0);
                accessOutputFile.writeDouble(cost);

                System.out.println();
            }

            // Проверка записанного
            var i = accessOutputFile.length() / (NAME_SIZE + 4 + COUNTRY_SIZE + GENRE_SIZE + 8 + 6);
            System.out.println("Количество записей в файле: " + i);

            accessOutputFile.seek(0);
            for (int j = 0; j < i; j++) {
                var name = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tНазвание фильма: " + name);
                accessOutputFile.skipBytes(NAME_SIZE - name.length());

                System.out.println((j + 1) + ":\tГод выпуска: " + accessOutputFile.readInt());

                var country = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tСтрана: " + country);
                accessOutputFile.skipBytes(COUNTRY_SIZE - country.length());

                var genre = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tЖанр: " + genre);
                accessOutputFile.skipBytes(GENRE_SIZE - genre.length());

                System.out.println((j + 1) + ":\tСтоимость: " + accessOutputFile.readDouble());

                System.out.println();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            // Закрытие потоков
            if (accessOutputFile != null) {
                accessOutputFile.close();
            }
        }
    }
}
```

Вывод программы:
```text
Введите количество фильмов: 2
1:	 Название фильма [< 25 символов]: Test Name
1:	 Год выпуска [>= 1895]: 1895
1:	 Страна [< 15 символов]: Country
1:	 Жанр [< 10 символов]: Genre
1:	 Стоимость [>= 0]: 0

2:	 Название фильма [< 25 символов]: Имя
2:	 Год выпуска [>= 1895]: 2022
2:	 Страна [< 15 символов]: Страна
2:	 Жанр [< 10 символов]: Жанр
2:	 Стоимость [>= 0]: 255

Количество записей в файле: 2
1:	Название фильма: Test Name
1:	Год выпуска: 1895
1:	Страна: Country
1:	Жанр: Genre
1:	Стоимость: 0.0

2:	Название фильма: Имя
2:	Год выпуска: 2022
2:	Страна: Страна
2:	Жанр: Жанр
2:	Стоимость: 255.0
```

---

*Реализация №2, через сериализацию:*

Код класса `Film`:
```java
import java.io.Serializable;

public class Film implements Serializable {
    /**
     * Название фильма
     */
    public String name;

    /**
     * Страна съёмки фильма
     */
    public String country;

    /**
     * Жанр фильма
     */
    public String genre;

    /**
     * Год выпуска
     */
    public int year;

    /**
     * Стоимость
     */
    public double cost;

    public Film(String name, int year, String country, String genre, double cost) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Film{\n\r" +
            "\tname = '" + name + "', \n\r" +
            "\tcountry = '" + country + "', \n\r" +
            "\tgenre = '" + genre + "', \n\r" +
            "\tyear = " + year + ", \n\r" +
            "\tcost = " + cost + "\n\r" +
            '}';
    }
}
```

Код класса `Main`:
```java

```

Вывод программы:
```text

```

## Вывод
В ходе лабораторной работы были получены навыки работы с текстовыми файлами, 
файлами произвольного доступа и с файлами для записи объектов. Были
изучены такие понятия как **сериализация** и **десериализация**.

В рамках лабораторной работы №12 было решено 3 задач на программирование в Java.
Листинг кода написанных программ был представлен в разделе *Ход работы*.
В результате лабораторной работы поставленная цель была выполнена, а поставленные
задачи достигнуты.