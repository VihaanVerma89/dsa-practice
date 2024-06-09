package com.example.lib.leetcode.heaps

import java.util.PriorityQueue

class topKFrequent {


    class HeapNode(val number: Int, var frequency: Int)

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val numMap = HashMap<Int, Int>()
        val result = IntArray(k)

        for (num in nums) {
            if (numMap.contains(num)) {
                numMap.put(num, numMap[num]!! + 1)
            } else {
                numMap[num] = 1
            }
        }

        // num -> freq ready

        val pq =
            PriorityQueue(Comparator<HeapNode> { p0, p1 -> p0?.frequency?.minus(p1?.frequency!!)!! })

        for (entry in numMap) {
            pq.add(HeapNode(entry.key, entry.value))
        }

        while (pq.size != k) {
            pq.remove()
        }

        var i = 0
        while (pq.isNotEmpty()) {
            pq.remove().also { result[i++] = it.number }
        }
        return result
    }

}

fun main() {

    topKFrequent().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
}