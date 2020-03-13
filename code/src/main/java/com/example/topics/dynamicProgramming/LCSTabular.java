package com.example.topics.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 24/10/17.
 */

public class LCSTabular {

    public static void main(String []args)
    {
        testInput();
        int result = lcs(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        result = lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.println(result);

    }
    static String str1, str2;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        str1 = br.readLine();
        str2 = br.readLine();
    }

    public static void testInput()
    {
        str1= "abcdaf";
        str2="acbcf";
    }

    public static int lcs(char[] char1, char[] char2, int len1, int len2)
    {


        int temp[][] = new int[len1+1][len2+1];

        int max=0;

        for(int i=1;i<temp.length;i++)
        {
            for(int j=1;j<temp[i].length;j++)
            {

                if(char1[i-1]==char2[j-1])
                {
                    temp[i][j] = 1+ temp[i-1][j-1];
                }
                else{

                    temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
                }

                if(temp[i][j]> max)
                {
                    max = temp[i][j];
                }
            }
        }


        return max;

    }

    public static int lcsDynamic(char str1[],char str2[]) {

        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }

    }
