package com.example.code.dynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 04/10/17.
 */

public class CoinChange {

    public static void main(String[] args) throws IOException {
        CoinChange coinChange = new CoinChange();
        coinChange.input();
        long ans = coinChange.solve(1, coinChange.make);
        System.out.println(ans);
    }

    int make, numCoins;
    int c[];

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        make = Integer.parseInt(stringTokenizer.nextToken());
        numCoins = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());
        c = new int[52];
        for (int i = 1; i <= numCoins; i++) {
            c[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }


    boolean[][] calculated = new boolean[52][252];
    long table[][] = new long[52][252];

    public long solve(int i, int make) {
        System.out.println("recursive call started");
        System.out.println("i : " +i + " make : "+make);

        if (make < 0) return 0;
        if (make == 0) return 1;
        if (i > numCoins) return 0;

        if (calculated[i][make] == false) {
            System.out.println("i : " + i + " c[i] : "+ c[i]);
            System.out.println("solve(i, make -c[i]) \\+ solve(i+1, make)");
            table[i][make] = solve(i, make -c[i]) + solve(i+1, make);
            System.out.println("table[i][make]: [" +i + "]["+make+ "]="+ table[i][make]);
            calculated[i][make] = true;
            System.out.println("calculated[i][make]: "+true);
        }

        return table[i][make];
    }
}

