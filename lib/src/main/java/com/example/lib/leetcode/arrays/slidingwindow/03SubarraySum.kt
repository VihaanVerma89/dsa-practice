package com.example.lib.leetcode.arrays.slidingwindow


// https://leetcode.com/problems/subarray-sum-equals-k/
class subarraySum {

    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSumCount = mutableMapOf<Int, Int>()
        var count = 0
        var prefixSum = 0

        // Initialize with 0 sum occurring once (empty prefix)
        prefixSumCount[0] = 1

        for (num in nums) {
            prefixSum += num

            // Check if (prefixSum - k) exists in our map
            // If it does, we found subarrays ending at current position with sum k
            count += prefixSumCount.getOrDefault(prefixSum - k, 0)

            // Add current prefix sum to our map
            prefixSumCount[prefixSum] = prefixSumCount.getOrDefault(prefixSum, 0) + 1
        }

        return count
    }

    fun subarraySum1(nums: IntArray, k: Int): Int {
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