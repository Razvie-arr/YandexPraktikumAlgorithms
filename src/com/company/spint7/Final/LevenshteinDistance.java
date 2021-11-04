/*
https://contest.yandex.ru/contest/25597/run-report/55932824/
-- ПРИНЦИП РАБОТЫ --
Для нахождения расстояния Левенштейна, используем динамическое программирование.
Заводим двумерный массив dp[длина первой строки + 1][длина второй строки + 1].
В двойном цикле обрабатываем крайние случаи, если i == 0, то расстояние Левенштейна для данной динамики равно j, и наоборот, если
j == 0, то расстояние dp[i][j] = i

Если в цикле у нас есть совпадения букв, то расстояние не увеличивается, то есть dp[i][j] = dp[i - 1][j - 1],
если такого счастливого совпадения не случилось, выбираем меньшее из трех зол: dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1, dp[i][j - 1].
В любом случае +1 делается, т.к нам нужно увеличивать расстояние на 1.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Итерируемся по двойному циклу: O(n * m)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Выделяем память под двумерный массив: O(n * m)
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
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < s.length() + 1 ; i++) {
            for (int j = 0; j < t.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = s.charAt(i - 1) == (t.charAt(j - 1)) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + 1,
                                                                                             Math.min(dp[i][j - 1] + 1,
                                                                                               dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[n][m];
    }
}
