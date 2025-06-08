package com.example.lib.leetcode.`01arrays`.slidingwindow

class `04findBestSubarray` {


//    Example 4: Given an integer array nums and an integer k, find the sum of the subarray with the largest sum whose length is k.

    fun findBestSubarray(nums: IntArray, k: Int) : Int{

        var l = 0
        var cSum = 0
        var maxSum = Int.MIN_VALUE

        for( r in 0 until nums.size){

            cSum += nums[ r ]
            val len = r - l + 1

            if( len > k ){
                // window size is greater than k
                cSum -= nums[ l ]
                l++
            }

            maxSum = maxOf(maxSum, cSum)
        }

        return maxSum

    }

    fun findBestSubarray2(nums: IntArray, k: Int): Int {

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