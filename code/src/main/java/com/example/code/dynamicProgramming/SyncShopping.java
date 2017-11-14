package com.example.code.dynamicProgramming;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * Created by vihaan on 13/11/17.
 */

public class SyncShopping {

    public static void main(String[] args) throws IOException {
        SyncShopping syncShopping = new SyncShopping();
        syncShopping.input();
        syncShopping.solve();
    }

    private int n, m, k;
    private ArrayList<Edge> edges[];
    private int[] cityMask;

    public void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] parts = line.split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        k = Integer.parseInt(parts[2]);

        int t, fish;

        edges = new ArrayList[n];

        cityMask = new int[n];

        int i;
        for (i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (i = 0; i < n; i++) {
            line = br.readLine();
            parts = line.split(" ");
            for (int j = 1; j < parts.length; j++) {
                fish = Integer.parseInt(parts[j]);
                cityMask[i] |= (1 << (fish - 1));
            }
        }

        for (i = 0; i < n; i++) {
            line = br.readLine();
            parts = line.split(" ");

            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int len = Integer.parseInt(parts[2]);

            edges[start].add(new Edge(start, end, len));
            edges[end].add(new Edge(start, end, len));
        }


    }

    private void solve() {
        dijkstras(0, edges, cityMask);
    }

    private void dijkstras(int start, ArrayList<Edge>[] edges, int[] cityMask) {

        int distance[][] = new int[edges.length][1 << k];

        Node startingNode = new Node(start, cityMask[start], 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(startingNode);

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Edge e : edges[node.id]) {
                int nDistance = distance[e.start][node.mask] + e.len;
                int newMask = node.mask | cityMask[e.end];
                if (nDistance < distance[e.end][newMask]) {
                    distance[e.end][newMask] = nDistance;
                    pq.add(new Node(e.end, newMask, nDistance));
                }
            }
        }
    }

    class Node implements Comparable<Node> {
        int id, mask, distance;

        public Node(int id, int mask, int distance) {
            this.id = id;
            this.mask = mask;
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMask() {
            return mask;
        }

        public void setMask(int mask) {
            this.mask = mask;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(@NonNull Node node) {
            return Long.compare(distance, node.distance);
        }
    }

    class Edge {
        int start, end;
        int len;

        public Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }
}
