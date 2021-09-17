package com.company.sprint4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Subsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if (string.length() > 10000) {
            throw new Exception();
        }

        if (!isSmallLatinDigits(string)) {
            throw new Exception();
        }
        System.out.println(longestUniqueSubsttr(string));
    }

    public static boolean isSmallLatinDigits(String str) {
        return str.matches("[a-z]+");
    }

    static int longestUniqueSubsttr(String s)
    {
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;

        // starting the initial point of window to index 0
        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            // Checking if we have already seen the element or not
            if(seen.containsKey(s.charAt(end)))
            {
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }

            // Updating the last seen value of the character
            seen.put(s.charAt(end), end);
            maximum_length = Math.max(maximum_length, end-start + 1);
        }
        return maximum_length;
    }
}
