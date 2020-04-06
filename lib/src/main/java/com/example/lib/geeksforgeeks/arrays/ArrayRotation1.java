package com.example.lib.geeksforgeeks.arrays;

import java.util.Scanner;

public class ArrayRotation1 {



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

        ArrayRotation1 Solution = new ArrayRotation1();
        Solution.rotateArray(a,d);
        Solution.printArray(a);
        scanner.close();
    }


    public void rotateArray(int[] a, int r) {
        int n = a.length;
        if (n == 0) {
            return;
        } else if (r % n == 0) {
            return;
        } else {
            placeAtCi(a, 0, a[0], 0, r);
        }
    }

    public void placeAtCi(int[] a, int count, int value, int i, int r) {
        if (count == a.length) {
            return;
        }
        int ci = i - r;
        if (ci < 0) {
            ci = a.length + ci;
        }
        int temp = a[ci];
        a[ci] = value;
        count++;
        placeAtCi(a, count, temp, ci, r);
    }

    public  void printArray(int[] a) {
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
