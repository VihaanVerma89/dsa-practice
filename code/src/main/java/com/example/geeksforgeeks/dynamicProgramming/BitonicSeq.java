package com.example.geeksforgeeks.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Created by vihaanverma on 12/12/17.
 */

public class BitonicSeq {

    public static void main(String []args) throws IOException {
        BitonicSeq bitonicSeq = new BitonicSeq();
        bitonicSeq.input();
        int max = bitonicSeq.process(bitonicSeq.array);
        System.out.println(max);
    }

    int array[];
    public void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String []parts =line.split(",");
        array = new int[parts.length];
        int i=0;
        for(String s: parts)
        {
            array[i]=Integer.parseInt(parts[i].trim());
            i++;
        }
    }

    public int process(int [] array)
    {
        int [] increasingCount = getIncreasingArray(array);
        int [] decreasingCount = new int[array.length];
        Arrays.fill(decreasingCount,1);
        getDecreasingArray(array, 0, decreasingCount);

        int max = increasingCount[0]+decreasingCount[0];
        int sum;
        for(int i=1;i<array.length;i++)
        {
            sum = increasingCount[i]+decreasingCount[i];
            max= Math.max(sum, max);
        }

        if(max>1)
        {
            max-=1;
        }
        return max;
    }

    public int [] getIncreasingArray(int [] array)
    {
        int []result = null;
        if(array.length>0)
        {
            result = new int[array.length];
            Arrays.fill(result,1);
            int j;
            for(int i=1;i<array.length;i++)
            {
                j=i-1;
                while(j>=0)
                {
                    if(array[j]<array[i])
                    {
                        result[i]=1+result[j];
                        break;
                    }
                    j--;
                }
            }
        }


        return result;
    }

    public int getDecreasingArray(int [] array, int start, int result[])
    {

        if(array.length>0)
        {
            int j=start+1;
            if(j==array.length)
            {
                return 1;
            }
            if(result[start]!=1)
            {
                return result[start];
            }
            for(int i=start;i<array.length;i++)
            {
                j=i+1;
                while(j<array.length)
                {
                    if(array[i]>array[j])
                    {
                        int max = 1 + getDecreasingArray(array, j, result);
                        result[i]=Math.max(result[i], max);
                    }
                    j++;
                }
            }

        }
        return result[start];
    }
}
