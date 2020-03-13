package com.example.topics.dynamicProgramming;

/**
 * Created by vihaan on 22/10/17.
 */

public class LongestCommonSubsequence {

    public static void main(String args[])
    {
        String str1 = "abcdaf";
        String str2 = "acbcf";

//        int result = lcs(str1, str2);
        int result = lcsRecursive(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println(result);

    }

    public static int lcs(String str1, String str2)
    {

        char [] char1 = str1.toCharArray();
        char [] char2 = str2.toCharArray();

        int temp[][] = new int[char1.length+1][char2.length+1];
        int max = 0;

        for(int i=1;i<temp.length;i++)
        {
            for(int j=1; j<temp[i].length;j++)
            {
                if(char1[i-1]==char2[j-1])
                {
                    temp[i][j]= 1+temp[i-1][j-1];
                }
                else
                {
                    temp[i][j]= Math.max(temp[i-1][j], temp[i][j-1]);
                }

                if(temp[i][j]>max)
                {
                    max = temp[i][j];
                }
            }
        }

        return max;
    }


    public static int lcsRecursive(char[] char1, char[] char2, int len1, int len2)
    {

        if(len1 == 0 || len2 == 0)
        {
            return 0;
        }

        if(char1[len1-1] == char2[len2-1])
        {
            return 1 + lcsRecursive(char1, char2, len1-1, len2-1);
        }
        else{

            return Math.max(lcsRecursive(char1, char2, len1, len2-1), lcsRecursive(char1, char2, len1-1, len2));
        }
    }












































}
