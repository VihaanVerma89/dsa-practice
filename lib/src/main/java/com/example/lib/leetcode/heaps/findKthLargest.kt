package com.example.lib.leetcode.heaps

import java.util.Comparator
import java.util.PriorityQueue

class findKthLargest {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>()
        for (num in nums) {
            maxHeap.add(num)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }
        return maxHeap.peek()
    }

}