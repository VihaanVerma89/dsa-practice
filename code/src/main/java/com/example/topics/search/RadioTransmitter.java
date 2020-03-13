package com.example.topics.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 6/9/17.
 */


public class RadioTransmitter {

    public static void main(String[] args) throws IOException {

        input();
        process();
    }

    static int n, k;
    static int[] array;

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] parts = line.split(" ");

        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);

        array = new int[n];

        String arrayLine = br.readLine();

        StringTokenizer tokenizer = new StringTokenizer(arrayLine, " ");
        int i=0;
        while(tokenizer.hasMoreTokens())
        {
            array[i++] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void testInput() {

    }

    public static void process() {
        Arrays.sort(array);

        int loc;

        int t = 0;
        int i = 0;


        while (i < n) {

            loc = array[i] + k;
            while (i<n && array[i] <= loc) {
                i++;
            }

            if(array[i-1] <= loc)
            {
                i--;
            }

            loc = array[i]+k;

            while(i<n && array[i] <= loc)
            {
                i++;
            }

            t++;
        }

        System.out.println(t);

    }


}
