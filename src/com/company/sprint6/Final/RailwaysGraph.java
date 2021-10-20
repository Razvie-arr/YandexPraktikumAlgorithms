package com.company.sprint6.Final;// A Java Program to detect cycle in a graph
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {

    private final int V;
    private final Character[][] ways;

    public Graph(int V, Character[][] ways)
    {
        this.V = V;
        this.ways = ways;
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

        Character[] childs = ways[i];

        for (int j = 0; j < childs.length; j++) {
            if (childs[j] != null) {
                isCyclicUtil(j, visited, recStack);
            }
        }

        recStack[i] = false;

        return false;
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
        Character[][] ways = new Character[n][n];
        //представляем пути как матрицу
        for (int i = 0; i < n; i++) {
            String way = reader.readLine();
            for (int j = 0; j < way.length(); j++) {
                char path = way.charAt(j);
                if (path == 'R') {
                    ways[i][i + 1 + j] = way.charAt(j);
                } else {
                    ways[i + 1 + j][i] = way.charAt(j);
                }
            }
        }
        Graph graph = new Graph(n, ways);
        if (graph.isCyclic())
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}

