package com.example.topics.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 02/10/17.
 */

public class ConnectedCells {

    public static void main(String[] args) throws IOException {
        ConnectedCells connectedCells = new ConnectedCells();
        connectedCells.input();
    }

    int n, m;
    int array[][];

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            String parts[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(parts[j]);
            }
        }

        start();
        System.out.println(max);
    }

    private int visitedArray[][];

    public void start() {

        visitedArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1 && visitedArray[i][j] == 0) {
                    len = 1;
                    traverse(i, j);
                }
            }
        }
    }

    public void testInput() {

    }

    int max;
    int len;

    public void traverse(int ti, int tj) {

        visitedArray[ti][tj] = 1;

        int ni, nj;
        for (int i = -1; i <= 1; i++) {
            ni = ti + i;
            for (int j = -1; j <= 1; j++) {
                nj = tj + j;
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {

                    if (array[ni][nj] == 1) {
                        if (visitedArray[ni][nj] == 0) {
                            len++;
                            traverse(ni, nj);
                        }
                    }
                }
            }
        }

        max = Math.max(max, len);
    }


}
