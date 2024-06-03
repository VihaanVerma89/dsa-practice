package com.example.lib.leetcode.heaps

import java.util.Comparator
import java.util.PriorityQueue
import kotlin.math.ceil
import kotlin.math.floor

class minStoneSum {
    fun minStoneSum(piles: IntArray, k: Int): Int {

        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
        var totalSum = 0

        for (stones in piles) {
            maxHeap.add(stones)
//            totalSum += stones
        }

        for (i in 1..k) {
            if (maxHeap.isNotEmpty()) {
                val top = maxHeap.remove()
                val floorValue = ceil((top / 2.0)).toInt()
//                totalSum -= floorValue
                maxHeap.add(floorValue)
            }
        }


        for (value in maxHeap) {
            println("value $value")
            totalSum += value
        }

        return totalSum
    }

}