package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Subsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        if (s.length() > 150000 || t.length() > 150000) {
            throw new Exception();
        }

        if (s.length() == 0 || t.length() == 0) {
            System.out.println("True");
            return;
        }

        if (!isSmallLatinDigits(s) || !isSmallLatinDigits(t)) {
            throw new Exception();
        }

        boolean result = isSubSequence(s, t, s.length(), t.length());
        if (result) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

    public static boolean isSmallLatinDigits(String str) {
        return str.matches("[a-z]+");
    }

    public static boolean isSubSequence(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);

        return isSubSequence(str1, str2, m, n - 1);
    }
}
