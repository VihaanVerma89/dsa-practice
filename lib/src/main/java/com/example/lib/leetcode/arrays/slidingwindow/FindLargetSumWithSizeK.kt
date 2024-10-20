package com.example.lib.leetcode.arrays.slidingwindow

class FindLargetSumWithSizeK {

    fun findLargestSumWithSizeK(nums: IntArray, k: Int): Int {

        var curr = 0

        for (i in 0..k) {
            curr += nums[i]
        }

        var ans = curr

        for (i in k until nums.size) {
            curr += nums[i] - nums[i - k]
            ans = maxOf(ans,curr)
        }

        return ans
    }

}