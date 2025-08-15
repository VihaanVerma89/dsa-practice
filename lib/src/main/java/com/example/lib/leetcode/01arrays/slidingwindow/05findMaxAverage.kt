package com.example.lib.leetcode.`01arrays`.slidingwindow


// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4594/
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