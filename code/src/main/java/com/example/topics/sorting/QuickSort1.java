package com.example.topics.sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vihaan on 02/09/17.
 */

public class QuickSort1 {

    public static int n;
    public static int[] array;
    public static ArrayList<Integer> left, equal, right;

    public static void main(String[] args) {
        testInput();
    }

    public static void input() {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.next());
        }
    }

    public static void testInput() {
        n=5;
        array = new int[]{4,5,3,7,2};

        processInput();
    }

    private static void processInput() {
        left = new ArrayList<>();
        equal = new ArrayList<>();
        right = new ArrayList<>();
        partition();
        printPartition();
    }

    public static void partition() {
        int p = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < p) {
                left.add(array[i]);
            } else if (p == array[i]) {
                equal.add(array[i]);
            } else {
                right.add(array[i]);
            }
        }
    }

    public static void printPartition() {
        for (int li = 0; li < left.size(); li++) {
            System.out.print(left.get(li) + "" );
        }

        for (int ei = 0; ei < equal.size(); ei++) {
            System.out.print(equal.get(ei) + "" );
        }

        for (int ri = 0; ri < right.size(); ri++) {
            System.out.print(right.get(ri) + "" );
        }
    }

}

