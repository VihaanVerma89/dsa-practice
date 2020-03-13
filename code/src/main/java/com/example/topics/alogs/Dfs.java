package com.example.topics.alogs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by vihaan on 01/10/17.
 */

public class Dfs {

    public static void main(String[] args) {
        Dfs dfs = new Dfs(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.start(2);

    }

    LinkedList<Integer> graph[];
    boolean[] visited;

    int nodes;

    public Dfs(int nodes) {
        this.nodes = nodes;
        graph = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int node, int node1) {
        graph[node].add(node1);
    }

    public void start(int node) {
        visited = new boolean[graph.length];
        traverse(node);
    }

    public void traverse(int node) {

        visited[node] = true;
        System.out.println(node);

        LinkedList<Integer> linkedList = graph[node];
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(!visited[next])
            {
                traverse(next);
            }
        }
    }



}
