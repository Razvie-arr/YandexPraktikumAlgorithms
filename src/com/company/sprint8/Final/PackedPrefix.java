package com.company.sprint8.Final;
/*
https://contest.yandex.ru/contest/26133/run-report/58696849/

-- ПРИНЦИП РАБОТЫ --
Распаковыаем все строки в массив unpackedStrings. Для этого используем методы decodeString и decode. decodeString
инициирует выполнение рекурсивного decode. Используем переменную i, для итерации по всем символам строки. Если встречаем
цифру, добавляем в count. При встрече символа '[', передвигаем итератор i и снова запускаем рекурсию, получив
распакованную подстроку между символами '[' и ']', далее кладем ее столько раз, сколько у нас получилось в счетчике count.

Далее, получив в массив все распакованные строки, находим их общий префикс в методе longestCommonPrefix. В нем сравниваем
первые символы всех трех строк, пока не получаем несовпадение.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Декодирование занимает О(n), где n - это кол-во всех запакованных строк
Вычисление общего префикса О(len * n), где len - это длина первой строки, а n - это кол-во всех
распакованных строк

Получаем О(n + (len * n))

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Храним массив распакованных строк unpackedStrings - O(n), где n - это кол-во строк
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PackedPrefix {
    int i;
    public String decodeString(String s) {
        i = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder out = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            }
            else if (c == '[') {
                i++;
                String insideOfParentheses = decode(s);
                while (count > 0) {
                    out.append(insideOfParentheses);
                    count--;
                }
            }

            else if (c == ']') {
                return out.toString();
            }
            else {
                out.append(c);
            }
            i++;
        }
        return out.toString();
    }

    public String longestCommonPrefix(String[] unpackedStrings) {
        StringBuilder out = new StringBuilder();
        /*Хотел находить длину минимальной строки, чтобы итерироваться по ней, а не по первой строке, мне это кажется
        более правильным, но это затратнее по памяти. Подскажи, пожалуйста, как будет лучше?

         int lenOfSmallestString = getLengthOfSmallestString(unpackedStrings);
         */
        for (int j = 0; j < unpackedStrings[0].length(); j++) {
            char current = unpackedStrings[0].charAt(j);
            for (String str : unpackedStrings) {
                if (str.charAt(j) != current) {
                    return out.toString();
                }
            }
            out.append(current);
        }
        return out.toString();
    }

    /*
    public int getLengthOfSmallestString(String[] strings) {
        int min = strings[0].length();
        for (int j = 1; j < strings.length ; j++) {
            if (strings[j].length() < min) {
                min = strings[j].length();
            }
        }
        return min;
    }
    */

    public void printCommonPrefix() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] unpackedStrings = new String[n];
        for (int i = 0; i < n; i++) {
            unpackedStrings[i] = decodeString(reader.readLine());
        }
        System.out.println(longestCommonPrefix(unpackedStrings));
    }

    public static void main(String[] args) throws IOException {
        PackedPrefix prefix = new PackedPrefix();
        prefix.printCommonPrefix();
    }
}