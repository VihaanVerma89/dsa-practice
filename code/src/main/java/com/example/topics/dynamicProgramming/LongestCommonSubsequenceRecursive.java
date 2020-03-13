package com.example.topics.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaan on 24/10/17.
 */

public class LongestCommonSubsequenceRecursive {

    public static void main(String args[]) throws IOException {

        testInput();
        int result = lcs(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.print(result);
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
        int result=0;
        if(len1 ==0 || len2 ==0)
        {
            return 0;
        }

        if(char1[len1-1] == char2[len2-1])
        {
           result = 1 + lcs(char1, char2, len1-1, len2-1);
        }
        else if(char1[len1-1] != char2[len2-1])
        {
            result = Math.max(lcs(char1,char2, len1-1, len2), lcs(char1, char2, len1, len2-1));
        }

        return result;
    }
}
