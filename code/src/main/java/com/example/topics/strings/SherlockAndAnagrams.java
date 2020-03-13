package com.example.topics.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vihaan on 09/08/17.
 */

public class SherlockAndAnagrams {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        String input;
        int result;

//        String input = "abba";
//
//        result = getAnagramCount(input);
//        System.out.println(result);

//
        for (int i = 0; i < t; i++) {
            input = scanner.next();
            result = getAnagramCount(input);
            System.out.println(result);
        }
    }

    public static int getAnagramCount(String input) {
        int count = 0;
        ArrayList<String> subStrings = getSubStrings(input);

        String s1, s2;
        for (int i = 0; i < subStrings.size(); i++) {
            s1 = subStrings.get(i);
//            for(int j=i+1; j< subStrings.size()-1; j++)
            for (int j = i + 1; j < subStrings.size(); j++) {
                s2 = subStrings.get(j);
                if (isAnagram(s1, s2)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static ArrayList<String> getSubStrings(String input) {
        ArrayList<String> subStrings = new ArrayList<>();
        String subString;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
//                System.out.println("i:" + i + ",j:" + j);
                subString = input.substring(i, j);
//                System.out.println(subString);
                subStrings.add(subString);
            }
        }

        return subStrings;
    }

    public static boolean isAnagram(String s1, String s2) {
        boolean result = true;

        if (s1.length() == s2.length()) {
            HashMap<Character, Integer> s1freq = getCharFrequency(s1);
            HashMap<Character, Integer> s2freq = getCharFrequency(s2);

            Iterator i = s1freq.entrySet().iterator();

            while (i.hasNext()) {
                Map.Entry<Character, Integer> pair = (Map.Entry) i.next();
                char s1Key = pair.getKey();
                int s1Value = pair.getValue();

                int s2Value;

                if (s2freq.containsKey(s1Key)) {
                    s2Value = s2freq.get(s1Key);
                    if (s1Value != s2Value) {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }

            }
        } else {
            result = false;
        }
        return result;
    }

    public static HashMap<Character, Integer> getCharFrequency(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer value = hashMap.get(c);
            if (value != null) {
                value++;
                hashMap.put(c, value);
            } else {
                hashMap.put(c, 1);
            }
        }
        return hashMap;
    }


}
