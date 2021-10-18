package com.company.sprint6.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class WeightGraph {
    static class Edge {
        private final int from; // Номер первой вершины
        private final int to; // Номер второй вершины
        private final int weight; // Вес

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        public int getOther(int x) {
            assert x == from || x == to;
            return x == from ? to : from;
        }
    }


    private final int vertexNum;
    private final int edgeNum;
    // Взвешенный граф, каждая вершина содержит связанный список с ребрами
    private final List<Edge>[] graph;

    public WeightGraph(int vertexNum, int edgeNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        // Инициализируем список смежности
        graph = (LinkedList<Edge>[]) new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public List<Edge>[] getGraph() {
        return graph;
    }

    public void addEdge(int w, int v, int weight) {
        List<Edge> edges1 = graph[w];
        Edge newEdge1 = new Edge(w, v, weight);
        edges1.add(newEdge1);
        List<Edge> edges2 = graph[v];
        Edge newEdge2 = new Edge(v, w, weight);
        edges2.add(newEdge2);
    }
}

class LazyPrimMST {
    private final WeightGraph graph;
    private final PriorityQueue<WeightGraph.Edge> maxHeap;// Куча, отсортированная по максимуму
    private final boolean[] visited;
    private final List<WeightGraph.Edge> mst;

    public LazyPrimMST(WeightGraph graph) {
        this.graph = graph;
        maxHeap = new PriorityQueue<>(Comparator.comparingInt(WeightGraph.Edge::getWeight).reversed());
        visited = new boolean[graph.getVertexNum()];
        mst = new ArrayList<>();
        visit(0);
        while (!maxHeap.isEmpty()) {
            WeightGraph.Edge minEdge = maxHeap.poll();
            // Оба конца этой стороны были посещены, затем отброшены
            if (visited[minEdge.getFrom()] && visited[minEdge.getTo()]) {
                continue;
            }
            mst.add(minEdge);
            // Продолжаем посещать непосещенные вершины
            if (!visited[minEdge.getFrom()]) {
                visit(minEdge.getFrom());
            } else {
                visit(minEdge.getTo());
            }
        }
    }

    public String getWeight() {
        // Суммируем веса в mst и возвращаем
        int total = 0;
        for (WeightGraph.Edge edge : mst) {
            total += edge.getWeight();
        }
        if ((graph.getVertexNum() > 1 && graph.getEdgeNum() == 0)) {
            return "Oops! I did it again";
        }
        if (graph.getEdgeNum() == 0) {
            return Integer.toString(0);
        }
        if (graph.getGraph().length < 2) {
            return "Oops! I did it again";
        }
        for (boolean b : visited) {
            if (!b) {
                return "Oops! I did it again";
            }
        }
        return Integer.toString(total);
    }

    private void visit(int v) {
        if (visited[v] || v >= graph.getVertexNum()) {
            return;
        }
        // метка доступа
        visited[v] = true;
        // Добавляем смежные края v, которые не были посещены, в наименьшую кучу (ребра с поперечным разрезом)
        for (WeightGraph.Edge edge : graph.getGraph()[v]) {
            // Измененный узел нельзя посещать, иначе это не поперечная кромка
            if (!visited[edge.getOther(v)]) {
                maxHeap.offer(edge);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numbers = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        WeightGraph graph = new WeightGraph(n, m);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.addEdge(from, to, weight);
        }
        LazyPrimMST lazyPrimMST = new LazyPrimMST(graph);
        System.out.println(lazyPrimMST.getWeight());
    }
}

