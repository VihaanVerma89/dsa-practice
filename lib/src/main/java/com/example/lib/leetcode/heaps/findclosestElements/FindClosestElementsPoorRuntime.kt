package com.example.lib.leetcode.heaps.findclosestElements

import java.util.PriorityQueue
import kotlin.Comparator
import kotlin.math.absoluteValue

class FindClosestElementsPoorRuntime {

    class NodeDiff(val value: Int, val diff: Int)


    val c = Comparator<NodeDiff> { p0, p1 ->
        if (p1.diff == p0.diff) {
            p1.value - p0.value
        } else {
            p1.diff - p0.diff
        }
    }
    val pq = PriorityQueue(c)

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {

        val ansList = ArrayList<Int>()

        // generate value diffs
        var diff = Int.MIN_VALUE
        for (num in arr) {
            diff = num - x
            val nodeDiff = NodeDiff(num, diff.absoluteValue)
            pq.add(nodeDiff)
        }


        if (pq.size > k) {
            while (pq.size != k) {
                pq.remove()
            }
        }

        // pq size <=k
        while (pq.isNotEmpty()) {
            ansList.add(pq.remove().value)
        }

        ansList.sort()
        return ansList
    }

}