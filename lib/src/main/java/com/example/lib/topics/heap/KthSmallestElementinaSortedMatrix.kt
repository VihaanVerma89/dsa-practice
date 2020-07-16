package com.example.lib.topics.heap

import java.util.*

class KthSmallestElementinaSortedMatrix {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val r = matrix.size
        val c = matrix[0].size


        val comparator = Comparator { n1: Int, n2: Int -> n2 - n1 }

        val maxHeap = PriorityQueue<Int>(comparator)
        for (ri in 0 until r) {
            for (ci in 0 until c) {
                maxHeap.add(matrix[ri][ci])
                if (maxHeap.size > k) {
                    maxHeap.poll()
                }
            }
        }

        val peek = maxHeap.peek()

        return peek
    }
}

fun main() {

}