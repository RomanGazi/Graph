package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    private int v;
    private LinkedList<Integer> adj[];
    DFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void depthFirstSearch() {
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
            }
        }

    }

    private void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " " );

        Iterator<Integer> iterator = adj[i].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(!visited[next]) {
                DFSUtil(next,visited);
            }
        }

    }

    public static void main(String[] args) {
        int vertex = 5;
        DFS graph = new DFS(vertex);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(0,2);
        graph.depthFirstSearch();
    }
}
