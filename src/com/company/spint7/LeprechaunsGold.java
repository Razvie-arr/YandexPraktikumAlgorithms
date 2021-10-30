package com.company.spint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeprechaunsGold {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ingotsQuantityAndBagCapacity = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(ingotsQuantityAndBagCapacity.nextToken());
        int M = Integer.parseInt(ingotsQuantityAndBagCapacity.nextToken());
        StringTokenizer ingotsTokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] ingots = new int[n];
        for (int i = 0; i < n; i++) {
            ingots[i] = Integer.parseInt(ingotsTokenizer.nextToken());
        }
        System.out.println(getMaximumWeightOfIngots(ingots, n, M));
    }

    public static int getMaximumWeightOfIngots(int[] ingots, int quantity, int maxCapacity) {
        if (quantity <= 0 || maxCapacity <= 0) {
            return 0;
        }
        int[][] dp = new int[quantity + 1][maxCapacity + 1];

        for (int i = 1; i <= quantity; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                if (ingots[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - ingots[i - 1]] + ingots[i - 1]);
                }
            }
        }
        return dp[quantity][maxCapacity];
    }
}
