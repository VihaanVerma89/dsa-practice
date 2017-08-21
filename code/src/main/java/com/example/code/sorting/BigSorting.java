package com.example.code.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by vihaan on 21/08/17.
 */

public class BigSorting {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String [] unsorted = new String[n];


        for(int i=0;i<n;i++)
        {
            unsorted[i] = scanner.next();
        }


        printSortedArray(unsorted);

    }

    public static void printSortedArray(String[] array)
    {
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length())
                {
                    return 1;
                }
                else if(s1.length() < s2.length())
                {
                    return -1;
                }

                for(int i=0; i<s1.length(); i++)
                {
                    if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
                    if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
                }

                return 0;
            }
        });

        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
}
