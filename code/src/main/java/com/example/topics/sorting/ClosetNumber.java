package com.example.topics.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 4/9/17.
 */

public class ClosetNumber {


    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);

        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            array[i++] = Integer.parseInt(tokenizer.nextToken());
        }
    }


    public static void testInput() {

    }

    static ArrayList<String> minDiff = new ArrayList<>();

    public static void process() {
        Arrays.sort(array);

        int diff = Integer.MAX_VALUE;
        int currentDiff;
        for (int i = 0; i < n - 1; i++) {
            currentDiff = array[i + 1] - array[i];
            if (currentDiff < diff) {
                diff = currentDiff;
                minDiff.clear();
                addToMinDiff(array[i], array[i + 1]);
            } else if (currentDiff == diff) {
                addToMinDiff(array[i], array[i + 1]);
            }
        }

        for (int i = 0; i < minDiff.size(); i++) {
            System.out.print(minDiff.get(i) + " ");
        }
    }

    public static void addToMinDiff(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(" ");
        sb.append(j);


        minDiff.add(sb.toString());
    }


}
