package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private int v;
    private LinkedList<Integer> adj[];
    TopologicalSort(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void topology() {
        Stack stack = new Stack();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                topologyUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void topologyUtil(int vertex, boolean visited[], Stack stack) {
        visited[vertex] = true;

        Iterator<Integer> iterator = adj[vertex].iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(!visited[i]) {
                topologyUtil(i, visited, stack);
            }
        }
        stack.push(vertex);

    }

    public static void main(String[] args) {
        int v = 6;
        TopologicalSort g = new TopologicalSort(v);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topology();
    }
}
