package com.example.topics.sorting;

/**
 * Created by vihaan on 22/08/17.
 */

public class InsertSort1 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 10;
        int array[] = new int[]{2,3, 4, 5, 6, 7, 8, 9, 10, 1};
//        int array[] = new int[n];

//        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//        }

        insertInSorted(array);

    }


    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(array[i]+"\n");
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

        public static void insertInSorted(int[] array) {
            int value = array[array.length -1];

            for(int i=array.length-1; i >0 ; i--)
            {

                if(value < array[i-1])
                {
                    array[i] = array[i-1];
                    printArray(array);
                    if(i==1)
                    {
                        array[0]= value;
                        printArray(array);
                    }
                }
                else
                {
                    array[i]= value;
                    printArray(array);
                    break;
                }
            }

    }

}
