package com.example.lib.geeksforgeeks.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 09/10/17.
 */

public class FibonacciMemoization {

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

        if(ans[n] != 0)
        {
            return ans[n];
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long sum = fibonacci(n - 1) + fibonacci(n - 2);
        ans[n]=sum;
        return sum;
    }
}
