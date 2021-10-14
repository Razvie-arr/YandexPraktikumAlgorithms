package com.company.sprint6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TopGraph {
    Map<Integer, List<Integer>> graph;
    public TopGraph(int n) {
        this.graph = new HashMap<>(n);
    }
    public void addVertex(int s)
    {
        graph.put(s, new LinkedList<>());
    }

    public void addEdge(int from, int to) {

        if (!graph.containsKey(from))
            addVertex(from);
        graph.get(from).add(to);
    }

    public List<Integer> getEdges(int vertex) {
        return graph.get(vertex);
    }
}
public class TopologicalSort {
    public enum Color {
        WHITE,
        GRAY,
        BLACK
    }
    public static String getTopSorted(TopGraph graph, Color[] colors) {
        StringBuilder out = new StringBuilder();
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == Color.WHITE) {
                topSort(i, graph, colors, order);
            }
        }
        while (!order.isEmpty()) {
            out.append(order.pop()).append(" ");
        }
        out.delete(out.length() - 1, out.length());
        return out.toString();
    }

    public static void topSort(int v, TopGraph graph, Color[] colors, Deque<Integer> order) {
        colors[v] = Color.GRAY;
        List<Integer> edges = graph.getEdges(v);
        if (edges != null) {
            for (int edge : edges) {
                if (colors[edge] == Color.WHITE) {
                    topSort(edge, graph, colors, order);
                }
            }
        }
        colors[v] = Color.BLACK;
        order.push(v);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        TopGraph graph = new TopGraph(n);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.addEdge(from, to);
        }
        Color[] colors = new Color[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            colors[i] = Color.WHITE;
        }
        System.out.println(getTopSorted(graph, colors));
    }


}
