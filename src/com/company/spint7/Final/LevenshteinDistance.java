/*
https://contest.yandex.ru/contest/25597/run-report/55932824/
-- ПРИНЦИП РАБОТЫ --
Для нахождения расстояния Левенштейна, используем динамическое программирование.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Итерируемся по двойному циклу: O(n * m)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Выделяем память под массив 0(m + m)
 */
package com.company.spint7.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LevenshteinDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        System.out.println(getLevenshteinDistance(s, t));
    }

    public static int getLevenshteinDistance(String s, String t)
    {
        int m = t.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j < t.length() + 1; j++) {
            prev[j] = j;
        }

        int[] curr = new int[m + 1];
        for (int i = 1; i < s.length() + 1 ; i++) {
            curr[0] = i;
            for (int j = 1; j < t.length() + 1; j++) {
                curr[j] = s.charAt(i - 1) == (t.charAt(j - 1)) ? prev[j - 1] : Math.min(prev[j] + 1, Math.min(curr[j - 1] + 1, prev[j - 1] + 1));
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
