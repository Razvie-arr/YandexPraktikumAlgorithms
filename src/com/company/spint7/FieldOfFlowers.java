package com.company.spint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FieldOfFlowers
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] field = new int[n][m];
        constructMatrixOfField(reader, field, n, m);
        printMaxFlowersAndPath(field, n, m);
    }

    public static void constructMatrixOfField(BufferedReader reader, int[][] field, int n, int m) throws IOException {
        for (int i = n - 1; i >= 0; i--) {
            String strOfField = reader.readLine();
            for (int j = m - 1; j >= 0; j--) {
                field[i][j] = Integer.parseInt(String.valueOf(strOfField.charAt(j)));
            }
        }
    }

    public static void printMatrixOfField(int[][] field) {
        for (int[] ints : field) {
            for (int j = 0; j < field[1].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMaxFlowersAndPath(int[][] field, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = field[0][0];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int first;
                int second;
                if (i - 1 >= 0) {
                    first = dp[i - 1][j];
                } else {
                    first = 0;
                }
                if (j - 1 >= 0) {
                    second = dp[i][j - 1];
                } else {
                    second = 0;
                }
                if (first > second) {
                    dp[i][j] = first + field[i][j];
                    out.append("U");
                } else {
                    dp[i][j] = second + field[i][j];
                    out.append("R");
                }}
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
