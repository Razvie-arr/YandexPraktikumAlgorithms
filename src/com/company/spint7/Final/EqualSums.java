package com.company.spint7.Final;
/*
https://contest.yandex.ru/contest/25597/run-report/56023221/

--ПРИНЦИП РАБОТЫ--
Проходим по массиву с очками, считаем сумму всех очков. Заполняем dp[0] true, т.к. мы всегда можем получить сумму 0.
Создаем цикл, для решения задачи нам нужно набрать половину суммы всех очков, поэтому итерируемся по sum / 2.
Итерируемся по каждому числу, принимаем dp[j] = dp[j] || dp[j - score];


-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
O(sum), где sum - это сумма всех заработанных очков Гоши

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Храним массив dp: O(sum)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] scores = new int[n];
        StringTokenizer scoresTokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(scoresTokenizer.nextToken());
        }
        if (isEqualPartition(scores, n)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean isEqualPartition(int[] scores, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scores[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int i = 0; i < n ; i++) {
            int score = scores[i];
            for (int j = sum / 2; j >= score; j--) {
                dp[j] = dp[j] || dp[j - score];
            }
        }

        return dp[sum / 2];
    }
}
