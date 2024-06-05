package com.example.lib.leetcode.heaps

import java.util.PriorityQueue
import kotlin.math.min

class topKFrequent {

    class HeapNode(var freq: Int, var num: Int)

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val result = IntArray(k)

        // create freq priority
        val minHeap = PriorityQueue<HeapNode>()

        // add elements into heap and remove the ones which are not top k
        for (num in nums) {

            if (minHeap.size == 0) {
                val entry = HeapNode(1, num)
                minHeap.add(entry)
            } else {
                // heap has values

                // check and update the freq
                var matchFound = false
                for (heapNode in minHeap) {
                    if (heapNode.num == num) {
                        heapNode.freq++
                        matchFound = true
                    }
                }

                if (!matchFound) {
                    // new element with 1 freq
                    if (minHeap.size < k) {
                        minHeap.add((HeapNode(1, num)))
                    } else {

                    }
                    val minNode = minHeap.peek()

                }

            }
        }

        return result
    }

}

fun main() {

    topKFrequent().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
}