package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Sum4 {
    static class Pair{
        int i;
        int j;

        Pair(int x,int y){
            i=x;
            j=y;
        }
    }
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
        for (String s : stringArr) {
            ret.add(Integer.parseInt(s));
        }
        return ret;
    }

    public static void effectiveSolution(int A, ArrayList<Integer> x) {
        Collections.sort(x);
        int len = x.size();
        HashSet<List<Integer>> quad = new HashSet<>();
        Map<Integer, Pair> sums = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int current = x.get(i) + x.get(j);
                int rest = A - current;
                if (sums.containsKey(rest)) {
                    Pair p = sums.get(rest);
                    quad.add(Arrays.asList(x.get(p.j), x.get(p.i), x.get(i), x.get(j)));
                }
            }
            for (int k = 0; k < i; ++k) {
                sums.put(x.get(i) + x.get(k), new Pair(i, k));
            }
        }
        String sortedQuad = lexicoCompare(quad);
        sortedQuad = sortedQuad.replaceAll("\\[|\\]", "");
        System.out.println(sortedQuad.replace(", ", "\n"));
    }

    public static String lexicoCompare(HashSet<List<Integer>> quad) {
        List<String> output = new ArrayList<>();
        for (List<Integer> elem : quad) {
            String elemString = elem.toString();
            elemString = elemString.replace(",", " ");
            elemString = elemString.replaceAll("\\[|\\]", "");
            output.add(elemString);
        }
        output = sortAsNumbers(output);
        return output.toString();
    }

    public static List<String> sortAsNumbers(Collection<String> collection) {
        return collection
                .stream()
                .map(Integer::valueOf)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

}
