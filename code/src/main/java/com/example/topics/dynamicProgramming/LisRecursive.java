package com.example.topics.dynamicProgramming;

/**
 * Created by vihaan on 11/10/17.
 */

public class LisRecursive {

    public static void main(String[] args) {

        int array[] = new int[]{3, 10, 2, 1, 20};
        lis(array, array.length);
    }

    static int max =1;
    public static int lis(int array[], int n) {

        if(n==1)
        {
            return 1;
        }

        int res, max_ending_here=0;

        for(int i=1;i<n ;i++)
        {
            res = lis(array,i);

            if(array[i-1]< array[n-1]  )
            {
                max_ending_here = res + 1;
            }
        }

        return max_ending_here;
    }
}
