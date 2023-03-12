package com.example.lib.topics.arrays.slidingwindow


// https://leetcode.com/problems/subarray-sum-equals-k/
class subarraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var i = 0
        var j = 0
        var curSum = 0
        var maxLen = 0
        var curLen = 0

        var condition = true
        while (condition) {
            if (curSum + nums[j] <= k) {
                // can add more into subarray
                curSum += nums[j]
                j++
            } else if (curSum + nums[j] > k) {
                curLen = j - i
                if (curLen > maxLen) {
                    maxLen = curLen
                }
                // change subarray
                curSum -= nums[i]
                i++
            }
        }
        return maxLen
    }
}