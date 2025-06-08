package com.example.lib.leetcode.`01arrays`.twopointers

class checkForTarget {

    fun checkForTarget(nums: IntArray, target: Int): Boolean {
        var result = false

        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val sum = nums[l] + nums[r]
            if (sum == target) {
                return true
            } else if (sum >= target) {
                r--
            } else if (sum < target) {
                l++
            }

        }
        return result
    }
}

fun main() {
    val result = checkForTarget().checkForTarget(intArrayOf(1, 2, 4, 6, 8, 9, 14, 15), 13)
    println(result)
}