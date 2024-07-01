package com.example.lib.leetcode.greedy

import java.util.PriorityQueue
import kotlin.math.min

class findLeastNumOfUniqueInts {

    // TC - O(n+mlogm+klogk)
    // considering n = m and k = n
    // O(n+nlogn+nlogn)
    // o( n + 2nlogn )
    // dominating term nlogn
    // final complexity = o( n log n )
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {

        if (arr.isEmpty()) {
            return 0
        }


        // create a hmap
        // Time Complexity - o(n)
        val hmap = HashMap<Int, Int>()
        for (item in arr) {
            if (hmap.contains(item)) {
                val freq = hmap.get(item)
                hmap.put(item, freq!! + 1)
            } else {
                hmap.put(item, 1)
            }
        }

        // create min heap
        // m unique elements
        // TC - o(m log m)
        class Item(val value: Int, var freq: Int)

        val minHeap = PriorityQueue<Item> { p0, p1 -> p0.freq - p1.freq }
        for (entry in hmap) {
            minHeap.add(Item(entry.key, entry.value))
        }

        // remove k elements from heap
        // TC - o( k log k)
        var i = k
        while (minHeap.isNotEmpty() && i > 0) {
            val top = minHeap.peek()
            if (top.freq == 1) {
                minHeap.poll()
            } else {
                top.freq--
            }
            i--
        }

        // return the size of heap

        return minHeap.size
    }

}