package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by vihaan on 19/09/17.
 */

public class KnightL {

    public static void main(String[] args) throws IOException {
        KnightL knightL = new KnightL();
        knightL.input();
        knightL.process();
    }

    int n;
    LinkedList<String> q = new LinkedList<>();
    Map<String, Integer> visited = new HashMap<String, Integer>();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    public void process() {
        int result;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result = bfs(i , j);
                if (j == 1) {
                    System.out.print(result);
                } else {
                    System.out.print(" " + result);
                }
            }
            System.out.println();
        }
    }

    public int bfs(int a, int b) {
        int result = -1;

        int ni;
        int nj;

        String parentKey = "0,0";
        visited.clear();
        visited.put(parentKey, 0);
        q.add(parentKey);


        while (q.size() != 0) {

            String poppedKey = q.pop();
            String [] indexes = poppedKey.split(",");
            int ci=Integer.parseInt(indexes[0]);
            int cj=Integer.parseInt(indexes[1]);

            for (int mi = -1; mi <= 1; mi += 2) {
                for (int mj = -1; mj <= 1; mj += 2) {
                    ni = ci + (mi * a);
                    nj = cj + (mj * b);

                    visitNode(poppedKey, ni,nj);
                }
            }

            for (int mi = -1; mi <= 1; mi += 2) {
                for (int mj = -1; mj <= 1; mj += 2) {
                    ni = ci + (mi * b);
                    nj = cj + (mj * a);

                    visitNode(poppedKey, ni,nj);
                }
            }

        }

        int temp = n-1;
        String lastNode = temp+","+temp;
        if(visited.containsKey(lastNode))
        {
            result = visited.get(lastNode);
        }

//        System.out.println("knightL["+a+","+b+"]="+result);
        return result;
    }

    private void visitNode(String poppedKey, int ni, int nj)
    {

                    if (ni < 0 || nj < 0 || ni >= n || nj >= n) {
//                        System.out.println("invalid value");
//                        System.out.println("[ni,nj]=" + ni + "," + nj);
                        return;
                    }

                    String key = ni + "," + nj;
                    if (visited.containsKey(key)) {
                        // node already visited.
                    } else {
                        int parentStepCount;
                        if (visited.containsKey(poppedKey)) {
                            parentStepCount = visited.get(poppedKey);
                            parentStepCount++;
                            visited.put(key, parentStepCount);
                            q.add(key);
                        }
                    }

    }


}
