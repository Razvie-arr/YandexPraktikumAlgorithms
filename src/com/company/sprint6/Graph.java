package com.company.sprint6;// Java program to print DFS
//mtraversal from a given given
// graph
import java.io.*;
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Graph {
    private int V; // No. of vertices

    // Array of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
        adj[w].add(v);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[], StringBuilder out)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        out.append(v).append(" ");

        // Recur for all the vertices adjacent to this
        // vertex
        Collections.sort(adj[v]);
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, out);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    StringBuilder DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        StringBuilder out = new StringBuilder();
        DFSUtil(v, visited, out);
        out.delete(out.length() - 1, out.length());
        return out;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String[] numbers = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        if (n < 1 || n > 100000) {
            throw new Exception("Invalid n");
        }
        if (m < 0 || m > 100000) {
            throw new Exception("Invalid m");
        }

        Graph g = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            String[] rib = reader.readLine().trim().split("\\s+");
            int from = Integer.parseInt(rib[0]);
            int to = Integer.parseInt(rib[1]);
            g.addEdge(from, to);
        }
        int startVertex = Integer.parseInt(reader.readLine());
        System.out.println(g.DFS(startVertex));
    }
}
