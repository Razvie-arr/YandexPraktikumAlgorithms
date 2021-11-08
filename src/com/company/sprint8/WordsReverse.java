package com.company.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        printReversedString(input);
    }

    public static void printReversedString(String input) {
        StringBuilder out = new StringBuilder(input.length());
        String[] inputArray = input.split(" ");
        for (int i = inputArray.length - 1;  i >= 0; i--) {
            out.append(inputArray[i]).append(" ");
        }
        System.out.println(out);
    }
}
