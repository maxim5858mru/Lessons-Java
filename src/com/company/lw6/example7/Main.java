package com.company.lw6.example7;

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
