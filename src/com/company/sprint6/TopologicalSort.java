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
        long topSortStartTime = System.currentTimeMillis();
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == Color.WHITE) {
                topSort(i, graph, colors, order);
            }
        }
        long topSortEndTime = System.currentTimeMillis();
        System.out.println("Скорость работы topSort для каждой вершины с рекурсией в мс: " + (topSortEndTime - topSortStartTime));
        long appendOrderToOutStartTime = System.currentTimeMillis();
        while (!order.isEmpty()) {
            out.append(order.pop()).append(" ");
        }
        long appendOrderToOutEndTime = System.currentTimeMillis();
        System.out.println("Скорость добавления order в out в мс: " + (appendOrderToOutEndTime - appendOrderToOutStartTime));
        long outDeleteStartTime = System.currentTimeMillis();
        out.delete(out.length() - 1, out.length());
        long outDeleteEndTime = System.currentTimeMillis();
        System.out.println("Скорость удаления первого и последнего символа в out в мс: " + (outDeleteEndTime - outDeleteStartTime));
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
        long fillGraphStartTime = System.currentTimeMillis();
        long ribSplitTime = 0;
        long fromToTime = 0;
        long graphAddTime = 0;
        for (int i = 0; i < m; i++) {
            long ribSplitStartTime = System.currentTimeMillis();
            String[] rib = reader.readLine().trim().split("\\s+");
            long ribSplitEndTime = System.currentTimeMillis();
            ribSplitTime = ribSplitTime + (ribSplitEndTime - ribSplitStartTime);
            long fromToStartTime = System.currentTimeMillis();
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            long fromToEndTime = System.currentTimeMillis();
            fromToTime = fromToTime + (fromToEndTime - fromToStartTime);
            long graphAddStartTime = System.currentTimeMillis();
            graph.addEdge(from, to);
            long graphAddEndTime = System.currentTimeMillis();
            graphAddTime = graphAddTime + (graphAddEndTime - graphAddStartTime);
        }
        long fillGraphEndTime = System.currentTimeMillis();
        System.out.println("Скорость работы добавления вершин в мс: " + (fillGraphEndTime - fillGraphStartTime));
        System.out.println("Скорость сплита ребер мс: " + ribSplitTime);
        System.out.println("Скорость фромту в мс: " + fromToTime);
        System.out.println("Скорость графадд в мс: " + (fillGraphEndTime - fillGraphStartTime));
        long fillColorStartTime = System.currentTimeMillis();
        Color[] colors = new Color[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            colors[i] = Color.WHITE;
        }
        long fillColorEndTime = System.currentTimeMillis();
        System.out.println("Скорость работы добавления цветов в мс: " + (fillColorEndTime - fillColorStartTime));
        getTopSorted(graph, colors);
    }


}
