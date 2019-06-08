package com.example.geeksforgeeks.arrays;

public class BinarySearch {

    public int search(int[] a, int low, int high, int num) {
        int index = -1;
        int mid = (low + high) / 2;
        if (a[mid] == num) {
            index = mid;
        } else if (a[mid] > num) {
            high = mid - 1;
            index = search(a, low, high, num);
        } else if (a[mid] < num) {
            low = mid + 1;
            index = search(a, low, high, num);
        } else {
            System.out.println("wtf");
        }
        return index;
    }

    public int search(int a[], int num) {
        int index = search(a, 0, a.length - 1, num);
        return index;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 10, 40};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(a, 10);
        if (index == -1) {
            System.out.println("element not found");
        } else {
            System.out.println("element found at : " + index);
        }
    }
}
