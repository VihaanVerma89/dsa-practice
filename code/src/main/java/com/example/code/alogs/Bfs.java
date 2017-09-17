package com.example.code.alogs;

import android.opengl.Visibility;

import java.security.cert.TrustAnchor;
import java.util.Iterator;
import java.util.LinkedList;

import static com.example.code.sorting.QuickSort1.n;

/**
 * Created by vihaan on 17/9/17.
 */

public class Bfs {

    private int nodes;
    private LinkedList<Integer>[] graph;

    public Bfs(int nodes) {
        this.nodes = nodes;
        graph = new LinkedList[nodes];
        for(int i=0;i<nodes;i++)
        {
            graph[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int e) {
        graph[s].add(e);
    }

    public void traverse(int node) {

        boolean visited[] = new boolean[nodes];
        visited[node] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() != 0) {

            int nextNode = queue.poll();
            System.out.print(nextNode + " ");
            Iterator<Integer> iterator = graph[nextNode].iterator();
            while (iterator.hasNext()) {
                int tempNode = iterator.next();
                if(!visited[tempNode])
                {
                    visited[tempNode] = true;
                    queue.add(tempNode);
                }
            }
        }


    }


    public static void main(String[] args) {

        Bfs bfs = new Bfs(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        bfs.traverse(2);
    }


}
