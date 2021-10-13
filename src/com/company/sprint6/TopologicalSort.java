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
        graph.put(s, new ArrayList<>());
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
    public static String getTopSorted(TopGraph graph, String[] colors) {
        StringBuilder out = new StringBuilder();
        Stack<Integer> order = new Stack<>();
        for (int i = 1; i < colors.length; i++) {
            if (colors[i].equals("white")) {
                topSort(i, graph, colors, order);
            }
        }
        while (!order.isEmpty()) {
            out.append(order.pop()).append(" ");
        }
        out.delete(out.length() - 1, out.length());
        return out.toString();
    }

    public static void topSort(int v, TopGraph graph, String[] colors, Stack<Integer> order) {
        colors[v] = "gray";
        List<Integer> edges = graph.getEdges(v);
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

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        TopGraph graph = new TopGraph(n);
        for (int i = 0; i < m; i++) {
            String[] rib = reader.readLine().trim().split("\\s+");
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            graph.addEdge(from, to);
        }
        String[] colors = new String[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            colors[i] = "white";
        }
        System.out.println(getTopSorted(graph, colors));
    }


}
