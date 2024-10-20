package com.example.lib.leetcode.arrays.slidingwindow

class findBestSubarray {

    fun findBestSubarray(nums: IntArray, k: Int): Int {
        var wSum = 0
        var ans = 0

        for (i in 0 until k) {
            wSum += nums[i]
        }

        for (i in k until nums.size) {
            wSum += nums[i]
            wSum -= nums[i - k]
            ans = maxOf(ans,wSum)
        }

        return ans
    }
}