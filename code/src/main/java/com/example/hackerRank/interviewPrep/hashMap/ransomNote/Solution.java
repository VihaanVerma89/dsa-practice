package com.example.hackerRank.interviewPrep.hashMap.ransomNote;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        int i;
        HashMap<String, Integer> magazineHashMap = new HashMap();
        HashMap<String, Integer> noteHashMap = new HashMap<String, Integer>();
        String word;
        for (i = 0; i < magazine.length; i++) {
            word = magazine[i];
            if (magazineHashMap.containsKey(word)) {
                Integer integer = magazineHashMap.get(word);
                integer++;
                magazineHashMap.put(word, integer);
            } else {
                magazineHashMap.put(word, 1);
            }
        }
        for (i = 0; i < note.length; i++) {
            word = note[i];
            if (noteHashMap.containsKey(word)) {
                Integer integer = noteHashMap.get(word);
                integer++;
                noteHashMap.put(word, integer);
            } else {
                noteHashMap.put(word, 1);
            }
        }

        boolean requiredWordsPresent = true;
        for (Map.Entry<String, Integer> entry : noteHashMap.entrySet()) {
            String key = entry.getKey();
            if (magazineHashMap.containsKey(key)) {
                if (magazineHashMap.get(key) >= noteHashMap.get(key)) {

                } else {
                    // words not present
                    requiredWordsPresent = false;
                }
            } else {
                //words not present
                requiredWordsPresent = false;
            }
        }

        if (requiredWordsPresent) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
