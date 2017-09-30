package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 29/09/17.
 */

public class Pairs {

    public static void main(String [] args) throws IOException {
        Pairs pairs = new Pairs();
        pairs.input();
    }

    int n, k;
    int array[];
    Map<Integer, Integer> freqMap;
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String parts[] = line.split(" ")    ;
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);

        line = br.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(line);

        array = new int[n];
        freqMap = new HashMap<>();
        int i=0;
        int count=0;
        while(stringTokenizer.hasMoreTokens())
        {
            array[i]= Integer.parseInt(stringTokenizer.nextToken());
            int sum = array[i]+ k;
            int diff = array[i] - k;

            freqMap.put(array[i], 0);
            if(freqMap.containsKey(sum))
            {
                count++;
            }

            if(freqMap.containsKey(diff))
            {
                count++;
            }


        }

        System.out.println(count);
    }

}
