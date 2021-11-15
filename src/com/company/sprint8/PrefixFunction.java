package com.company.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
//        naivePrefixFunction(s);
        effectivePrefixFunction(s);
    }

//    public static void naivePrefixFunction(String s) {
//        int n = s.length();
//        int[] pi = new int[n];
//        for (int i = 1; i <= n; i++) {
//            String substring = s.substring(0, i);
//            for (int k = i - 1; k >= 0 ; k--) {
//                String prefix = substring.substring(0, k);
//                String suffix = substring.substring(i - k, i);
//                if (prefix.equals(suffix)) {
//                    pi[i - 1] = k;
//                    break;
//                }
//            }
//        }
//        for (int number : pi) {
//            System.out.print(number + " ");
//        }
//    }

    public static void effectivePrefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];
        pi[0] = 0;
        for (int i = 1; i < n; i++) {
            int k = pi[i - 1];
            while ((k > 0) && (s.charAt(k) != s.charAt(i))) {
                k = pi[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        StringBuilder out = new StringBuilder(pi.length * 2);

        for (int number : pi) {
            out.append(number).append(" ");
        }
        out.deleteCharAt(out.length() - 1);
        System.out.print(out);
    }
}
