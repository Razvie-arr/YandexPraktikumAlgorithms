package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SleightOfHands {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[][] twoDimArray = new String[4][4];
        int k = Integer.parseInt(reader.readLine());
        if (k < 1 || k > 5) {
            System.exit(0);
        }
        for (int i = 0; i < 4; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            twoDimArray[i][0] = tokenizer.nextToken();
            twoDimArray[i][1] = tokenizer.nextToken();
            twoDimArray[i][2] = tokenizer.nextToken();
            twoDimArray[i][3] = tokenizer.nextToken();
            if (!(twoDimArray[i][0].matches("[1-9.]")) ||
                !(twoDimArray[i][1].matches("[1-9.]")) ||
                !(twoDimArray[i][2].matches("[1-9.]")) ||
                !(twoDimArray[i][3].matches("[1-9.]"))) {
                    System.exit(0);
                }
        }
        findMaxScore(twoDimArray);
    }
    public static void findMaxScore(String[][] input) {
        //вывод массива
        for (String[] strings : input) {
            for (String string : strings) {
                System.out.print(string + "\t");
            }
            System.out.println();
        }
    }
}
