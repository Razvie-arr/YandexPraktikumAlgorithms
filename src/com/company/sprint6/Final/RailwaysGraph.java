package com.company.sprint6.Final;// A Java Program to detect cycle in a graph
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {

    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V)
    {
        this.V = V;
        adj = new LinkedList<>();

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            String way = reader.readLine();
            for (int j = 0; j < way.length(); j++) {
                char path = way.charAt(j);
                if (path == 'R') {
                    graph.addEdge(i, i + 1 + j);
                } else {
                    graph.addEdge(i + 1 + j, i);
                }
            }
        }
        if (graph.isCyclic())
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}

