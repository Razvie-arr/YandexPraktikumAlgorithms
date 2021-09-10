package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sum4 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int s = Integer.parseInt(reader.readLine());
        if (n < 0 || n > 1000) {
            throw new Exception("Invalid n");
        }
        if (s > 1000000000) {
            throw new Exception("Invalid s");
        }
        String[] stringArr = reader.readLine().split(" ");
        if (n != stringArr.length) {
            System.out.println(0);
            System.exit(0);
        }
        ArrayList<Integer> x = getIntegerArrayList(stringArr);
        effectiveSolution(s, x);
    }

    public static ArrayList<Integer> getIntegerArrayList(String[] stringArr) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < stringArr.length; i++) {
            ret.add(Integer.parseInt(stringArr[i]));
        }
        return ret;
    }

    public static void effectiveSolution(int A, ArrayList<Integer> x) {
        HashSet<Integer> history = new HashSet<>();
        int n = x.size();
        Collections.sort(x);
        HashSet<List<Integer>> quad = new HashSet<>();
        int target;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int z = j + 1; z <n; z ++)
                {
                    target = A - x.get(i) - x.get(j) - x.get(z);

                    if (history.contains(target)) {
                        quad.add(Arrays.asList(target, x.get(i), x.get(j), x.get(z)));
                    }
                }
            }
            history.add(x.get(i));
        }

        System.out.println(quad.size());
        String quadString = quad.toString();
        quadString = quadString.replace("[", "");
        quadString = quadString.replace(",", "");
        quadString = quadString.replace("] ", "\n");
        quadString = quadString.replace("]", "");
        System.out.println(quadString);
    }
}
