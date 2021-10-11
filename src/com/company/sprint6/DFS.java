package com.company.sprint6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.*;
public class DFS {
    static class Vertex {
        private final int number;
        private String color;
        public Vertex(int number, String color) {
            this.number = number;
            this.color = color;
        }

        public int getNumber() {
            return number;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

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
        Vertex[] vertexList = new Vertex[n + 1];
        int i = 1;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            vertexList[i] = new Vertex(entry.getKey(), "white");
            i++;
        }
        int startVertex = Integer.parseInt(reader.readLine());
        mainDFS(graph, vertexList, startVertex);
    }

    public static void addVertex(Map<Integer, List<Integer>> graph, int s)
    {
        graph.put(s, new LinkedList<>());
    }

    public static void addEdge(Map<Integer, List<Integer>> graph, int source, int destination)
    {

        if (!graph.containsKey(source))
            addVertex(graph, source);

        if (!graph.containsKey(destination))
            addVertex(graph, destination);

        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public static void mainDFS(Map<Integer, List<Integer>> graph, Vertex[] vertexList, int startVertex) {
        for (int i = 1; i < vertexList.length; i++) {
            if (vertexList[i].getColor().equals("white")) {
                doDFS(graph, vertexList, startVertex);
            }
        }
    }

    public static void doDFS(Map<Integer, List<Integer>> graph, Vertex[] vertexList, int startVertex) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(vertexList[startVertex]);
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (v.getColor().equals("white")) {
                v.setColor("gray");
                out.append(v.getNumber()).append(" ");
                stack.push(v);
                List<Integer> edges = graph.get(v.getNumber());
                Collections.sort(edges);
                Collections.reverse(edges);
                for (int egde : edges) {
                    Vertex w = vertexList[egde];
                    if (w.getColor().equals("white")) {
                        stack.push(w);
                    }
                }
            } else if (v.getColor().equals("gray")) {
                v.setColor("black");
            }
        }
        out.delete(out.length() - 1, out.length());
        System.out.println(out);
    }

}
