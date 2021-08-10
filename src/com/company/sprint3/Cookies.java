package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Cookies {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 10000) {
            System.out.print("n > 10000");
            throw new Exception();
        }
        String[] greedFactor = reader.readLine().split(" ");
        if (greedFactor.length != n) {
            System.out.print("greedFactor length != n");
            throw new Exception();
        }
        int m = Integer.parseInt(reader.readLine());
        if (m > 10000) {
            System.out.print("m > 10000");
            throw new Exception();
        }
        String[] cookieSizes = reader.readLine().split(" ");
        if (cookieSizes.length != m) {
            System.out.print("cookieSizes length != m");
            throw new Exception();
        }
        ArrayList<Integer> greedFactorList = new ArrayList<>();
        ArrayList<Integer> cookiesSizesList = new ArrayList<>();
        for (int i = 0; i < greedFactor.length; i++) {
            int elem = Integer.parseInt(greedFactor[i]);
            if (elem > 1000) {
                System.out.print("greedFactor > 1000");
                throw new Exception();
            }
            greedFactorList.add(elem);
        }

        for (int i = 0; i < cookieSizes.length; i++) {
            int elem = Integer.parseInt(cookieSizes[i]);
            if (elem > 1000) {
                System.out.print("cookieSize > 1000");
                throw new Exception();
            }
            cookiesSizesList.add(Integer.parseInt(cookieSizes[i]));
        }
        findSatisfiedChild(n, greedFactorList, m, cookiesSizesList);

    }

    public static void findSatisfiedChild (int childQuantity, ArrayList<Integer> greedFactor, int cookieQuantity, ArrayList<Integer> cookieSizes) {
        int counter = 0;
        greedFactor.sort(Comparator.naturalOrder());
        cookieSizes.sort(Comparator.naturalOrder());

        for (int i = 0; i < childQuantity; i++) {
            int childFactor = greedFactor.remove(0);
            for (int j = 0; j < cookieQuantity; j++) {
                if (cookieSizes.get(j) >= childFactor) {
                    cookieSizes.remove(j);
                    cookieQuantity--;
                    counter++;
                    break;
                }
            }
        }
        System.out.print(counter);
    }
}
