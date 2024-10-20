package com.example.lib.leetcode.arrays.slidingwindow

// https://leetcode.com/problems/subarray-product-less-than-k/
class numSubarrayProductLessThanK {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {

        var s = 0
        var e = 0
        var ans = 0
        var product = 1

        while (s < nums.size) {

            val value = nums[e]
            product *= value

            if (product < k) {
                e++
                ans++
            } else if (product > k) {

                while (product > k) {
                    product /= nums[s]
                    s++
                }

            }

        }
    }


    // reading this code looks like it will work but doesn't
    fun numSubarrayProductLessThanK1(nums: IntArray, k: Int): Int {

        var l = 0
        var r = 0
        var ans = 0
        var product = 1

        while (r < nums.size) {

            product *= nums[r]
            if (product < k) {
                ans++
                r++
            } else if (product > k) {
                l++
                r = l
                product = 1
            }

            if (r == nums.lastIndex) {
                l++
                l = r
                product = 1
            }
        }

        return ans
    }
}