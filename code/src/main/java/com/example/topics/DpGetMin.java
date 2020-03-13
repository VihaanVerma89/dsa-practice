package com.example.topics;

/**
 * Created by vihaan on 11/08/17.
 */

public class DpGetMin {

    public static void main(String[] args) {
        int n = 5;
        memo = new int[n+1];


        int result = getMinSteps(n);
        System.out.println(result);

    }

    static int memo[];

    static int getMinSteps(int n) {
        int r =0;
        try {
            if (n == 1) return 0;  // base case
            if (memo[n] != 0) return memo[n];  // we have solved it already :)
            r= 1 + getMinSteps(n - 1);  // '-1' step .  'r' will contain the optimal answer finally
            if (n % 2 == 0) r = Math.min(r, 1 + getMinSteps(n / 2));  //  '/2' step
            if (n % 3 == 0) r = Math.min(r, 1 + getMinSteps(n / 3));  //  '/3' step
            memo[n] = r;  // save the result. If you forget this step, then its same as plain recursion.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }
}
