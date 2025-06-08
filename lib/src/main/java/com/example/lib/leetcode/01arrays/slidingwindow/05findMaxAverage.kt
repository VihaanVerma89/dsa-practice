package com.example.lib.leetcode.`01arrays`.slidingwindow

class `05findMaxAverage` {

    fun findMaxAverage(nums: IntArray, k: Int): Double {

        var sum = 0
        var ans = 0

        for (e in 0 until k) {
            sum += nums[e]
        }

        ans = sum
        for (e in k until nums.size) {
            sum += nums[e]
            sum -= nums[e - k]
            ans = maxOf(ans, sum)
        }

        return ans / k.toDouble()
    }
}