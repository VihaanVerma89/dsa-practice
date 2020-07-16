package com.example.lib.topics.heap

import java.util.*

//https://leetcode.com/problems/ugly-number-ii/
class UglyNumberII {
    fun nthUglyNumber(n: Int): Int {
//        val seenHashSet = hashSetOf<Int>()
        val seenHashSet = hashSetOf<Long>()
//        val minHeap = PriorityQueue<Int>()
        val minHeap = PriorityQueue<Long>()

        val ma = arrayOf(2, 3, 5)
        val r = IntArray(1690)
        var ri = 0
        minHeap.add(1)
        seenHashSet.add(1)
        while (ri != n) {
            val poll = minHeap.poll()
            r[ri++] = poll.toInt()
            for (m in ma) {
                val rm = poll * m
                if (seenHashSet.contains(rm)) {

                } else {
                    minHeap.add(rm)
                    seenHashSet.add(rm)
                }
            }
        }

        return r[n - 1]
    }
}

fun main() {
    val u = UglyNumberII()
    val n = 10
    u.nthUglyNumber(n)
}
