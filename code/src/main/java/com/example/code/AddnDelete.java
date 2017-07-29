package com.example.code;

import java.util.Scanner;

/**
 * Created by vihaan on 20/07/17.
 */

public class AddnDelete {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        String s;
        s= "abcd";
//        s = scanner.next();
        String t ;
        t="abcdert";
//        t = scanner.next();
        int k ;
        k=10;
//        k = scanner.nextInt();

        if(isConvertible(s,t,k))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }

    public static boolean isConvertible(String s, String t, int k)
    {
        boolean convertible;

        int i=0;
        while(s.charAt(i) == t.charAt(i))
        {
            i++;
            if((i == s.length()) || (i == t.length()))
            {
                break;
            }
        }

        int sRemaining = s.length() - i;
        int tRemaining = t.length() - i;

        if(sRemaining == 0 && tRemaining ==0)
        {
            convertible = true;
        }
        else if(k >= (sRemaining + tRemaining))
        {
            convertible = true;
        }
        else
        {
            convertible = false;
        }


        return convertible;
    }
}
