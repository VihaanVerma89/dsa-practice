package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

/**
 * Created by vihaan on 16/9/17.
 */

public class IceCreamParlor {

    static int t, m, n;
    static int[] array;

    public static void main(String[] args) throws IOException {

        input();

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            m = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            array = new int[n];

            String [] numbers = br.readLine().split(" ");
            for(int j=0;j<numbers.length;j++)
            {
                array[j] = Integer.parseInt(numbers[j]);
            }
            process();
        }
    }

    public static void testInput() {

    }

    static int [] freq;
    public static void process() {

        freq = new int[10000];
        int id1=0, id2;
        int requiredNumber=0;
        for(int i=0;i<n;i++)
        {
            int number = array[i];
            freq[number]++;
            requiredNumber = m - number;

            if(requiredNumber > 0 )
            {
                if(freq[requiredNumber] == 0)
                {
                    // number doesn't exist;
                }
                else{
                    if(freq[requiredNumber] ==1 && (number == requiredNumber) )
                    {
                       //referring to self
                        continue;
                    }
                    id1 = i;
                    break;
                }
            }
        }

        for(int j=0; j<=id1 ; j++)
        {
            if(array[j]==requiredNumber)
            {
                id2 = j;
                id2++;
                id1++;
                if(id1< id2)
                {
                    System.out.print(id1);
                    System.out.print(" " + id2);
                }
                else{

                    System.out.print(id2);
                    System.out.print(" " + id1);
                }
                System.out.println();
                break;
            }
        }

    }
}
