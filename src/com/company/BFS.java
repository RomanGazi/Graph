package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int v;
    private LinkedList<Integer> adj[];
     BFS(int v) {
         this.v = v;
         adj = new LinkedList[v];
         for (int i = 0; i < v; i++) {
             adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    void breadthFirstSearch(int source) {

        boolean visited [] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (queue.size() != 0) {
            source = queue.poll();
            System.out.print(source + " ");
            Iterator<Integer> i = adj[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        BFS graph = new BFS(vertex);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(0,2);
        graph.breadthFirstSearch(1);
    }

}
