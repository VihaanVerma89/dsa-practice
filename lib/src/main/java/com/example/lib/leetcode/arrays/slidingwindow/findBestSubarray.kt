package com.example.lib.leetcode.arrays.slidingwindow

class findBestSubarray {


    fun findBestSubarray(nums: IntArray, k: Int): Int {

        var s = 0
        var sum = 0
        var ans = 0

        for (e in 0 until nums.size) {

            sum += nums[e]

            if (e > k) {
                sum -= nums[e - k]
            }

            ans = maxOf(ans, sum)
        }

        return ans
    }


    fun findBestSubarray1(nums: IntArray, k: Int): Int {
        var wSum = 0
        var ans = 0

        for (i in 0 until k) {
            wSum += nums[i]
        }

        for (i in k until nums.size) {
            wSum += nums[i]
            wSum -= nums[i - k]
            ans = maxOf(ans, wSum)
        }

        return ans
    }
}