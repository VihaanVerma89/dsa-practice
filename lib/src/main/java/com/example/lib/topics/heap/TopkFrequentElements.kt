package com.example.lib.topics.heap

import java.util.*

class TopkFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        if (k == nums.size) {
            return nums;
        }

        val count = hashMapOf<Int, Int>()

        for (i in nums) {
            count[i] = count.getOrDefault(i, 0) + 1
        }


        val heap: Queue<Int> = PriorityQueue { n1, n2 -> count[n1]!! - count[n2]!! }

        for (n in count.keys) {
            heap.add(n)
            if (heap.size > k) {
                heap.poll()
            }
        }

        val top = IntArray(k)

        for (i in k - 1 downTo 0) {
            top[i] = heap.poll()
        }

        for (i in k - 1 downTo 0) {
            top[i] = heap.poll()
        }
        return top
    }

}

fun main() {

}