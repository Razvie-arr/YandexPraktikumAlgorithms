package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class StrangeComparison {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        System.out.println(isStrangeEqual(s, t));
    }

    public static String isStrangeEqual(String first, String second) {
        StringBuilder output = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        int n = Math.min(first.length(), second.length());
        for (int i = 0; i < n; i++) {
            if (!map.containsValue(second.charAt(i))) {
                map.put(first.charAt(i), second.charAt(i));
            }
        }
        for (int i = 0; i < n; i++) {
            char temp;
            if (map.get(first.charAt(i)) != null) {
                temp = map.get(first.charAt(i));
            }
            else {
                temp = 'n';
            }
            if (temp != second.charAt(i)) {
                return "NO";
            }
            output.append(temp);
        }
        if (output.toString().equals(second)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
