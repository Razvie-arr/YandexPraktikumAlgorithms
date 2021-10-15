package com.company.sprint6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class MaxDistanceGraph {
    Map<Integer, List<Integer>> graph;
    public MaxDistanceGraph(int n) {
        this.graph = new HashMap<>(n);
    }

    public void addVertex(int s)
    {
        graph.put(s, new ArrayList<>());
    }

    public void addEdge(int from, int to) {

        if (!graph.containsKey(from))
            addVertex(from);
        if (!graph.containsKey(to))
            addVertex(to);
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public List<Integer> getEdges(int vertex) {
        return graph.get(vertex);
    }
}

public class MaxDistance {
    public enum Color {
        WHITE,
        GRAY,
        BLACK
    }
    public static int getMaxDistance(MaxDistanceGraph graph, Color[] colors, Integer[] previous, Integer[] distance, int startVertex, int n) {
        Deque<Integer> planned = new ArrayDeque<>();
        planned.addLast(startVertex);
        colors[startVertex] = Color.GRAY;
        distance[startVertex] = 0;
        while (!planned.isEmpty()) {
            int u = planned.poll();
            List<Integer> edges = graph.getEdges(u);
            if (edges != null) {
                Collections.sort(edges);
                for (int v : edges) {
                    if (colors[v] == Color.WHITE) {
                        distance[v] = distance[u] + 1;
                        previous[v] = u;
                        colors[v] = Color.GRAY;
                        planned.addLast(v);
                    }
                }
            }
            colors[u] = Color.BLACK;
        }
        int maxDistance = distance[1];
        for (int i = 2; i < distance.length; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numbers = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        MaxDistanceGraph graph = new MaxDistanceGraph(n);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.addEdge(from, to);
        }
        int startVertex = Integer.parseInt(reader.readLine());
        Color[] colors = new Color[n + 1];
        for (int i = 1; i < n + 1; i++) {
            colors[i] = Color.WHITE;
        }
        Integer[] previous = new Integer[n + 1];
        for (int i = 1; i < n + 1; i++) {
            previous[i] = null;
        }
        Integer[] distance = new Integer[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = null;
        }
        System.out.println(getMaxDistance(graph, colors, previous, distance, startVertex, n));
    }
}
