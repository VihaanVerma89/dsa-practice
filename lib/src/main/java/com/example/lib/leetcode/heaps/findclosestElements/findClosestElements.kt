package com.example.lib.leetcode.heaps.findclosestElements

import java.util.PriorityQueue
import kotlin.Comparator
import kotlin.math.absoluteValue

class findClosestElements {

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {


        val c = Comparator<Int> { p0, p1 ->
            val diff1 = p0 - x
            val diff2 = p1 - x

            if (diff1.absoluteValue == diff2.absoluteValue) {
                p1 - p0
            } else {
                diff2.absoluteValue - diff1.absoluteValue
            }
        }

        val maxHeap = PriorityQueue(c)

        for (i in arr) {
            maxHeap.add(i)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        return maxHeap.toList().sorted()
    }

}
