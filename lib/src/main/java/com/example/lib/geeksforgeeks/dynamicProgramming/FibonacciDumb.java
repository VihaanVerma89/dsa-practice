package com.example.lib.geeksforgeeks.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 09/10/17.
 */

public class FibonacciDumb {

    public  static void main(String [] args) throws IOException {
        FibonacciDumb fibonacciDumb = new FibonacciDumb();
        fibonacciDumb.input();
    }

    int n;
    public  void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       n = Integer.parseInt(br.readLine());
       long startTime = System.currentTimeMillis();
       System.out.println("start time: " + startTime);
       int ans = fibonacci(n);
       System.out.println(ans);
        long endTime = System.currentTimeMillis();
        System.out.println("end time: " + endTime);

        long diff = endTime -startTime;
        System.out.println("time taken: " + diff);
    }

    public  void testInput()
    {

    }

    public  int fibonacci(int n)
    {
        if(n==0)
        {
            return 0;
        }
        else if(n ==1)
        {
            return 1;
        }

        int ans = fibonacci(n-1)+fibonacci(n-2);

        return ans;
    }
}
