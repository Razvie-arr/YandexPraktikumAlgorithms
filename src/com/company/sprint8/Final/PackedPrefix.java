package com.company.sprint8.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PackedPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> packedStrings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String string = reader.readLine();
            packedStrings.add(string);
        }
        List<String> unpackedStrings = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            unpackedStrings.add(getUnpackedString(packedStrings.get(i)));
        }

        System.out.println(compareUnpackedStrings(unpackedStrings));
    }

    public static String getUnpackedString(String string) {
        int openBrackets = 0;
        int closeBrackets = 0;
        int len = string.length();
        Stack<Integer> countStack = new Stack<>();
        int[] priority = new int[len];
        for (int i = 0; i < len; i++) {
            char current = string.charAt(i);
            if (current == '[') {
                openBrackets++;
                priority[i] = -1;
            } else if (current == ']') {
                closeBrackets++;
                priority[i] = -1;
            } else if (((int) current < 58)) {
                priority[i] = - 1;
            } else {
                priority[i] = openBrackets - closeBrackets;
            }
        }
        return string;
    }

    public static String compareUnpackedStrings(List<String> unpackedStrings) {
        return "aaa";
    }
}
