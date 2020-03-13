package com.example.topics.alogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vihaanverma on 14/11/17.
 */

public class MergeSort {

    public static void main(String[] args) throws IOException {
        MergeSort mergeSort = new MergeSort();
        /*
        38 27 43 3 9 82 10

         */
        int array[] = mergeSort.input();
        int sorted[] = mergeSort.sort(array, 0,array.length-1);//, array[array.length - 1]);
        System.out.println(sorted);
    }

    public int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String[] parts = line.split(" ");

        int array[];
        int n;
        array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        return array;
    }


    public int[] sort(int[] array, int start, int end){
        int[] sorted = null;

        int len = end - start +1;
        int mid = len / 2;
        if (start == end){
            return new int[]{array[start]};
        } else {
            sorted = merge(sort(array, start, start+mid-1), sort(array, start+mid , end));
        }

        return sorted;
    }

    public int[] merge(int array1[], int array2[]) {
        int[] merged = new int[array1.length + array2.length];

        int i1 = 0, i2 = 0;
        int i = 0;
        while (i < merged.length) {
            if (array1[i1] < array2[i2]) {
                merged[i++] = array1[i1++];
            } else {
                merged[i++] = array2[i2++];
            }
            if (i1 == array1.length) {
                while (i2 < array2.length) {
                    merged[i++] = array2[i2++];
                }
            }

            if (i2 == array2.length) {
                while (i1 < array1.length) {
                    merged[i++] = array1[i1++];
                }
            }
        }
        return merged;
    }
}
