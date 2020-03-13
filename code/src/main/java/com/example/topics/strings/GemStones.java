package com.example.topics.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vihaan on 05/08/17.
 */

public class GemStones {

    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Set<Character> set = convertToSet(scan.next());
        for(int i=1; i<t ;i++){
            set.retainAll(convertToSet(scan.next()));
        }
        System.out.print(set.size());
    }


    public static Set<Character> convertToSet(String s) {
        Set<Character> set = new HashSet<Character>(26);
        for (char c : s.toCharArray())
            set.add(Character.valueOf(c));
        return set;
    }
}
