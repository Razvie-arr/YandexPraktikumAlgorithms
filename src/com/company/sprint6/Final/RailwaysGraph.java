/*
https://contest.yandex.ru/contest/25070/run-report/55310369/
-- ПРИНЦИП РАБОТЫ --
В обсуждениях Slack увидел отличную идею: при формировании графа можно менять направление ребра.
Представляем граф как матрицу, это позволило в несколько раз ускорить алгоритм и сэкономить память.
Если дорога имеет тип 'R', кладем ее в матрицу в обычном направлении, если имеет тип 'B' переворачиваем ребро.
Это позволяет нам найти путь от точки А до точки Б с разными типами дорог с помощью простого поиска цикла в графе: если граф имеет цикл, то можно определенно
назвать его неоптимальным.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Сложность как в DFS: проверяем каждое ребро каждой вершины O(V + E)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
O(V^2) - храним матрицу n * n
O(V) - храним состояние каждой вершины в VertexState

Получаем O(V^2 + V)
 */

package com.company.sprint6.Final;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Graph {
    public enum VertexState {
        VISITED,
        RecSTACK
    }
    private final int V;
    private final Character[][] ways;

    public Graph(int V, Character[][] ways)
    {
        this.V = V;
        this.ways = ways;
    }

    private boolean isCyclicUtil(int i, VertexState[] state) {
        if (state[i] == VertexState.RecSTACK)
            return true;
        if (state[i] == VertexState.VISITED)
            return false;
        state[i] = VertexState.RecSTACK;
        Character[] childs = ways[i];
        for (int j = 0; j < childs.length; j++) {
            if (childs[j] != null) {
                if (isCyclicUtil(j, state)) {
                    return true;
                }
            }
        }

        state[i] = VertexState.VISITED;
        return false;
    }

    private boolean isCyclic()
    {
        VertexState[] state = new VertexState[V];
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, state))
                return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Character[][] ways = new Character[n][n];
        //представляем пути как матрицу
        for (int i = 0; i < n - 1; i++) {
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

