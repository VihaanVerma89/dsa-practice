package com.example.lib.leetcode.greedy

import kotlin.math.sign

class partitionArray {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var min = nums[0]
        var ans = 1
        for (i in 1 until nums.size) {

            val diff = nums[i] - min
            if (diff > k) {
                ans++
                min = nums[i]
            }
        }

        return ans
    }

}