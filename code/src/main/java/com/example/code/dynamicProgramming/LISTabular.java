package com.example.code.dynamicProgramming;

/**
 * Created by vihaan on 10/10/17.
 */

public class LISTabular {


    public  static void main(String [] args)
    {

        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "n" );
    }

    public  static int lis(int array[], int n)
    {
        int lis[]= new int[n];

        int i,j,max;

        for(i=0;i<n;i++)
        {
            lis[i]=1;
        }

        for(i=1;i<n;i++)
        {
            for(j=0;j<i;j++)
            {

                if(array[i]> array[j] && lis[i] < lis[j]+1)
                {
                    lis[i]=lis[j]+1;
                }
            }
        }

        return 0;

    }









































}
