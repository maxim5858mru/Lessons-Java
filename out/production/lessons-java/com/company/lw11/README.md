# Отчёт по лабораторной работе №11 «Система ввода/вывода в Java. Работа с файлами через байтовые потоки»

***УрФУ ИРИТ-РФТ  
В рамках изучения дисциплины  
«Программирование на Java»  
Студента группы РИЗ-200016у  
Кулакова Максима Ивановича***

***Преподаватель Архипов Николай Александрович***

## Цель работы
Получение навыков работы с каталогами и файлами
операционной системы, а также с классами ввода/вывода, получение
навыков ввода/вывода данных файла через символьные потоки.

## Описание задачи
- Изучение справочного материала;
- Изучение функциональных возможностей следующих классов:
    - Классы пакета `java.io`;
    - Классов иерархии символьных потоков;
    - Класса `File`;
    - Класса `PrintWriter`;
- Решение задач по программированию на следующие темы:
    - Байтовый ввод/вывод данных;
    - Посимвольный ввод/вывод;
    - Буферизированный ввод/вывод данных текстового файла;
    - Преобразование байтовых потоков в символьные;
- Оформление отчёта по лабораторной работе.

## Ход работы
В ходе работы было решено 3 задачи по программированию. Листинг кода
представлен ниже.

#### Задание №1
В отдельных проектах выполнить примеры 1–10
лабораторной работы. Протестировать программы с помощью отладчика.
Выявить различие в работе программ в примерах 7 и 8.

Код класса `Case1`:
```java
import java.io.File;

/**
 * ПРИМЕР №1
 * Создание файлов и папок
 */
public class Case1 {
    public static void main(String[] args) {
        try {
            // Создание файла в текущей папке (где расположен файл Case1.java)
            File f1 = new File("File1.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь 1: " + f1.getAbsolutePath());
            }

            // Создание файла на диске E и вывод полного пути
            File f2 = new File("E:\\File2.txt");
            f2.createNewFile();
            System.out.println("Полный путь 2: " + f2.getAbsolutePath());

            // Создание нескольких вложенных папок
            File f3 = new File("E:\\Folder1\\Folder2\\Folder3");
            f3.mkdirs();
            System.out.println("Полный путь 3: " + f3.getAbsolutePath());

            f1.delete();
        } catch (Exception e) {
            System.err.println("Ошибка! " + e);
        }
    }
}
```

Код класса `Case2`:
```java
import java.io.*;
import java.net.URL;

/**
 * ПРИМЕР №2
 * Прочитать и вывести на экран информацию из трёх источников:
 *  - файла на диске;
 *  - интернет-страницы;
 *  - массива типа <code>byte</code>.
 */
public class Case2 {
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();        // Читает 1 байт
            if (oneByte != -1) {            // Признак отсутствия конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.println("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\FileOld.txt");
            readAllByByte(inFile);
            System.out.println("\n\n\n");
            inFile.close();

            // С потоком связана интернет-страница
            InputStream inUrl = new URL("https://google.com").openStream();
            readAllByByte(inUrl);
            System.out.println("\n\n\n");
            inUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{7, 9, 3, 7, 4});
            readAllByByte(inArray);
            System.out.println("\n\n\n");
            inArray.close();
        } catch (IOException exception) {
            System.err.println("Ошибка! " + exception);
        }
    }
}
```

Код класса `Case3`:
```java
import java.io.*;
import java.util.Arrays;

/**
 * ПРИМЕР №3
 * Прочитать и вывести на экран информацию из предварительно \
 * созданного файла с использованием буфера в 5 байт.
 */
public class Case3 {
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buffer = new byte[5];
        while (true) {
            int count = in.read(buffer);
            if (count != -1) {                      // Если не конец файла
                System.out.println("Количество = " + count +
                        ", buffer = " + Arrays.toString(buffer) +
                        ", str = " +
                        new String(buffer, 0, count, "cp1251"));
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "E:\\FileOld.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);
            readAllByArray(inFile);
        } catch (IOException exception) {
            System.err.println("Ошибка открытия-закрытия файла " + fileName + exception);
        } finally {
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {
                    /*NOP*/                         // NOP - No OPeration - ничего не делать
                }
            }
        }
    }
}
```

Код класса `Case4`:
```java
import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №4
 * Создать первый файл на диске и записать в него заданное количество
 * вещественных чисел. Далее создать второй файл и переписать в него
 * все числа из первого файла.
 */
public class Case4 {
    public static void main(String[] args) {
        try {
            // Создание исходного файла numIsh.txt и запись в него чисел типа float
            File f1 = new File("E:\\numIsh.txt");
            f1.createNewFile();
            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.print("Сколько вещественных чисел записать в файл? ");
            int count = sc.nextInt();

            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++) {
                wr.writeFloat(sc.nextFloat());
            }

            wr.flush();
            wr.close();

            // Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2 = new File("E:\\numRez.txt");
            f2.createNewFile();

            // Поток для чтения из исходного файла numIsh.txt
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));

            // Поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            try {
                while (true) {
                    float number = rd.readFloat();
                    wr.writeFloat(number);
                }
            } catch (EOFException e) {
            }
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.err.println("End of file");
        }
    }
}
```

Код класса `Case5`:
```java
import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №5
 * Создать файл на диске, ввести заданное с клавиатуры количество
 * строк текста и записать их в файл в формате UTF-8
 */
public class Case5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя файла => ");
        String fname = sc.nextLine();
        try {
            File f1 = new File(fname);
            f1.createNewFile();                 // Файл создан
            System.out.println("Полный путь файла: " + f1.getAbsolutePath());

            System.out.print("Введите количество строк для записи в файл => ");
            int n = sc.nextInt();

            /* Создаётся поток для записи с учётом типа данных - DataOutputStream,
               и ему в качестве параметра передаётся поток FileOutputStream
             */
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(f1));
            sc.nextLine();                      // Очистка буфера
            for (int i = 0; i < n; i++) {
                System.out.print("Введите строку для записи в файл => ");
                String s = sc.nextLine();

                dOut.writeUTF(s);
            }
            dOut.flush();                       // Дописываем несохранённые данные на диск
            dOut.close();                       // Закрываем поток

            // Чтение и вывод данных из созданного файла
            DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
            while (true) {
                System.out.println(dIn.readUTF());
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}
```

