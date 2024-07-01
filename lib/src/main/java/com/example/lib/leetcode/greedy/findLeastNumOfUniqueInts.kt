package com.example.lib.leetcode.greedy

import java.util.PriorityQueue
import kotlin.math.min

class findLeastNumOfUniqueInts {

    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {

        if (arr.isEmpty()) {
            return 0
        }

        // create min heap
        class Item(val value: Int, var freq: Int)

        val minHeap = PriorityQueue<Item> { p0, p1 -> p0.freq - p1.freq }

        val hmap = HashMap<Int, Int>()

        for (item in arr) {
            if (hmap.contains(item)) {
                val freq = hmap.get(item)
                hmap.put(item, freq!! + 1)
            } else {
                hmap.put(item, 1)
            }
        }

        for (entry in hmap) {
            minHeap.add(Item(entry.key, entry.value))
        }

        // remove k elements from heap
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