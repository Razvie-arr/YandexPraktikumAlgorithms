package com.company.sprint4;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 1, 3, 4, 4));
        int A = 10;
        effectiveSolution(A, x);
    }

    public static void effectiveSolution(int A, ArrayList<Integer> x) {
        HashSet<Integer> history = new HashSet<>();
        int n = x.size();
        Collections.sort(x);
        HashSet<List<Integer>> triples = new HashSet<>();
        int target;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                target = A - x.get(i) - x.get(j);

                if (history.contains(target)) {
                    triples.add(Arrays.asList(target, x.get(i), x.get(j)));
                }
            }
            history.add(x.get(i));
        }
        System.out.println(triples);
    }
}
