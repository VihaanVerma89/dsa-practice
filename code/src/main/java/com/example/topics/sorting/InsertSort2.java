package com.example.topics.sorting;

/**
 * Created by vihaan on 22/08/17.
 */

public class InsertSort2 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 10;
        int array[] = new int[]{1,4,3,5,6,2};
//        int array[] = new int[n];

//        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//        }

        sortArray(array);

    }


    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(array[i] + "\n");
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void sortArray(int[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            insertInSorted(array, i);
        }
    }

    public static void insertInSorted(int[] array,int n) {
        int value = array[n];

        for (int i = n ; i > 0; i--) {

            if (value < array[i - 1]) {
                array[i] = array[i - 1];
                array[i-1] = value;
//                printArray(array);
                if (i == 1) {
                    array[0] = value;
//                    printArray(array);
                }
            } else {
                array[i] = value;
//                printArray(array);
                break;
            }
        }

                printArray(array);
    }

}
