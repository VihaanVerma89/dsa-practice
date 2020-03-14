package com.example.lib.geeksforgeeks.sorting;

/**
 * Created by vihaanverma on 10/04/18.
 */

public class QuickSort {

    public static void main(String[] args) {
        testInput();
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }


    static int array[];

    public static void testInput() {
        array = new int[]{10, 80, 30, 90, 40, 50, 70};
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start<end)
        {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int index = -1;
        if (start < end) {

            int pivot = array[end];
            int high = end - 1, low = start;
            while (low < high) {
                if (array[low] < pivot) {
                    low++;
                } else if (array[low] >= pivot) {
                    int temp = array[high];
                    array[high] = array[low];
                    array[low] = temp;
                    high--;
                }
            }
            array[end] = array[low + 1];
            array[low + 1] = pivot;
            index = low + 1;
        }
        return index;
    }

    public static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }
}
