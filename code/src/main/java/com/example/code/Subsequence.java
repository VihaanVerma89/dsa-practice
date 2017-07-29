package com.example.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vihaan on 29/07/17.
 */

public class Subsequence {

    public static void main(String args[]) {

        List<String> inputLines;
        List<String> outputLines;

        inputLines = readLines("input.txt");
        outputLines = readLines("output.txt");


        for (int a0 = 0; a0 < inputLines.size(); a0++) {
            String input = inputLines.get(a0);
            String myOutput;
            String output;
            if (hasSubsequence(input)) {
                System.out.println("YES");
                myOutput = "yes";
                output = outputLines.get(a0);
                if (!myOutput.equalsIgnoreCase(output)) {
                    System.out.println("wrong ans for " + a0);
                }
            } else {
                System.out.println("NO");
                myOutput = "NO";
                output = outputLines.get(a0);
                if (!myOutput.equalsIgnoreCase(output)) {
                    System.out.println("wrong ans for " + a0);
                }
            }
        }

    }

    public static boolean hasSubsequence(String s) {
        String seq = "hackerrank";
        boolean has = false;

        if (s.length() < seq.length()) {
            return false;
        }

        int j = 0;
        for (int si = 0; si < s.length(); si++) {
            char charS = s.charAt(si);
            char charSeq = seq.charAt(j);
            if(charSeq == charS)
            {
                j++;
                if(j == seq.length())
                {
                    break;
                }
            }
        }

        if (j == seq.length()) {
            has = true;
        }

        return has;
    }

    private static List<String> readLines(String fileName) {
        List<String> lines = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                lines.add(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return lines;

    }

    static void touch(File file, long timestamp) {
        try {
            if (!file.exists())
                new FileOutputStream(file).close();
            file.setLastModified(timestamp);
        } catch (IOException e) {
        }
    }
}
