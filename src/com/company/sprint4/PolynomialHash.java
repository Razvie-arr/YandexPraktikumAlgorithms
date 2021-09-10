package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PolynomialHash {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        System.out.println(computePolynomialHash(a, m, s));
    }

    public static int computePolynomialHash(int a, int m, String s) {
        if (s.equals("")) {
            return 0;

        }
        int horner = 0;
        for (int i = 0; i < s.length(); i++) {
            horner = (horner * a + s.charAt(i));
            horner = Math.floorMod(horner, m);
        }
        return horner;
    }
}
