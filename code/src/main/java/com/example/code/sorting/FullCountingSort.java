package com.example.code.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static android.R.attr.data;

/**
 * Created by vihaan on 4/9/17.
 */

public class FullCountingSort {

    public static HashMap<String, ArrayList<String>> data = new HashMap<>();
    public static String [] lines = new String []{"0 ab","6 cd","0 ef","6 gh","4 ij","0 ab","6 cd","0 ef",
            "6 gh","0 ij","4 that","3 be","0 to","1 be","5 question","1 or","2 not","4 is",
            "2 to","4 the"

    };
    static int n;

    public static void main(String[] args) throws IOException {

//        testInput();
        input();
        process();
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String line;
        String [] parts;
        for(int i=0;i<n;i++)
        {
            line = br.readLine();
//            line = lines[i];
            parts = line.split(" ");
            String key = parts[0];
            String value = parts[1];

            if(i < n/2)
            {
                value = "-";
            }

            if(data.get(key) == null)
            {
                ArrayList<String> values = new ArrayList<>();
                values.add(value);
                data.put(key, values);
            }
            else{
                data.get(key).add(value);
            }

        }
        br.close();
    }

    public static void testInput() {

        n= 20;

    }

    public static void process() {
        for(int i=0;i<100;i++)
        {
            ArrayList<String> values = data.get(""+i);
            if(values != null)
            {
                for(int j=0; j<values.size(); j++)
                {
                    System.out.print(values.get(j)+ " ");
                }
            }
        }
    }
}
