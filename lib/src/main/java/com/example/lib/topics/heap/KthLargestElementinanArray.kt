package com.example.lib.topics.heap

import java.util.*

class KthLargestElementinanArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var r = 0
        val minHeap = PriorityQueue<Int>(Comparator { n1: Int, n2: Int -> n1-n2 })
        for (i in nums) {
            minHeap.add(i)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        if (minHeap.size >= 1) {
            r = minHeap.poll()
        }
        return r
    }
}

fun main() {
    val o = KthLargestElementinanArray()
    val a = intArrayOf(3, 2, 1, 5, 6, 4)
    o.findKthLargest(a, 2)
}