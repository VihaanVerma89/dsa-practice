package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by vihaan on 25/09/17.
 */

public class MissingNumber {

    public static  void main(String[] args) throws IOException {

        MissingNumber missingNumber = new MissingNumber();
        missingNumber.input();
        missingNumber.process();
    }

    int n,m;
    int freq[] = new int[101];
    int array[] = new int[101];
    public  void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        int number, index;
        while(stringTokenizer.hasMoreElements())
        {
            number = Integer.parseInt(stringTokenizer.nextToken());
            index = number%101;
            freq[index]--;
            array[index]=number;
        }

        m = Integer.parseInt(br.readLine());

        line = br.readLine();
        stringTokenizer = new StringTokenizer(line);

        while(stringTokenizer.hasMoreElements())
        {
            number = Integer.parseInt(stringTokenizer.nextToken());
            index = number%101;
            freq[index]++;
            array[index]=number;
        }

    }

    public  void testInput() {

    }

    public  void process() {

        for(int i=0;i<array.length;i++)
        {
            if(freq[i]>0 && i!=array.length-1)
            {
                System.out.print(array[i]+" ");
            }
            else if(freq[i]>0)
            {
                System.out.print(array[i]);
            }
        }

    }
}
