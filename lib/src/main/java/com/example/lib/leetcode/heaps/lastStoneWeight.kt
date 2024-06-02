package com.example.lib.leetcode.heaps

import java.util.Comparator
import java.util.PriorityQueue
import kotlin.math.absoluteValue

class lastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {

        val maxHeap = PriorityQueue(Comparator.reverseOrder<Int>())
        for (stone in stones) {
            maxHeap.add(stone)
        }

        while (maxHeap.isNotEmpty()) {

            val stone1 = maxHeap.remove()
            if (maxHeap.isNotEmpty()) {
                val stone2 = maxHeap.remove()
                val diff = stone1 - stone2
                maxHeap.add(diff.absoluteValue)
            } else {
                return stone1
            }
        }

        // maxHeap is empty
        return 0
    }

}