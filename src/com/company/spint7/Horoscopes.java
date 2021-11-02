package com.company.spint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class LCS {
    private final int[][] dp;
    private final int n;
    private final int m;
    private final int[] firstSubsequence;
    private final int[] secondSubsequence;

    public LCS(int[] firstSubsequence, int[] secondSubsequence, int n, int m) {
        this.n = n;
        this.m = m;
        this.firstSubsequence = firstSubsequence;
        this.secondSubsequence = secondSubsequence;
        this.dp = new int[n + 1][m + 1];
    }

    public int computeLCS() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (firstSubsequence[i - 1] == secondSubsequence[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public void printLCSPath() {
        if (dp[n][m] > 0) {
            int index = dp[n][m];
            int[] lcs = new int[index];
            int i = n;
            int j = m;
            StringBuilder firstIndexes = new StringBuilder();
            StringBuilder secondIndexes = new StringBuilder();
            while (i > 0 && j > 0) {
                if (firstSubsequence[i - 1] == secondSubsequence[j - 1]) {
                    lcs[index - 1] = firstSubsequence[i - 1];
                    firstIndexes.append(i).append(" ");
                    secondIndexes.append(j).append(" ");
                    i--;
                    j--;
                    index--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            firstIndexes.delete(firstIndexes.length() - 1, firstIndexes.length());
            secondIndexes.delete(secondIndexes.length() - 1, secondIndexes.length());
            System.out.println(firstIndexes.reverse());
            System.out.println(secondIndexes.reverse());
        }
    }

    public static class Horoscopes {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer firstSubsequenceTokenizer = new StringTokenizer(reader.readLine(), " ");
            int[] firstSubsequence = new int[n];
            for (int i = 0; i < n; i++) {
                firstSubsequence[i] = Integer.parseInt(firstSubsequenceTokenizer.nextToken());
            }
            int m = Integer.parseInt(reader.readLine());
            StringTokenizer secondSubsequenceTokenizer = new StringTokenizer(reader.readLine(), " ");
            int[] secondSubsequence = new int[m];
            for (int i = 0; i < m; i++) {
                secondSubsequence[i] = Integer.parseInt(secondSubsequenceTokenizer.nextToken());
            }
            LCS lcs = new LCS(firstSubsequence, secondSubsequence, n, m);
            System.out.println(lcs.computeLCS());
            lcs.printLCSPath();
        }
    }
}
