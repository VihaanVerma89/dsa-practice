package com.example.topics.alogs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vihaan on 28/10/17.
 */

public class Dijkstras {

    public static void main(String[] args) {
        Dijkstras dijkstras = new Dijkstras();

        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstras.printShortestPath(graph, 0);
        dijkstras.print();
    }


    public Dijkstras() {

    }

    private Set<Integer> mVisitedNodes;
    private int[] visitCost;

    public void printShortestPath(int[][] graph, int startingVertex) {
        visitCost = new int[graph.length];
        mVisitedNodes = new HashSet<>();

        Arrays.fill(visitCost, Integer.MAX_VALUE);

        visitCost[startingVertex] = 0;

        while (mVisitedNodes.size() != graph.length) {
            mVisitedNodes.add((startingVertex));
            for (int i = 0; i < graph[startingVertex].length; i++) {

                if (graph[startingVertex][i] != 0) {
                    int cost = graph[startingVertex][i];
                    int visitingCost = cost + visitCost[startingVertex];
                    if (visitingCost < visitCost[i] && !mVisitedNodes.contains(i)) {
                        visitCost[i] = visitingCost;
                    }
                }
            }
            startingVertex = getNearestVertex();
        }
    }

    public void print()
    {
        System.out.println("Vertex \t Distance");
        for(int i=0;i<visitCost.length;i++)
        {
            System.out.println(i+"\t"+visitCost[i]);
        }
    }


    public int getNearestVertex() {
        int min = Integer.MAX_VALUE;
        int vertex = 0;

        for (int i = 0; i < visitCost.length; i++) {
            boolean visited = mVisitedNodes.contains(i);
            if (!visited && visitCost[i] < min) {
                min = visitCost[i];
                vertex = i;
            }
        }
        return vertex;
    }
































}
