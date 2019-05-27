package com.example.geeksforgeeks.ds.arrays;

import java.util.*;

public class ArrayRotation {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        ArrayRotation Solution = new ArrayRotation();
        Solution.rotateArray(a, d);
        Solution.printArray(a);
        scanner.close();
    }

    public void rotateArray(int[] a, int r) {

    }


    public void printArray(int[] a) {
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
