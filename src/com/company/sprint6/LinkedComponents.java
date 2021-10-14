package com.company.sprint6;
import java.io.BufferedReader;
import java.io.FileReader;
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
                connectedComponents.put(colors[i], new ArrayList<>(Collections.singletonList(i)));
            }
        }
        connectedComponents.forEach((key, value) -> {
            String values = value.toString().replace(",", "");
            out.append(values, 1, values.length() - 1).append("\n");
        });
        out.delete(out.length() - 1, out.length());
        return out.toString();
    }

    public static void linkSort(int v, LinkGraph graph, int[] colors, int componentCount) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(v);
        while (!deque.isEmpty()) {
            int tempVertex = deque.pop();
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
        BufferedReader reader = new BufferedReader((new FileReader("/Users/razviearr/PetProjects/Yandex-Praktikum-Algorithms/src/com/company/sprint6/test.txt")));
        StringTokenizer numbers = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        LinkGraph graph = new LinkGraph(n);
        long graphFillStart = System.currentTimeMillis();

        long tokenizerFromToTime = 0;
        long graphAddEdgeTime = 0;
        for (int i = 0; i < m; i++) {
            long tokenStart = System.currentTimeMillis();
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long tokenEnd = System.currentTimeMillis();
            tokenizerFromToTime = tokenizerFromToTime + (tokenEnd - tokenStart);
            long graphStart = System.currentTimeMillis();
            graph.addEdge(from, to);
            long graphEnd = System.currentTimeMillis();
            graphAddEdgeTime = graphAddEdgeTime + (graphEnd - graphStart);
        }

        long graphFillEnd = System.currentTimeMillis();
        long fillColorStart = System.currentTimeMillis();
        int[] colors = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            colors[i] = -1;
        }
        long fillColorEnd = System.currentTimeMillis();
        long sortStart = System.currentTimeMillis();
        String linkedSorted = getLinkedSorted(graph, colors);
        long sortEnd = System.currentTimeMillis();
        long printComponentStart = System.currentTimeMillis();
        System.out.println(linkedSorted);
        long printComponentEnd = System.currentTimeMillis();

        System.out.println("Создание вершин для графа: " + (graphFillEnd - graphFillStart));
        System.out.println("Создание и заполнение массива с цветами: " + (fillColorEnd - fillColorStart));
        System.out.println("Основной алгоритм: " + (sortEnd - sortStart));
        System.out.println("Время вывода: " + (printComponentEnd - printComponentStart));
        System.out.println();
        System.out.println("Новые данные");
        System.out.println("Токен и фромту: " + tokenizerFromToTime);
        System.out.println("Заполнение графа: " + graphAddEdgeTime);
    }


}
