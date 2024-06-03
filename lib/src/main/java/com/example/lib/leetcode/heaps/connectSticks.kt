package com.example.lib.leetcode.heaps

import java.util.PriorityQueue

class connectSticks {


    fun connectSticks(sticks: IntArray): Int {

        if (sticks.size <= 1) {
            return 0
        } else {
            // size >= 2
            val minHeap = PriorityQueue<Int>()

            for (stick in sticks) {
                minHeap.add(stick)
            }

            var cost = 0

            while (minHeap.size != 1) {

                val value1 = minHeap.remove()

                if (minHeap.isNotEmpty()) {
                    val value2 = minHeap.remove()
                    val combinedValue = value1 + value2
                    cost += combinedValue
                    minHeap.add(combinedValue)
                } else {
                    return cost
                }
            }

            // size is 1
            return cost
        }

        return -1
    }

}

fun main() {

}