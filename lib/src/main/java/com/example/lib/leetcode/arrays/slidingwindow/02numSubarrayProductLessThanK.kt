package com.example.lib.leetcode.arrays.slidingwindow

// https://leetcode.com/problems/subarray-product-less-than-k/
class `02numSubarrayProductLessThanK` {


    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {

        // edge case
        // product can't be less than 1
        if (k <= 1) return 0

        var l = 0
        var r = 0
        var p = 1
        var ans = 0

        for (r in nums.indices) {

            p *= nums[r]

            while (p >= k) {
                p /= nums[l]
                l++
            }

            // l .. r is valid subarray
            ans += r - l + 1
        }

        return ans

    }

    fun numSubarrayProductLessThanK3(nums: IntArray, k: Int): Int {

        // strictly less than k
        // if k is zero then ans is 0
        if (k < 1) {
            return 0
        }
        var s = 0
        var ans = 0
        var product = 1

        for (e in 0 until nums.size) {

            product *= nums[e]

            while (product >= k && s < nums.size) {
                product /= nums[s]
                s++
            }

            // product is <k
            ans += e - s + 1
        }

        return ans
    }

    fun numSubarrayProductLessThanK2(nums: IntArray, k: Int): Int {

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
        return ans
    }


    // reading this code looks like it will work but doesn't
    // I didn't understand the concept of e-s+1 to get number of subarrays
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