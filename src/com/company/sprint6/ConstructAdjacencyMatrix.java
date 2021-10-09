package com.company.sprint6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstructAdjacencyMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        if (n < 1 || n > 100) {
            throw new Exception("Invalid n");
        }
        if (m < 1 || m > n * (n - 1)) {
            throw new Exception("Invalid m");
        }
        HashMap<Integer, ArrayList<Integer>> vertex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] rib = reader.readLine().trim().split("\\s+");
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            if (vertex.get(from) == null) {
                vertex.put(from, new ArrayList<>(Arrays.asList(to)));
            } else {
                ArrayList<Integer> newTo = vertex.get(from);
                newTo.add(to);
                vertex.put(from, newTo);
            }
        }
        printExtractedRibsAsMatrix(n, vertex);
    }

    public static void printExtractedRibsAsMatrix(int n, HashMap<Integer, ArrayList<Integer>> vertex) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (vertex.get(i) == null) {
                String zeros = "0 ".repeat(n);
                out.append(zeros);
            } else {
                ArrayList<Integer> ribsOfVertex = vertex.get(i);
                for (int j = 1; j < n + 1; j++) {
                    if (ribsOfVertex.contains(j)) {
                        out.append("1 ");
                    } else {
                        out.append("0 ");
                    };
                }
            }
            out.delete(out.length() - 1, out.length());
            out.append("\n");
        }
        System.out.println(out.substring(0, out.length() - 1));
    }
}
