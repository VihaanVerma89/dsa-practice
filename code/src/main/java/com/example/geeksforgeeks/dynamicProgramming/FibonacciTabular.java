package com.example.geeksforgeeks.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 09/10/17.
 */

public class FibonacciTabular {

    public static void main(String[] args) throws IOException {
        FibonacciMemoization fibonacciDumb = new FibonacciMemoization();
        fibonacciDumb.input();
    }

    int n;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new long[n+1];
        long startTime = System.currentTimeMillis();
        System.out.println("start time: " + startTime);
        long sum = fibonacci(n);
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("end time: " + endTime);

        long diff = endTime - startTime;

        System.out.println("time taken: " + diff);
    }

    public void testInput() {

    }

    long ans[];

    public long fibonacci(int n) {

        ans[0]=0;
        ans[1]=1;

        for(long i=2; i<=n;i++)
        {
           ans[(int)i]= ans[(int)i-1]+ans[(int)i-2];
        }

        return ans[n];
    }






































































































}
