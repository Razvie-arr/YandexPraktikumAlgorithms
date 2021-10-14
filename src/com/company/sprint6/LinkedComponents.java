package com.company.sprint6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class LinkGraph {
    Map<Integer, List<Integer>> graph;
    public LinkGraph(int n) {
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

public class LinkedComponents {
    public static String getLinkedSorted(LinkGraph graph, int[] colors) {
        StringBuilder out = new StringBuilder();
        int componentCount = 1;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == -1) {
                linkSort(i, graph, colors, componentCount);
                componentCount++;
            }
        }
        out.append(componentCount - 1).append("\n");
        HashMap<Integer, ArrayList<Integer>> connectedComponents = new HashMap<>();
        for (int i = 1; i < colors.length; i++) {
            if (connectedComponents.containsKey(colors[i])) {
                connectedComponents.get(colors[i]).add(i);
            } else {
                connectedComponents.put(colors[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        connectedComponents.entrySet().forEach(entry -> {
            String values = entry.getValue().toString().replace(",", "");
            out.append(values, 1, values.length() - 1).append("\n");
        });
        out.delete(out.length() - 1, out.length());
        return out.toString();
    }

    public static void linkSort(int v, LinkGraph graph, int[] colors, int componentCount) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int tempVertex = stack.pop();
            if (colors[tempVertex] == -1) {
                colors[tempVertex] = componentCount;
                List<Integer> edges = graph.getEdges(v);
                if (edges != null) {
                    for (int edge : edges) {
                        if (colors[edge] == -1) {
                            linkSort(edge, graph, colors, componentCount);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        LinkGraph graph = new LinkGraph(n);
        for (int i = 0; i < m; i++) {
            String[] rib = reader.readLine().trim().split("\\s+");
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            graph.addEdge(from, to);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            colors[i] = -1;
        }
        System.out.println(getLinkedSorted(graph, colors));
    }


}
