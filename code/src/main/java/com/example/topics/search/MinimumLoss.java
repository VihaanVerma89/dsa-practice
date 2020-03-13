
package com.example.topics.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class MinimumLoss {

    public static void main(String[] args) throws IOException {
        MinimumLoss minimumLoss = new MinimumLoss();
        minimumLoss.input();
        minimumLoss.process();
    }


    int n;
    long [] array;
    Map<Long, Integer> positionMap;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new long[n];
        String line = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        int i =0;
        positionMap = new HashMap<Long,Integer>();
        while(stringTokenizer.hasMoreTokens())
        {
            array[i]= Long.parseLong(stringTokenizer.nextToken());
            positionMap.put(array[i], i);
            i++;
        }
    }

    public void testInput() {

    }

    public void process() {

        Arrays.sort(array);

        long min = Long.MAX_VALUE;
        long diff;

        for(int i=0;i<array.length-1;i++)
        {
            diff = array[i+1] - array[i];
            if(diff < min)
            {
                long nextPos = positionMap.get(array[i+1]);
                long prevPos = positionMap.get(array[i]);
                if(nextPos < prevPos)
                {
                    min = diff;
                }
            }
        }

        System.out.println(min);

    }









































}