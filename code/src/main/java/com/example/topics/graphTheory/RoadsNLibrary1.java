package com.example.topics.graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 01/11/17.
 */

public class RoadsNLibrary1 {

    public static void main(String[] args) throws IOException {
        RoadsNLibrary1 roadsNLibrary = new RoadsNLibrary1();
//        roadsNLibrary.input();
        roadsNLibrary.testInput();
//        roadsNLibrary.process();
        roadsNLibrary.printAns();
    }


    int q, n, m, cl, cr;
    int u, v;
    LinkedList<Integer>[] nodes;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        q = Integer.parseInt(br.readLine());
        ans = new int[q];

        while (q != 0) {
            String line = br.readLine();

            StringTokenizer st = new StringTokenizer(line);

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            cl = Integer.parseInt(st.nextToken());
            cr = Integer.parseInt(st.nextToken());

            nodes = new LinkedList[n+1];

            visited = new boolean[n+1];

            int roads = m;
            while (roads != 0) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                if(nodes[u]==null)
                {
                    nodes[u] = new LinkedList<>();
                }

                if(nodes[v]==null)
                {
                    nodes[v] = new LinkedList<>();
                }


                nodes[u].add(v);
                nodes[v].add(u);
                roads--;
            }
            process();
            q--;
        }

    }

    public void testInput() {
/*

        n = 6;
        m = 6;
        cl = 2;
        cr = 5;
        String [] lines = new String[]{
            "1 3",
            "3 4",
            "2 4",
            "1 2",
            "2 3",
            "5 6"
        };
*/

        n = 9;
        m = 2;
        cl = 91;
        cr = 84;
        String [] lines = new String[]{
            "8 2",
            "2 9"
        };


        nodes = new LinkedList[n+1];
        visited = new boolean[n+1];

        int roads = m;
        int i=0;
        while (roads != 0) {
            StringTokenizer st = new StringTokenizer(lines[i++]);
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if(nodes[u]==null)
            {
                nodes[u] = new LinkedList<>();
            }

            if(nodes[v]==null)
            {
                nodes[v] = new LinkedList<>();
            }

            nodes[u].add(v);
            nodes[v].add(u);
            roads--;
        }
        process();
    }

    boolean[] visited;

    private int[] ans;
    private int ansIndex=0;
    public void process() {

        int cost1;
        int cost2;
        int minCost = 0;
        for (int i = 1; i < nodes.length; i++) {
            LinkedList<Integer> ll = nodes[i];
            visited[i]=true;
            if(ll!=null) {
                Iterator<Integer> it = ll.iterator();
                while (it.hasNext()) {
                    int node = it.next();
                    if (!visited[node]) {
                        regionLen=0;
                        dfs(node);
                        cost1 = cl + (regionLen * cr);
                        cost2 = (regionLen +1)* cl;

                        if (cost1 < cost2) {
                            minCost += cost1;
                        } else if (cost2 < cost1) {

                            minCost += cost2;
                        } else {
                            minCost += cost1;
                        }
                    }
                }
            }
        }

        int costLib = n* cl;
        if(minCost < costLib)
        {
            ans[ansIndex++]=minCost;
//            System.out.println(minCost);
        }
        else{
            ans[ansIndex++]=costLib;
//            System.out.println(costLib);
        }
    }

    private int regionLen;

    public void dfs(int node) {

        if (!visited[node]) {
            visited[node] = true;
            regionLen++;
            LinkedList<Integer> ll = nodes[node];
            Iterator<Integer> it = ll.iterator();
            while (it.hasNext()) {
                int nextNode = it.next();
                dfs(nextNode);
            }
        }
    }

    private void printAns(){

        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    }
}
