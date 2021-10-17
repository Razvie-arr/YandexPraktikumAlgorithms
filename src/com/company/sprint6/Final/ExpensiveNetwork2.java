package com.company.sprint6.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.*;
import java.lang.*;
import java.io.*;

class MST {
    // Number of vertices in the graph
    private int V;
    public MST(int v) {
        this.V = v;
    }
    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int[] key, Boolean[] mstSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < V + 1; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int[] parent, int[][] graph)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    void primMST(int[][] graph)
    {
        // Array to store constructed MST
        int[] parent = new int[V + 1];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[V + 1];

        // To represent set of vertices included in MST
        Boolean[] mstSet = new Boolean[V + 1];

        // Initialize all keys as INFINITE
        for (int i = 1; i < V + 1; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[1] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[1] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 1; count < V; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 1; v < V + 1; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, graph);
    }
}
// This code is contributed by Aakash Hasija

public class ExpensiveNetwork2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numbers = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from - 1][to - 1] = weight;
        }
        MST t = new MST(n);
        t.primMST(graph);
    }
}