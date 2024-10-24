package com.example.lib.leetcode.arrays.slidingwindow

class findLength {

    //Example 1: Given an array of positive integers nums and an integer k, find the length of the
    //longest subarray whose sum is less than or equal to k. This is the problem we have been talking about above.

    fun findLength(nums: IntArray, k: Int): Int {
        var ans = 0
        var sum = 0

        var s = 0

        for (e in 0 until nums.size) {

            sum += nums[e]

            while (sum > k) {
                sum-=nums[s]
                s++
            }

            // sum is <=k
            ans = maxOf(ans, e-s+1)
        }

        return ans
    }


    fun findLength1(nums: IntArray, k: Int): Int {

        var l = 0
        var r = 0

        var sum = 0
        var ans = 0


        while (r < nums.size) {

            sum += nums[r]

            while (sum > k) {
                sum -= nums[l]
                l++
            }

            // sum is less than or equal to k now
            ans = maxOf(ans, l - r + 1)

            r++
        }
        return ans
    }
}