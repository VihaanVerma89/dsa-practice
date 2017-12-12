package com.example.geeksforgeeks.ds.heap;

/**
 * Created by vihaanverma on 06/12/17.
 */

public class Heap {

    int array[];
    int cap;
    int index = 0;

    public Heap(int cap) {
        this.cap = cap;
        array = new int[cap];
    }

    public int insert(int value) {
        int insertedAt = -1;
        if (index < cap) {
            array[index] = value;
            minHeapify(array, index);
            insertedAt = index;
            index++;
        }
        return insertedAt;
    }

    public int delete(int index) {
        int value = -1;
        if (index < cap && index >= 0) {
            value = array[index];
            array[index]= Integer.MAX_VALUE;
            while (index < cap) {

                int rci = getRightChild(index);
                int lci = getLeftChild(index);

                if (rci < cap && lci < cap) {
                    if (array[rci] < array[lci]) {
                        swap(array, index, rci);
                        index=rci;
                    } else if(array[lci]<array[rci]) {
                        swap(array, index, lci);
                        index=lci;
                    }
                }
                else if(rci >= cap && lci >= cap)
                {
                    //reached end
                    index=cap;
                }
                else if(lci <cap && rci >= cap)
                {
                    swap(array, index, lci);
                    index=lci;
                }
            }
        }
        return value;
    }

    private void swap(int array[], int pi, int ci) {
        int temp = array[pi];
        array[pi] = array[ci];
        array[ci] = temp;
    }

    private void minHeapify(int array[], int index) {
        int pi = getParentIndex(index);

        while (pi != -1) {
            if (array[pi] > array[index]) {
                int t = array[pi];
                array[pi] = array[index];
                array[index] = t;
                index = pi;
                pi = getParentIndex(pi);
            } else {
                break;
            }
        }

    }

    public void printHeap() {
        for (int i = 0; i < cap; i++) {
            int rightChild = getRightChild(i);
            int leftChild = getLeftChild(i);
            System.out.println("Parent: " + array[i]);
            if (leftChild < cap) {
                System.out.println("left child : " + array[leftChild]);
            }

            if (rightChild < cap) {
                System.out.println("right child : " + array[rightChild]);
            }

        }
    }


    private int getParentIndex(int index) {
        int parentIndex = -1;

        if (index == 0) {
            parentIndex = -1;
        } else if (index % 2 == 0) {
            parentIndex = index / 2 - 1;
        } else if (index % 2 == 1) {
            parentIndex = index / 2;
        }
        return parentIndex;
    }

    private int getRightChild(int index) {
        int rightChild = 2 * index + 2;
        return rightChild;
    }

    private int getLeftChild(int index) {
        int leftChild = 2 * index + 1;
        return leftChild;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(6);
        heap.insert(3);
        heap.insert(1);
        heap.insert(5);
        heap.insert(9);
        heap.insert(8);

        heap.printHeap();
    }

}
