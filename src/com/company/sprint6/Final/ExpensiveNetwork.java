package com.company.sprint6.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ExpensiveGraph {
    private final Map<Integer, List<List<Integer>>> graph;
    public ExpensiveGraph(int n) {
        this.graph = new HashMap<>(n);
    }

    public void addVertex(int s)
    {
        graph.put(s, new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        if (!graph.containsKey(from))
            addVertex(from);
        if (!graph.containsKey(to))
            addVertex(to);
        graph.get(from).add(new ArrayList<>(Arrays.asList(to, weight)));
        graph.get(to).add(new ArrayList<>(Arrays.asList(from, weight)));
    }
    public Set<Integer> getGraphKeys() {
        return graph.keySet();
    }

    public Map<Integer, List<List<Integer>>> getGraph() {
        return graph;
    }

    public List<List<Integer>> getEdges(int vertex) {
        return graph.get(vertex);
    }
}
public class ExpensiveNetwork {
    public static void addVertex(int vertex, List<Integer> added, Set<Integer> notAdded, List<Integer> edges, ExpensiveGraph graph) {
        added.add(vertex);
        notAdded.remove(vertex);
    }

    public static int getMinimumSpanningTree(ExpensiveGraph graph, int n) {
        List<Integer> edges = new ArrayList<>();
        List<Integer> added = new ArrayList<>(n);
        Set<Integer> notAdded = new HashSet<>(graph.getGraphKeys());
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numbers = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        ExpensiveGraph graph = new ExpensiveGraph(n);
        //этап 1: заполнение графа
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.addEdge(from, to, weight);
        }
        System.out.println(getMinimumSpanningTree(graph, n));
    }
}
