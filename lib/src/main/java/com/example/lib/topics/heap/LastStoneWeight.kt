package com.example.lib.topics.heap

import java.util.*


class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        var r = 0
        val c: Comparator<Int> = Comparator<Int> { p0, p1 -> p1 - p0 }
        val maxHeap = PriorityQueue(c)

        for (i in stones) {
            maxHeap.add(i)
        }

        while (maxHeap.size > 1) {
            val s1 = maxHeap.poll()
            val s2 = maxHeap.poll()

            if (s1 == s2) {

            } else {
                val s = s1 - s2
                maxHeap.add(s)
            }
        }

        if (maxHeap.size == 1) {
            r = maxHeap.poll()
        }

        return r
    }
}

fun main() {
    val lastStoneWeight = LastStoneWeight()
    val a = intArrayOf(2, 7, 4, 1, 8, 1)
    lastStoneWeight.lastStoneWeight(a)
}