Код класса `Case6`:
```java
import java.io.*;

/**
 * ПРИМЕР №6
 * Чтение из одного файла и запись в другой файл данных посимвольно.
 */
public class Case6 {
    public static void main(String[] args) throws IOException {
        Reader in = null;
        Writer out = null;
        try {
            in = new FileReader("E:\\FileOld.txt");    // Файл для чтения
            out = new FileWriter("E:\\FileNew.txt");   // Файл для записи

            // Данные считываются и записываются побайтно, как и для InputStream/OutputStream
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                // out.write((char) oneByte);           // Запись с уничтожением существующих данных
                out.append((char) oneByte);
            }
        } catch (IOException exception) {
            System.err.println("Ошибка!");
        } finally {
            in.close();
            out.close();
        }
    }
}
```

Код класса `Case7`:
```java
import java.io.*;

/**
 * ПРИМЕР №7
 * Чтение из одного файла и запись в другой файл данных
 * построчно с использованием буфера в 1 килобайт.
 */
public class Case7 {
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

Код класса `Case8`:
```java
import java.io.*;
import java.net.URL;

/**
 * ПРИМЕР №8
 * Прочитать и вывести на экран информацию из трёх источников: файла
 * на диске, интернет-страницы и массива данных типа byte. Указать кодировку,
 * поддерживающую кириллицу.
 */
