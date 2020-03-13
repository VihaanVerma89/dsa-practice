package com.example.topics.sorting;

/**
 * Created by vihaan on 23/08/17.
 */

public class InsertSortShifts {

    public static void main(String[] args) {
        testInput();
    }

    public static void testInput() {
//        int n = 6;
        int n = 10;
//        int[] array = new int[]{4, 1, 3, 5, 6, 2};
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        setShiftCounts(array);
    }

    private static int count = 0;

    public static void setShiftCounts(int[] array) {
        for (int i = 1; i < array.length; i++) {
            setShiftCounts(array, i);
        }
    }

    public static void setShiftCounts(int[] array, int n) {
        int value = array[n];

        for (int i = n; i > 0; i--) {

            if (value < array[i - 1]) {
                array[i] = array[i - 1];
                array[i - 1] = value;
                count++;
            } else {
                if (array[i] == value) {
                    break;
                }
                array[i] = value;
                count++;
                break;
            }
        }
    }
}
