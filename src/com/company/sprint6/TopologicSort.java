package com.company.sprint6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.*;
public class TopologicSort {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        if (n < 1 || n > 100000) {
            throw new Exception("Invalid n");
        }
        if (m < 0 || m > 100000) {
            throw new Exception("Invalid m");
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] rib = reader.readLine().trim().split("\\s+");
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            addEdge(graph, from, to);
        }
        String[] colors = new String[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            colors[i] = "white";
        }
        Stack<Integer> order = new Stack<>();
        mainTopSort(graph, colors, order);
        StringBuilder out = new StringBuilder();
        for (int i : order) {
            out.append(i).append(" ");
        }
        out.delete(out.length() - 1, out.length());
        System.out.println(out);
    }

    public static void addVertex(Map<Integer, List<Integer>> graph, int s)
    {
        graph.put(s, new LinkedList<>());
    }

    public static void addEdge(Map<Integer, List<Integer>> graph, int source, int destination)
    {

        if (!graph.containsKey(source))
            addVertex(graph, source);


        graph.get(source).add(destination);
    }

    public static void mainTopSort(Map<Integer, List<Integer>> graph, String[] colors, Stack<Integer> order) {
        for (int i = 1; i < colors.length; i++) {
            if (colors[i].equals("white")) {
                topSort(i, graph, colors, order);
            }
        }
    }

    public static void topSort(int v, Map<Integer, List<Integer>> graph, String[] colors, Stack<Integer> order) {
        colors[v] = "gray";
        List<Integer> edges = graph.get(v);
        if (edges != null) {
            for (int edge : edges) {
                if (colors[edge].equals("white")) {
                    topSort(edge, graph, colors, order);
                }
            }
        }
        colors[v] = "black";
        order.push(v);
    }

}