public class Case8 {
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
            Reader rArray = new InputStreamReader(inArray, "cp1251");  // Символьный поток
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

Код класса `Case9`:
```java
import java.io.*;

/**
 * ПРИМЕР №9
 * Чтение из одного файла и запись в другой файл данных 
 * построчно с использованием буферизации символьных потоков основанных на 
 * байтовых файловых потоках.
 */
public class Case9 {
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
                bw.write(lineCount + ": " + s); // Запись без перевода строки
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

Код класса `Case10`:
```java
import java.io.*;

/**
 * ПРИМЕР №10
 * Выполнить чтение из одного файла и запись в другой 
 * файл с использованием класса PrintWriter
 */
public class Case10 {
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

Код класса `Main`:
```java
import java.io.IOException;

@FunctionalInterface
interface CaseInterface {
    void main(String[] args);
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        com.company.lw11.example1.CaseInterface[] cases = new com.company.lw11.example1.CaseInterface[]{
            str -> Case1.main(str),
            str -> Case2.main(str),
            str -> {
                try {
                    Case3.main(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            },
            str -> Case4.main(str),
            str -> Case5.main(str),
            str -> {
                try {
                    Case6.main(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            },
            str -> {
                 try {
                     Case7.main(str);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
            },
            str -> Case8.main(str),
            str -> {
                 try {
                     Case9.main(str);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
            },
            str -> {
                 try {
                     Case10.main(str);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
            }
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
First line.
Second line.
end




<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ru"><head><meta content="&#1055;&#1086;&#1080;&#1089;&#1082; &#1080;&#1085;&#1092;&#1086;&#1088;&#1084;&#1072;&#1094;&#1080;&#1080; &#1074; &#1080;&#1085;&#1090;&#1077;&#1088;&#1085;&#1077;&#1090;&#1077;: &#1074;&#1077;&#1073; &#1089;&#1090;&#1088;&#1072;&#1085;&#1080;&#1094;&#1099;, &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;, &#1074;&#1080;&#1076;&#1077;&#1086; &#1080; &#1084;&#1085;&#1086;&#1075;&#1086;&#1077; &#1076;&#1088;&#1091;&#1075;&#1086;&#1077;." name="description"><meta content="noodp" name="robots"><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){window.google={kEI:'6C6DYuyTBpmPxc8Pn_SY8Ac',kEXPI:'0,1302536,56873,6058,207,2415,2389,925,1391,383,246,5,1354,4013,1238,1122515,1197733,158,510,380090,16114,19398,9286,17572,4858,1362,9291,3021,4752,12835,4998,13228,3847,4192,6430,7432,7330,7979,2855,2226,1593,1279,2451,291,149,1103,840,6297,4120,2023,2297,14670,3227,2845,7,4808,12642,7540,4085,4143,552,1851,15756,3,346,230,6459,149,13975,4,1528,656,1648,6462,577,25073,2658,7357,18095,16786,652,5121,2584,4094,4052,3,3541,1,42154,2,14022,1931,12185,11623,5679,1021,2378,2721,18278,2,6,7736,4569,6255,6726,14077,2618,830,422,5835,14968,1554,2778,6089,1395,445,2,2,1,10789,10658,2079,1004,96,153,1416,1,436,8155,6582,799,1479,1564,11637,7341,2650,568,203,2,6,11028,1927,770,265,843,1398,1341,1086,919,918,1629,610,24,880,5638,345,544,155,393,186,1666,4545,1138,210,1495,420,1491,1724,3800,3056,1429,419,201,742,2581,529,1241,418,3,852,14,2,108,1298,133,1944,500,1026,100,480,466,69,305,196,986,1496,55,1395,89,1434,758,3,5415790,1861,3227,70,3,157,8796585,1326,3,1877,1,2562,1,748,141,795,6164,6751,155,17,13,72,139,4,2,20,2,169,13,19,46,5,39,644,29,2,2,1,2,1,2,2,7,4,1,2,2,2,2,2,2,1052,1,1,158,3,2,2,2,2,2,4,2,3,3,2011,1002,312,615,3,3,3,1,1,1,1,206,1,1,81,26,19,20,8,41,38,17,30,1,8,27,20730494,2920213,299808,2862026,1180116,1964,1007,1928,159,1358,965,5937,4079,1239,3406,305,2,412,2575,927357',kBL:'0ZR5'};google.sn='webhp';google.kHL='ru';})();(function(){
var f=this||self;var h,k=[];function l(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||h}function m(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b}
function n(a,b,c,d,g){var e="";c||-1!==b.search("&ei=")||(e="&ei="+l(d),-1===b.search("&lei=")&&(d=m(d))&&(e+="&lei="+d));d="";!c&&f._cshid&&-1===b.search("&cshid=")&&"slh"!==a&&(d="&cshid="+f._cshid);c=c||"/"+(g||"gen_204")+"?atyp=i&ct="+a+"&cad="+b+e+"&zx="+Date.now()+d;/^http:/i.test(c)&&"https:"===window.location.protocol&&(google.ml&&google.ml(Error("a"),!1,{src:c,glmm:1}),c="");return c};h=google.kEI;google.getEI=l;google.getLEI=m;google.ml=function(){return null};google.log=function(a,b,c,d,g){if(c=n(a,b,c,d,g)){a=new Image;var e=k.length;k[e]=a;a.onerror=a.onload=a.onabort=function(){delete k[e]};a.src=c}};google.logUrl=n;}).call(this);(function(){
google.y={};google.sy=[];google.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1};google.sx=function(a){google.sy.push(a)};google.lm=[];google.plm=function(a){google.lm.push.apply(google.lm,a)};google.lq=[];google.load=function(a,b,c){google.lq.push([[a],b,c])};google.loadAll=function(a,b){google.lq.push([a,b])};google.bx=!1;google.lx=function(){};}).call(this);google.f={};(function(){
document.documentElement.addEventListener("submit",function(b){var a;if(a=b.target){var c=a.getAttribute("data-submitfalse");a="1"===c||"q"===c&&!a.elements.q.value?!0:!1}else a=!1;a&&(b.preventDefault(),b.stopPropagation())},!0);document.documentElement.addEventListener("click",function(b){var a;a:{for(a=b.target;a&&a!==document.documentElement;a=a.parentElement)if("A"===a.tagName){a="1"===a.getAttribute("data-nohref");break a}a=!1}a&&b.preventDefault()},!0);}).call(this);</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
</style><style>body,td,a,p,.h{font-family:arial,sans-serif}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#1558d6}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}body{background:#fff;color:#000}a{color:#4b11a8;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#1558d6}a:visited{color:#4b11a8}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#f8f9fa;border:solid 1px;border-color:#dadce0 #70757a #70757a #dadce0;height:30px}.lsbb{display:block}#WqQANb a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#dadce0}.lst:focus{outline:none}.tiah{width:458px}</style><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){window.google.erd={jsr:1,bv:1581,de:true};
var f=this||self;var g,h=null!=(g=f.mei)?g:1,m,n=null!=(m=f.sdo)?m:!0,p=0,q,r=google.erd,u=r.jsr;google.ml=function(a,b,d,k,c){c=void 0===c?2:c;b&&(q=a&&a.message);if(google.dl)return google.dl(a,c,d),null;if(0>u){window.console&&console.error(a,d);if(-2===u)throw a;b=!1}else b=!a||!a.message||"Error loading script"===a.message||p>=h&&!k?!1:!0;if(!b)return null;p++;d=d||{};var e=c;c=encodeURIComponent;b="/gen_204?atyp=i&ei="+c(google.kEI);google.kEXPI&&(b+="&jexpid="+c(google.kEXPI));b+="&srcpg="+c(google.sn)+"&jsr="+c(r.jsr)+"&bver="+c(r.bv)+("&jsel="+e);e=a.lineNumber;void 0!==e&&(b+="&line="+
e);var l=a.fileName;l&&(b+="&script="+c(l),e&&l===window.location.href&&(e=document.documentElement.outerHTML.split("\n")[e],b+="&cad="+c(e?e.substring(0,300):"No script found.")));for(var t in d)b+="&",b+=c(t),b+="=",b+=c(d[t]);b=b+"&emsg="+c(a.name+": "+a.message);b=b+"&jsst="+c(a.stack||"N/A");12288<=b.length&&(b=b.substr(0,12288));a=b;k||google.log(0,"",a);return a};window.onerror=function(a,b,d,k,c){q!==a&&(a=c instanceof Error?c:Error(a),void 0===d||"lineNumber"in a||(a.lineNumber=d),void 0===b||"fileName"in a||(a.fileName=b),google.ml(a,!1,void 0,!1,"SyntaxError"===a.name||"SyntaxError"===a.message.substring(0,11)?2:0));q=null;n&&p>=h&&(window.onerror=null)};})();</script></head><body bgcolor="#fff"><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
}
})();</script><div id="mngb"><div id=gbar><nobr><b class=gb1>&#1055;&#1086;&#1080;&#1089;&#1082;</b> <a class=gb1 href="https://www.google.ru/imghp?hl=ru&tab=wi">&#1050;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;</a> <a class=gb1 href="https://maps.google.ru/maps?hl=ru&tab=wl">&#1050;&#1072;&#1088;&#1090;&#1099;</a> <a class=gb1 href="https://play.google.com/?hl=ru&tab=w8">Play</a> <a class=gb1 href="https://www.youtube.com/?gl=RU&tab=w1">YouTube</a> <a class=gb1 href="https://news.google.com/?tab=wn">&#1053;&#1086;&#1074;&#1086;&#1089;&#1090;&#1080;</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">&#1055;&#1086;&#1095;&#1090;&#1072;</a> <a class=gb1 href="https://drive.google.com/?tab=wo">&#1044;&#1080;&#1089;&#1082;</a> <a class=gb1 style="text-decoration:none" href="https://www.google.ru/intl/ru/about/products?tab=wh"><u>&#1045;&#1097;&#1105;</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.ru/history/optout?hl=ru" class=gb4>&#1048;&#1089;&#1090;&#1086;&#1088;&#1080;&#1103; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;</a> | <a  href="/preferences?hl=ru" class=gb4>&#1053;&#1072;&#1089;&#1090;&#1088;&#1086;&#1081;&#1082;&#1080;</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=ru&passive=true&continue=https://www.google.com/&ec=GAZAAQ" class=gb4>&#1042;&#1086;&#1081;&#1090;&#1080;</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div></div><center><br clear="all" id="lgpd"><div id="lga"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="ru" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input class="lst tiah" style="margin:0;padding:5px 8px 0 6px;vertical-align:top;color:#000;padding-right:38px" autocomplete="off" value="" title="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" maxlength="2048" name="q" size="57"><img src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" data-script-url="/textinputassistant/11/ru_tia.js" id="tsuid1" alt="" height="23" width="27"><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){var id='tsuid1';document.getElementById(id).onclick = function(){var s = document.createElement('script');s.src = this.getAttribute('data-script-url');(document.getElementById('xjsc')||document.body).appendChild(s);};})();</script></div></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" id="tsuid2" value="&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!" name="btnI" type="submit"><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){var id='tsuid2';document.getElementById(id).onclick = function(){if (this.form.q.value){this.checked = 1;if (this.form.iflsig)this.form.iflsig.disabled = false;}
else top.location='/doodles/';};})();</script><input value="AJiK0e8AAAAAYoM8-JnznkW-QPZLr-j5ISMUJBWEdHqj" name="iflsig" type="hidden"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=ru&amp;authuser=0">&#1056;&#1072;&#1089;&#1096;&#1080;&#1088;&#1077;&#1085;&#1085;&#1099;&#1081; &#1087;&#1086;&#1080;&#1089;&#1082;</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){
var a,b="1";if(document&&document.getElementById)if("undefined"!=typeof XMLHttpRequest)b="2";else if("undefined"!=typeof ActiveXObject){var c,d,e=["MSXML2.XMLHTTP.6.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP","Microsoft.XMLHTTP"];for(c=0;d=e[c++];)try{new ActiveXObject(d),b="2"}catch(h){}}a=b;if("2"==a&&-1==location.search.indexOf("&gbv=2")){var f=google.gbvu,g=document.getElementById("gbv");g&&(g.value=a);f&&window.setTimeout(function(){location.href=f},0)};}).call(this);</script></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="WqQANb"><a href="http://www.google.ru/intl/ru/services/">&#1056;&#1077;&#1096;&#1077;&#1085;&#1080;&#1103; &#1076;&#1083;&#1103; &#1073;&#1080;&#1079;&#1085;&#1077;&#1089;&#1072;</a><a href="/intl/ru/about.html">&#1042;&#1089;&#1105; &#1086; Google</a><a href="https://www.google.com/setprefdomain?prefdom=RU&amp;prev=https://www.google.ru/&amp;sig=K_DMrE0zvHYVLnAqFSHrCExmIgo3U%3D">Google.ru</a></div></div><p style="font-size:8pt;color:#70757a">&copy; 2022 - <a href="/intl/ru/policies/privacy/">&#1050;&#1086;&#1085;&#1092;&#1080;&#1076;&#1077;&#1085;&#1094;&#1080;&#1072;&#1083;&#1100;&#1085;&#1086;&#1089;&#1090;&#1100;</a> - <a href="/intl/ru/policies/terms/">&#1059;&#1089;&#1083;&#1086;&#1074;&#1080;&#1103;</a></p></span></center><script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){window.google.cdo={height:757,width:1440};(function(){
var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d="CSS1Compat"==c.compatMode?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}a&&b&&(a!=google.cdo.width||b!=google.cdo.height)&&google.log("","","/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI);}).call(this);})();</script> <script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){google.xjs={ck:'',cs:'',excm:[]};})();</script>  <script nonce="CHF95uM8G6GBBb2yvxob8w">(function(){var u='/xjs/_/js/k\x3dxjs.hp.en.YQKuS9PAKYQ.O/am\x3dAOAJAEACkA/d\x3d1/ed\x3d1/esmo\x3d1/rs\x3dACT90oFq13VtUuQ0kNOQVfYXwhb7_MQf5Q/m\x3dsb_he,d';
var d=this||self,e=function(a){return a};var g;var l=function(a,b){this.g=b===h?a:""};l.prototype.toString=function(){return this.g+""};var h={};
function n(){var a=u;google.lx=function(){p(a);google.lx=function(){}};google.bx||google.lx()}
function p(a){google.timers&&google.timers.load&&google.tick&&google.tick("load","xjsls");var b=document;var c="SCRIPT";"application/xhtml+xml"===b.contentType&&(c=c.toLowerCase());c=b.createElement(c);if(void 0===g){b=null;var k=d.trustedTypes;if(k&&k.createPolicy){try{b=k.createPolicy("goog#html",{createHTML:e,createScript:e,createScriptURL:e})}catch(q){d.console&&d.console.error(q.message)}g=b}else g=b}a=(b=g)?b.createScriptURL(a):a;a=new l(a,h);c.src=a instanceof l&&a.constructor===l?a.g:"type_error:TrustedResourceUrl";var f,m;(f=(a=null==(m=(f=(c.ownerDocument&&c.ownerDocument.defaultView||window).document).querySelector)?void 0:m.call(f,"script[nonce]"))?a.nonce||a.getAttribute("nonce")||"":"")&&c.setAttribute("nonce",f);document.body.appendChild(c);google.psa=!0};google.xjsu=u;setTimeout(function(){n()},0);})();function _DumpException(e){throw e;}
function _F_installCss(c){}
(function(){google.jl={attn:false,blt:'none',chnk:0,dw:false,dwu:true,emtn:0,end:0,ine:false,injs:'none',injt:0,lls:'default',pdt:0,rep:0,snet:true,strt:0,ubm:false,uwp:true};})();(function(){var pmc='{\x22d\x22:{},\x22sb_he\x22:{\x22agen\x22:true,\x22cgen\x22:true,\x22client\x22:\x22heirloom-hp\x22,\x22dh\x22:true,\x22dhqt\x22:true,\x22ds\x22:\x22\x22,\x22ffql\x22:\x22ru\x22,\x22fl\x22:true,\x22host\x22:\x22google.com\x22,\x22isbh\x22:28,\x22jsonp\x22:true,\x22msgs\x22:{\x22cibl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100; &#1087;&#1086;&#1080;&#1089;&#1082;&#1086;&#1074;&#1099;&#1081; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;\x22,\x22dym\x22:\x22&#1042;&#1086;&#1079;&#1084;&#1086;&#1078;&#1085;&#1086;, &#1074;&#1099; &#1080;&#1084;&#1077;&#1083;&#1080; &#1074; &#1074;&#1080;&#1076;&#1091;:\x22,\x22lcky\x22:\x22&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!\x22,\x22lml\x22:\x22&#1055;&#1086;&#1076;&#1088;&#1086;&#1073;&#1085;&#1077;&#1077;...\x22,\x22oskt\x22:\x22&#1069;&#1082;&#1088;&#1072;&#1085;&#1085;&#1072;&#1103; &#1082;&#1083;&#1072;&#1074;&#1080;&#1072;&#1090;&#1091;&#1088;&#1072;\x22,\x22psrc\x22:\x22&#1069;&#1090;&#1086;&#1090; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089; &#1073;&#1099;&#1083; &#1091;&#1076;&#1072;&#1083;&#1077;&#1085; &#1080;&#1079; &#1074;&#1072;&#1096;&#1077;&#1081; \\u003Ca href\x3d\\\x22/history\\\x22\\u003E&#1080;&#1089;&#1090;&#1086;&#1088;&#1080;&#1080; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;\\u003C/a\\u003E\x22,\x22psrl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100;\x22,\x22sbit\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1087;&#1086; &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1077;\x22,\x22srch\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google\x22},\x22ovr\x22:{},\x22pq\x22:\x22\x22,\x22refpd\x22:true,\x22rfs\x22:[],\x22sbas\x22:\x220 3px 8px 0 rgba(0,0,0,0.2),0 0 0 1px rgba(0,0,0,0.08)\x22,\x22sbpl\x22:16,\x22sbpr\x22:16,\x22scd\x22:10,\x22stok\x22:\x22j6WUlaQJB0MDD6_f2n-vWkXIEUA\x22,\x22uhde\x22:false}}';google.pmc=JSON.parse(pmc);})();</script>        </body></html>
end




	
end





Пример №2
Количество = 5, buffer = [70, 105, 114, 115, 116], str = First
Количество = 5, buffer = [32, 108, 105, 110, 101], str =  line
Количество = 5, buffer = [46, 13, 10, 83, 101], str = .
Se
Количество = 5, buffer = [99, 111, 110, 100, 32], str = cond 
Количество = 5, buffer = [108, 105, 110, 101, 46], str = line.

Пример №3
Сколько вещественных чисел записать в файл? 5
Введите числа:
154
2458
2415
253
45

Пример №4
Введите имя файла => E:\FileNew.txt
Полный путь файла: E:\FileNew.txt
Введите количество строк для записи в файл => 3
Введите строку для записи в файл => First line
Введите строку для записи в файл => Second line
Введите строку для записи в файл => Third line
First line
Second line
Third line

Пример №5

Пример №6
1: First line.
2: Second line.

Пример №7
First line.
Second line.
 конец 


java.io.EOFException
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ru"><head><meta content="&#1055;&#1086;&#1080;&#1089;&#1082; &#1080;&#1085;&#1092;&#1086;&#1088;&#1084;&#1072;&#1094;&#1080;&#1080; &#1074; &#1080;&#1085;&#1090;&#1077;&#1088;&#1085;&#1077;&#1090;&#1077;: &#1074;&#1077;&#1073; &#1089;&#1090;&#1088;&#1072;&#1085;&#1080;&#1094;&#1099;, &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;, &#1074;&#1080;&#1076;&#1077;&#1086; &#1080; &#1084;&#1085;&#1086;&#1075;&#1086;&#1077; &#1076;&#1088;&#1091;&#1075;&#1086;&#1077;." name="description"><meta content="noodp" name="robots"><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){window.google={kEI:'GC-DYtbKJtCOxc8P5b6S-Aw',kEXPI:'0,1302536,56873,6059,206,4804,2316,383,246,5,1354,4013,1238,1122515,1197725,317335,63431,16114,17444,11240,17572,4859,1361,9291,3029,17579,4998,13228,3847,10622,22741,1832,3249,1593,1279,2742,149,1103,840,2197,4100,3514,606,2025,1775,520,14670,3227,1990,855,7,5599,11851,11625,4695,1850,15757,3,346,230,4386,2073,149,13975,4,1528,2304,7039,25073,2658,7357,13658,4437,16786,5821,2536,4094,4052,3,3541,1,42154,2,14022,1931,4318,7867,11623,5679,1020,2381,2719,18242,2,6,7772,4569,6255,3011,3,3706,14083,2619,1245,5841,14968,1554,2778,5016,1073,1395,445,2,2,1,17306,6519,705,248,1417,1,1899,6586,106,2566,4016,799,1479,1564,858,7872,2907,7341,3217,204,2,6,1191,11764,773,262,846,1305,90,1341,992,521,492,918,1651,588,24,880,2317,3667,698,580,1662,1109,373,4204,209,1490,3642,924,1108,1764,4488,419,201,3000,70,252,531,1240,418,3,213,653,2,54,379,426,547,133,4050,535,501,1323,1159,55,97,1297,90,1095,1212,967,5414698,5101,71,104,56,8796584,1326,3,1877,1,2562,1,889,795,2,6162,6751,155,17,13,72,139,4,2,20,2,169,13,19,46,5,39,644,29,2,2,1,2,1,2,2,7,4,1,2,2,2,2,2,2,1052,1,1,158,3,2,2,2,2,2,4,2,3,3,2011,1002,312,615,3,3,3,1,1,1,1,206,1,1,81,5,4,26,15,15,8,41,38,17,30,1,8,27,20730495,2920212,299807,2738464,1303679,4899,159,1358,6902,2944,2374,2555,851,305,930346,6249',kBL:'0ZR5'};google.sn='webhp';google.kHL='ru';})();(function(){
var f=this||self;var h,k=[];function l(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||h}function m(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b}
function n(a,b,c,d,g){var e="";c||-1!==b.search("&ei=")||(e="&ei="+l(d),-1===b.search("&lei=")&&(d=m(d))&&(e+="&lei="+d));d="";!c&&f._cshid&&-1===b.search("&cshid=")&&"slh"!==a&&(d="&cshid="+f._cshid);c=c||"/"+(g||"gen_204")+"?atyp=i&ct="+a+"&cad="+b+e+"&zx="+Date.now()+d;/^http:/i.test(c)&&"https:"===window.location.protocol&&(google.ml&&google.ml(Error("a"),!1,{src:c,glmm:1}),c="");return c};h=google.kEI;google.getEI=l;google.getLEI=m;google.ml=function(){return null};google.log=function(a,b,c,d,g){if(c=n(a,b,c,d,g)){a=new Image;var e=k.length;k[e]=a;a.onerror=a.onload=a.onabort=function(){delete k[e]};a.src=c}};google.logUrl=n;}).call(this);(function(){
google.y={};google.sy=[];google.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1};google.sx=function(a){google.sy.push(a)};google.lm=[];google.plm=function(a){google.lm.push.apply(google.lm,a)};google.lq=[];google.load=function(a,b,c){google.lq.push([[a],b,c])};google.loadAll=function(a,b){google.lq.push([a,b])};google.bx=!1;google.lx=function(){};}).call(this);google.f={};(function(){
document.documentElement.addEventListener("submit",function(b){var a;if(a=b.target){var c=a.getAttribute("data-submitfalse");a="1"===c||"q"===c&&!a.elements.q.value?!0:!1}else a=!1;a&&(b.preventDefault(),b.stopPropagation())},!0);document.documentElement.addEventListener("click",function(b){var a;a:{for(a=b.target;a&&a!==document.documentElement;a=a.parentElement)if("A"===a.tagName){a="1"===a.getAttribute("data-nohref");break a}a=!1}a&&b.preventDefault()},!0);}).call(this);</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
</style><style>body,td,a,p,.h{font-family:arial,sans-serif}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#1558d6}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}body{background:#fff;color:#000}a{color:#4b11a8;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#1558d6}a:visited{color:#4b11a8}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#f8f9fa;border:solid 1px;border-color:#dadce0 #70757a #70757a #dadce0;height:30px}.lsbb{display:block}#WqQANb a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#dadce0}.lst:focus{outline:none}.tiah{width:458px}</style><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){window.google.erd={jsr:1,bv:1581,de:true};
var f=this||self;var g,h=null!=(g=f.mei)?g:1,m,n=null!=(m=f.sdo)?m:!0,p=0,q,r=google.erd,u=r.jsr;google.ml=function(a,b,d,k,c){c=void 0===c?2:c;b&&(q=a&&a.message);if(google.dl)return google.dl(a,c,d),null;if(0>u){window.console&&console.error(a,d);if(-2===u)throw a;b=!1}else b=!a||!a.message||"Error loading script"===a.message||p>=h&&!k?!1:!0;if(!b)return null;p++;d=d||{};var e=c;c=encodeURIComponent;b="/gen_204?atyp=i&ei="+c(google.kEI);google.kEXPI&&(b+="&jexpid="+c(google.kEXPI));b+="&srcpg="+c(google.sn)+"&jsr="+c(r.jsr)+"&bver="+c(r.bv)+("&jsel="+e);e=a.lineNumber;void 0!==e&&(b+="&line="+
e);var l=a.fileName;l&&(b+="&script="+c(l),e&&l===window.location.href&&(e=document.documentElement.outerHTML.split("\n")[e],b+="&cad="+c(e?e.substring(0,300):"No script found.")));for(var t in d)b+="&",b+=c(t),b+="=",b+=c(d[t]);b=b+"&emsg="+c(a.name+": "+a.message);b=b+"&jsst="+c(a.stack||"N/A");12288<=b.length&&(b=b.substr(0,12288));a=b;k||google.log(0,"",a);return a};window.onerror=function(a,b,d,k,c){q!==a&&(a=c instanceof Error?c:Error(a),void 0===d||"lineNumber"in a||(a.lineNumber=d),void 0===b||"fileName"in a||(a.fileName=b),google.ml(a,!1,void 0,!1,"SyntaxError"===a.name||"SyntaxError"===a.message.substring(0,11)?2:0));q=null;n&&p>=h&&(window.onerror=null)};})();</script></head><body bgcolor="#fff"><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
}
})();</script><div id="mngb"><div id=gbar><nobr><b class=gb1>&#1055;&#1086;&#1080;&#1089;&#1082;</b> <a class=gb1 href="https://www.google.ru/imghp?hl=ru&tab=wi">&#1050;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1080;</a> <a class=gb1 href="https://maps.google.ru/maps?hl=ru&tab=wl">&#1050;&#1072;&#1088;&#1090;&#1099;</a> <a class=gb1 href="https://play.google.com/?hl=ru&tab=w8">Play</a> <a class=gb1 href="https://www.youtube.com/?gl=RU&tab=w1">YouTube</a> <a class=gb1 href="https://news.google.com/?tab=wn">&#1053;&#1086;&#1074;&#1086;&#1089;&#1090;&#1080;</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">&#1055;&#1086;&#1095;&#1090;&#1072;</a> <a class=gb1 href="https://drive.google.com/?tab=wo">&#1044;&#1080;&#1089;&#1082;</a> <a class=gb1 style="text-decoration:none" href="https://www.google.ru/intl/ru/about/products?tab=wh"><u>&#1045;&#1097;&#1105;</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.ru/history/optout?hl=ru" class=gb4>&#1048;&#1089;&#1090;&#1086;&#1088;&#1080;&#1103; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;</a> | <a  href="/preferences?hl=ru" class=gb4>&#1053;&#1072;&#1089;&#1090;&#1088;&#1086;&#1081;&#1082;&#1080;</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=ru&passive=true&continue=https://www.google.com/&ec=GAZAAQ" class=gb4>&#1042;&#1086;&#1081;&#1090;&#1080;</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div></div><center><br clear="all" id="lgpd"><div id="lga"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="ru" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input class="lst tiah" style="margin:0;padding:5px 8px 0 6px;vertical-align:top;color:#000;padding-right:38px" autocomplete="off" value="" title="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" maxlength="2048" name="q" size="57"><img src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" data-script-url="/textinputassistant/11/ru_tia.js" id="tsuid1" alt="" height="23" width="27"><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){var id='tsuid1';document.getElementById(id).onclick = function(){var s = document.createElement('script');s.src = this.getAttribute('data-script-url');(document.getElementById('xjsc')||document.body).appendChild(s);};})();</script></div></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" id="tsuid2" value="&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!" name="btnI" type="submit"><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){var id='tsuid2';document.getElementById(id).onclick = function(){if (this.form.q.value){this.checked = 1;if (this.form.iflsig)this.form.iflsig.disabled = false;}
else top.location='/doodles/';};})();</script><input value="AJiK0e8AAAAAYoM9KHiplStrtUpttJSmXzMBIQo05HjI" name="iflsig" type="hidden"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=ru&amp;authuser=0">&#1056;&#1072;&#1089;&#1096;&#1080;&#1088;&#1077;&#1085;&#1085;&#1099;&#1081; &#1087;&#1086;&#1080;&#1089;&#1082;</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){
var a,b="1";if(document&&document.getElementById)if("undefined"!=typeof XMLHttpRequest)b="2";else if("undefined"!=typeof ActiveXObject){var c,d,e=["MSXML2.XMLHTTP.6.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP","Microsoft.XMLHTTP"];for(c=0;d=e[c++];)try{new ActiveXObject(d),b="2"}catch(h){}}a=b;if("2"==a&&-1==location.search.indexOf("&gbv=2")){var f=google.gbvu,g=document.getElementById("gbv");g&&(g.value=a);f&&window.setTimeout(function(){location.href=f},0)};}).call(this);</script></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="WqQANb"><a href="http://www.google.ru/intl/ru/services/">&#1056;&#1077;&#1096;&#1077;&#1085;&#1080;&#1103; &#1076;&#1083;&#1103; &#1073;&#1080;&#1079;&#1085;&#1077;&#1089;&#1072;</a><a href="/intl/ru/about.html">&#1042;&#1089;&#1105; &#1086; Google</a><a href="https://www.google.com/setprefdomain?prefdom=RU&amp;prev=https://www.google.ru/&amp;sig=K_LfyjXXwBaddXQeXSCWEMLjyf5t8%3D">Google.ru</a></div></div><p style="font-size:8pt;color:#70757a">&copy; 2022 - <a href="/intl/ru/policies/privacy/">&#1050;&#1086;&#1085;&#1092;&#1080;&#1076;&#1077;&#1085;&#1094;&#1080;&#1072;&#1083;&#1100;&#1085;&#1086;&#1089;&#1090;&#1100;</a> - <a href="/intl/ru/policies/terms/">&#1059;&#1089;&#1083;&#1086;&#1074;&#1080;&#1103;</a></p></span></center><script nonce="0768llc7eUQHhx1PLzYYEA">(function(){window.google.cdo={height:757,width:1440};(function(){
var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d="CSS1Compat"==c.compatMode?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}a&&b&&(a!=google.cdo.width||b!=google.cdo.height)&&google.log("","","/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI);}).call(this);})();</script> <script nonce="0768llc7eUQHhx1PLzYYEA">(function(){google.xjs={ck:'',cs:'',excm:[]};})();</script>  <script nonce="0768llc7eUQHhx1PLzYYEA">(function(){var u='/xjs/_/js/k\x3dxjs.hp.en.YQKuS9PAKYQ.O/am\x3dAOAJAEACkA/d\x3d1/ed\x3d1/esmo\x3d1/rs\x3dACT90oFq13VtUuQ0kNOQVfYXwhb7_MQf5Q/m\x3dsb_he,d';
var d=this||self,e=function(a){return a};var g;var l=function(a,b){this.g=b===h?a:""};l.prototype.toString=function(){return this.g+""};var h={};
function n(){var a=u;google.lx=function(){p(a);google.lx=function(){}};google.bx||google.lx()}
function p(a){google.timers&&google.timers.load&&google.tick&&google.tick("load","xjsls");var b=document;var c="SCRIPT";"application/xhtml+xml"===b.contentType&&(c=c.toLowerCase());c=b.createElement(c);if(void 0===g){b=null;var k=d.trustedTypes;if(k&&k.createPolicy){try{b=k.createPolicy("goog#html",{createHTML:e,createScript:e,createScriptURL:e})}catch(q){d.console&&d.console.error(q.message)}g=b}else g=b}a=(b=g)?b.createScriptURL(a):a;a=new l(a,h);c.src=a instanceof l&&a.constructor===l?a.g:"type_error:TrustedResourceUrl";var f,m;(f=(a=null==(m=(f=(c.ownerDocument&&c.ownerDocument.defaultView||window).document).querySelector)?void 0:m.call(f,"script[nonce]"))?a.nonce||a.getAttribute("nonce")||"":"")&&c.setAttribute("nonce",f);document.body.appendChild(c);google.psa=!0};google.xjsu=u;setTimeout(function(){n()},0);})();function _DumpException(e){throw e;}
function _F_installCss(c){}
(function(){google.jl={attn:false,blt:'none',chnk:0,dw:false,dwu:true,emtn:0,end:0,ine:false,injs:'none',injt:0,lls:'default',pdt:0,rep:0,snet:true,strt:0,ubm:false,uwp:true};})();(function(){var pmc='{\x22d\x22:{},\x22sb_he\x22:{\x22agen\x22:true,\x22cgen\x22:true,\x22client\x22:\x22heirloom-hp\x22,\x22dh\x22:true,\x22dhqt\x22:true,\x22ds\x22:\x22\x22,\x22ffql\x22:\x22ru\x22,\x22fl\x22:true,\x22host\x22:\x22google.com\x22,\x22isbh\x22:28,\x22jsonp\x22:true,\x22msgs\x22:{\x22cibl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100; &#1087;&#1086;&#1080;&#1089;&#1082;&#1086;&#1074;&#1099;&#1081; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;\x22,\x22dym\x22:\x22&#1042;&#1086;&#1079;&#1084;&#1086;&#1078;&#1085;&#1086;, &#1074;&#1099; &#1080;&#1084;&#1077;&#1083;&#1080; &#1074; &#1074;&#1080;&#1076;&#1091;:\x22,\x22lcky\x22:\x22&#1052;&#1085;&#1077; &#1087;&#1086;&#1074;&#1077;&#1079;&#1105;&#1090;!\x22,\x22lml\x22:\x22&#1055;&#1086;&#1076;&#1088;&#1086;&#1073;&#1085;&#1077;&#1077;...\x22,\x22oskt\x22:\x22&#1069;&#1082;&#1088;&#1072;&#1085;&#1085;&#1072;&#1103; &#1082;&#1083;&#1072;&#1074;&#1080;&#1072;&#1090;&#1091;&#1088;&#1072;\x22,\x22psrc\x22:\x22&#1069;&#1090;&#1086;&#1090; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089; &#1073;&#1099;&#1083; &#1091;&#1076;&#1072;&#1083;&#1077;&#1085; &#1080;&#1079; &#1074;&#1072;&#1096;&#1077;&#1081; \\u003Ca href\x3d\\\x22/history\\\x22\\u003E&#1080;&#1089;&#1090;&#1086;&#1088;&#1080;&#1080; &#1074;&#1077;&#1073;-&#1087;&#1086;&#1080;&#1089;&#1082;&#1072;\\u003C/a\\u003E\x22,\x22psrl\x22:\x22&#1059;&#1076;&#1072;&#1083;&#1080;&#1090;&#1100;\x22,\x22sbit\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1087;&#1086; &#1082;&#1072;&#1088;&#1090;&#1080;&#1085;&#1082;&#1077;\x22,\x22srch\x22:\x22&#1055;&#1086;&#1080;&#1089;&#1082; &#1074; Google\x22},\x22ovr\x22:{},\x22pq\x22:\x22\x22,\x22refpd\x22:true,\x22rfs\x22:[],\x22sbas\x22:\x220 3px 8px 0 rgba(0,0,0,0.2),0 0 0 1px rgba(0,0,0,0.08)\x22,\x22sbpl\x22:16,\x22sbpr\x22:16,\x22scd\x22:10,\x22stok\x22:\x22v4ZOTG-hC7QdirsaZ2e04qkB6vk\x22,\x22uhde\x22:false}}';google.pmc=JSON.parse(pmc);})();</script>        </body></html>
 конец 


	
 конец 



Пример №8
1: First line.
2: Second line.

Пример №9


Process finished with exit code 0
```

Пример №7 показывает, что буферизированные символьные потоки позволяют считывать
файл строками, в то время как простой символьный поток в примере №8 позволяет 
выполнять считывание только по одному символу.

#### Задание №2
Создать проект, позволяющий из одного, предварительно
созданного программными средствами файла, переписать данные,
соответствующие условию - в исходном файле содержится две строки в
формате UTF-8 и 5 чисел типа `double`. В результирующий файл переписать
вторую строку и положительные числа.

Код класса `Main`:
```java
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        final int STRING_COUNT = 2, DOUBLE_COUNT = 5;

        // Создание файла Output.txt
        File output = new File("E:\\Output.txt");
        if (!output.exists()) output.createNewFile();

        // Работа со строками
        var bufferedInput = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Input.txt")));
        var bufferedOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, false)));
        var selectedStrings = new ArrayList<String>();

        System.out.println("В исходном файле записаны следующие строки:");
        for (int i = 0; i < STRING_COUNT; i++) {
            String temp = bufferedInput.readLine();
            System.out.println("\t" + temp);
            if (i == 1) {
                bufferedOutput.append(temp + "\n\r");
                selectedStrings.add(temp);
            }
        }
        bufferedInput.close();
        bufferedOutput.flush();
        bufferedOutput.close();

        // Работа с числами
        var dataInput = new DataInputStream(new FileInputStream("E:\\Input.txt"));
        var dataOutput = new DataOutputStream(new FileOutputStream(output, true));
        var selectedDoubles = new ArrayList<Double>();

        System.out.println("\n\rВ исходном файле записаны следующие числа:");
        for (int i = 0; i < STRING_COUNT; i++) {
            dataInput.readLine();
        }
        for (int i = 0; i < DOUBLE_COUNT; i++) {
            double temp = dataInput.readDouble();
            System.out.println("\t" + temp);
            if (temp >= 0) {
                dataOutput.writeDouble(temp);
                selectedDoubles.add(temp);
            }
        }
        dataInput.close();
        dataOutput.flush();
        dataOutput.close();

        System.out.println("\n\rВ результирующий файл записано:");
        for (int i = 0; i < selectedStrings.size(); i++) {
            System.out.println("\t" + selectedStrings.get(i));
        }
        System.out.println();
        for (int i = 0; i < selectedDoubles.size(); i++) {
            System.out.println("\t" + selectedDoubles.get(i));
        }
    }
}
```

Вывод программы:
```text
В исходном файле записаны следующие строки:
	Привет мир!
	Hello world!

В исходном файле записаны следующие числа:
	5.0
	15.5876
	-453.0
	-598.2
	-75.0

В результирующий файл записано:
	Hello world!

	5.0
	15.5876
```

#### Задание №3
Создать проект, позволяющий из одного текстового файла,
содержащего несколько строк (тип `String`) заранее подготовленного текста
на русском языке (Пушкин, Лермонтов или другой российский классик на
ваш вкус), построчно переписать в другой текстовый файл слова
начинающиеся с согласных букв.

Требования:
- Слова из предложения выделять методом `split()`;
- В новом файле следует указать номер строки, в которой искомые
  слова находились в исходном файле;
- Для каждой строки указать количество выбранных слов.

Код класса `Main`:
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final var consonants = new char[] {'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М',
                'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'б', 'в', 'г', 'д',
                'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};;

        var output = new File("E:\\Output.txt");
        if (!output.exists()) output.createNewFile();

        var bufferedInput = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\InputText.txt")));
        var bufferedOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, false)));

        int lineCount = 1;
        String line = bufferedInput.readLine();
        while (line != null) {
            var words = line.split("[\s.!?\"«»;,]");

            if (words.length != 0) {
                int wordCount = 0;
                bufferedOutput.append(lineCount + ": ");

                for (int i = 0; i < words.length; i++) {
                    for (int j = 0; j < consonants.length; j++) {
                        if (words[i].length() < 3) continue;
                        else if (words[i].toCharArray()[0] == consonants[j]) {
                            wordCount++;
                            bufferedOutput.append(words[i] + " ");
                        }
                    }
                }

                bufferedOutput.append("[Найдено слов: " + wordCount + "]");
                bufferedOutput.newLine();
            }

            lineCount++;
            line = bufferedInput.readLine();
        }

        bufferedOutput.flush();
        bufferedOutput.close();
        bufferedInput.close();

        bufferedInput = new BufferedReader(new InputStreamReader(new FileInputStream(output)));
        line = bufferedInput.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedInput.readLine();
        }
        bufferedInput.close();
    }
}
```

Вывод программы:
```text
1: своих порогах [Найдено слов: 2]
2: Черкесы праздные сидят [Найдено слов: 3]
3: Сыны Кавказа говорят [Найдено слов: 3]
4: бранных гибельных тревогах [Найдено слов: 3]
5: красоте своих коней [Найдено слов: 3]
6: наслажденьях дикой неги [Найдено слов: 3]
7: Воспоминают прежних дней [Найдено слов: 3]
8: Неотразимые набеги [Найдено слов: 2]
9: хитрых [Найдено слов: 1]
10: шашек жестоких [Найдено слов: 2]
11: меткость неизбежных стрел [Найдено слов: 3]
12: пепел разоренных сел [Найдено слов: 3]
13: ласки пленниц чернооких [Найдено слов: 3]
14: Текут беседы тишине [Найдено слов: 3]
15: Луна плывет ночном тумане [Найдено слов: 4]
16: вдруг пред ними коне [Найдено слов: 4]
17: Черкес быстро [Найдено слов: 2]
18: Младого пленника влачил [Найдено слов: 3]
19: Вот русский хищник возопил [Найдено слов: 4]
20: крик сбежался [Найдено слов: 2]
21: толпой [Найдено слов: 1]
22: пленник хладный немой [Найдено слов: 3]
23: главой [Найдено слов: 1]
24: Как труп недвижим [Найдено слов: 3]
25: Лица врагов видит [Найдено слов: 3]
26: криков слышит [Найдено слов: 2]
27: Над ним летает смертный сон [Найдено слов: 5]
28: холодом тлетворным дышит [Найдено слов: 3]
29: долго пленник молодой [Найдено слов: 3]
30: Лежал забвении тяжелом [Найдено слов: 3]
31: полдень над главой [Найдено слов: 3]
32: Пылал сиянии веселом [Найдено слов: 3]
33: жизни дух проснулся нем [Найдено слов: 4]
34: Невнятный стон раздался [Найдено слов: 3]
35: Согретый солнечным лучом [Найдено слов: 3]
36: Несчастный тихо приподнялся [Найдено слов: 3]
37: Кругом слабый взор [Найдено слов: 3]
38: видит: неприступных гор [Найдено слов: 3]
39: Над ним воздвигнулась громада [Найдено слов: 4]
40: Гнездо разбойничьих племен [Найдено слов: 3]
41: Черкесской вольности [Найдено слов: 2]
42: Воспомнил свой плен [Найдено слов: 3]
43: Как сна тревоги [Найдено слов: 3]
44: слышит: загремели вдруг [Найдено слов: 3]
45: закованные ноги [Найдено слов: 2]
46: Всё всё сказал звук [Найдено слов: 4]
47: Затмилась перед ним природа [Найдено слов: 4]
48: Прости священная свобода [Найдено слов: 3]
49: раб [Найдено слов: 1]
```

## Вывод
В ходе лабораторной работы были получены навыки работы с байтовыми потоками
ввода/вывода данных, буферизированным вводом/выводом данных текстовых файлов и
использования классов `File` и `PrintWriter`. Также были приобретены навыки использования
классов из пакета `java.io`.

В рамках лабораторной работы №11 было решено 3 задач на программирование в Java.
Листинг кода написанных программ был представлен в разделе *Ход работы*.
В результате лабораторной работы поставленная цель была выполнена, а поставленные
задачи достигнуты.