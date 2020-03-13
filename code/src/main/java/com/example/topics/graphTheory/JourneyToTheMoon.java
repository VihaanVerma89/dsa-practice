package com.example.topics.graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 6/11/17.
 */

public class JourneyToTheMoon {

    public static void main(String[] args) throws IOException {
        JourneyToTheMoon journeyToTheMoon = new JourneyToTheMoon();
        journeyToTheMoon.input();
//        journeyToTheMoon.testInput();
        long count = journeyToTheMoon.getPairs();
        System.out.println(count);
    }

    private int n, p;
    private LinkedList<Integer>[] nodes;

    public void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        n = Integer.parseInt(tokenizer.nextToken());
        p = Integer.parseInt(tokenizer.nextToken());

        nodes = new LinkedList[n];
        visited = new boolean[n];

        int p1, p2;
        while (p != 0) {
            line = br.readLine();
            String[] parts = line.split(" ");
            p1 = Integer.parseInt(parts[0]);
            p2 = Integer.parseInt(parts[1]);


            if (nodes[p1] == null) {
                nodes[p1] = new LinkedList<>();
            }

            nodes[p1].add(p2);

            if (nodes[p2] == null) {
                nodes[p2] = new LinkedList<>();
            }

            nodes[p2].add(p1);
            p--;
        }
    }


    public void testInput() {

        n = 5;
        p = 3;

        String lines[] = new String[]{
                "0 1",
                "2 3",
                "0 4"
        };

//
//        n = 10;
//        p = 7;
//        String lines[] = new String[]{
//                "0 2",
//                "1 8",
//                "1 4",
//                "2 8",
//                "2 6",
//                "3 5",
//                "6 9"
//        };

        int p1, p2;
        int i = 0;
        nodes = new LinkedList[n];
        visited = new boolean[n];
        while (p != 0) {
            String[] parts = lines[i++].split(" ");
            p1 = Integer.parseInt(parts[0]);
            p2 = Integer.parseInt(parts[1]);


            if (nodes[p1] == null) {
                nodes[p1] = new LinkedList<>();
            }

            nodes[p1].add(p2);

            if (nodes[p2] == null) {
                nodes[p2] = new LinkedList<>();
            }

            nodes[p2].add(p1);
            p--;
        }
    }

    public long getPairs() {
        long pairs = 0;

        long numberOfWaysFromSameCountry = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (visited[i] == false) {
                depth = 0;
                dfs(i);
                numberOfWaysFromSameCountry += getWaysOfSelection(depth, 2);
            }
        }

        long totalWays = getWaysOfSelection(n, 2);

        pairs = totalWays - numberOfWaysFromSameCountry;
        return pairs;
    }

    private long getWaysOfSelection(long n, long r) {
//        int result = factorial(n) / ((factorial(r) * factorial(n - r)));
        long result = n * (n-1);
        return result/2;
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    int depth = 0;
    boolean visited[];

    public void dfs(int node) {
        if (!visited[node]) {
            depth++;
            visited[node] = true;
            LinkedList<Integer> ll = nodes[node];
            if (ll != null) {
                Iterator<Integer> it = ll.iterator();
                while (it.hasNext()) {
                    int nextNode = it.next();
                    dfs(nextNode);
                }
            }
        }
    }

}
