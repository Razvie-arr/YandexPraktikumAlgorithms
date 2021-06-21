
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(reader.readLine());
        String words = reader.readLine();
        findLongestWord(L, words);
    }

    public static void findLongestWord(int L, String words) {
        if (L >= 100000) {
            System.exit(0);
        }

        if (words.length() != L) {
            System.exit(0);
        }

        if (!words.matches("[a-z ]*")) {
            System.exit(0);
        }

        String longestWord = Arrays.stream(words.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
        if (longestWord != null)
        {
            System.out.print(longestWord + "\n" + longestWord.length());
        }

    }
}
