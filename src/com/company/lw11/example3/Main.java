package com.company.lw11.example3;

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
