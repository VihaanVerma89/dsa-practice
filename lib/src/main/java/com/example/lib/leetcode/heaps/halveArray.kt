package com.example.lib.leetcode.heaps

import java.util.Comparator
import java.util.PriorityQueue

class halveArray {

    fun halveArray(nums: IntArray): Int {
        if (nums.size == 1) {
            return 1
        }

        val maxHeap = PriorityQueue(Comparator.reverseOrder<Double>())
        var numSum = 0.0
        for (num in nums) {
            maxHeap.add(num.toDouble())
            numSum += num
        }

        var divSum = 0.0
        var top = 0.0
        var divCount = 0

        while (divSum < numSum / 2.0) {
            if (maxHeap.isNotEmpty()) {
                top = maxHeap.remove()
                divSum += top / 2.0
                maxHeap.add(top / 2.0)
                divCount++
            } else {
                println("heap empty")
            }
        }

        return divCount
    }

}

fun main() {
    val count = halveArray().halveArray(intArrayOf(5, 19, 8, 1))
    println("count $count")
}