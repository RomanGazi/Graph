package com.company;

import java.util.LinkedList;

public class Main {
    static class Graph {
        int v;
        LinkedList<Integer> adjListArray[];
        Graph(int v) {
            this.v = v;
            adjListArray = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjListArray[i] = new LinkedList<>();
            }

        }
    }

    static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    static void print(Graph graph) {
        for (int i = 0; i < graph.v; i++) {
            System.out.print("Adjacency List of Vertex: " + i);
            for (Integer pCrawl: graph.adjListArray[i]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        Graph graph = new Graph(vertex);
        addEdge(graph,0,1);
        addEdge(graph,1,2);
        addEdge(graph,2,3);
        addEdge(graph,3,4);
        addEdge(graph,4,0);
        print(graph);

    }
}
