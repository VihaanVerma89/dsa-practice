package com.example.topics.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 29/09/17.
 */

public class PairsArray {

    public static void main(String [] args) throws IOException {
        PairsArray pairs = new PairsArray();
        pairs.input();
        pairs.process();
    }

    int n, k;
    int array[];
    int freq[];
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String parts[] = line.split(" ")    ;
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);

        line = br.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(line);

        array = new int[n];
        freq = new int[Integer.MAX_VALUE-8];
        int i=0;
        int count=0;
        while(stringTokenizer.hasMoreTokens())
        {
            array[i]= Integer.parseInt(stringTokenizer.nextToken());
            int sum = array[i]+ k;
            int diff = Math.abs(array[i] - k);

            if(freq[sum]==0)
            {
               // number  doesn't exist.
            }
            else
            {
                //smaller, bigger pair found.
               count++;
            }

            if(freq[diff] == 0)
            {

            }
            else
            {
                // bigger , smaller pair found.
                count++;
            }

        }

        System.out.println(count);
    }

    public void testInput()
    {

    }

    public void process()
    {

    }
}
