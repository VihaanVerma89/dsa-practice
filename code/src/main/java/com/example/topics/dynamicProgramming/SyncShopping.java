package com.example.topics.dynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

            int start = Integer.parseInt(parts[0])-1;
            int end = Integer.parseInt(parts[1])-1;
            int len = Integer.parseInt(parts[2]);

            edges[start].add(new Edge(start, end, len));
            edges[end].add(new Edge(end, start, len));
        }

        long[][] dist = dijkstras(0, edges,cityMask);

        long ans = INF;
        for(int mask1=0;mask1< 1<<k; ++mask1)
        {
            int complement = (1<<k)-1-mask1;
            for(int mask2=complement;mask2< 1<<k; mask2 =(mask2+1)|complement)
            {
                long time = Math.max(dist[n-1][mask1], dist[n-1][mask2]);
                ans = Math.min(ans,time);
            }
        }


        System.out.println(ans);
    }

    private void solve() {
        dijkstras(0, edges, cityMask);
    }

    static final long INF = 1000000000000000000L;
    private long[][] dijkstras(int start, ArrayList<Edge>[] edges, int[] cityMask) {

        long distance[][] = new long[edges.length][1 << k];

        for(long [] ar: distance)
        {
            Arrays.fill(ar,INF);
        }

        Node startingNode = new Node(start, cityMask[start], 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(startingNode);

        distance[start][cityMask[start]]=0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.distance != distance[node.id][node.mask])
            {
                continue;
            }

            for (Edge e : edges[node.id]) {
                long nDistance = distance[e.start][node.mask] + e.len;
                int newMask = node.mask | cityMask[e.end];
                if (nDistance < distance[e.end][newMask]) {
                    distance[e.end][newMask] = nDistance;
                    pq.add(new Node(e.end, newMask, nDistance));
                }
            }
        }

        return distance;
    }

    class Node implements Comparable<Node> {
        int id;
        int mask;
        long distance;

        public Node(int id, int mask, long distance) {
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

        public long getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
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
