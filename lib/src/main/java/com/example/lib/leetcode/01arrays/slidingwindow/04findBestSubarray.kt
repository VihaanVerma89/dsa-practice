package com.example.lib.leetcode.`01arrays`.slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

fun main() {

    val solution = `04findBestSubarray`()
    val nums = intArrayOf(1, 2, 3, 4, 5)
    val k = 3
    println(solution.findBestSubarray(nums, k)) // Output: 12 (subarray [3, 4, 5])
    println(solution.findBestSubarray2(nums, k)) // Output: 12
    println(solution.findBestSubarray1(nums, k)) // Output: 12

    check(maxSumOfLenK(intArrayOf(3, -1, 4, 12, -8, 5, 6), 4) == 18)
    check(maxSumOfLenK(intArrayOf(-5, -2, -3), 2) == -5 - 2)  // -7
    check(maxSumOfLenK(intArrayOf(1, 2, 3, 4), 4) == 10)
}


class MaxSumOfLenKTest {

    @Test
    fun `max sum in normal array`() {
        val nums = intArrayOf(3, -1, 4, 12, -8, 5, 6)
        val result = maxSumOfLenK(nums, 4)
        assertEquals(18, result) // [3, -1, 4, 12]
    }

    @Test
    fun `array with all negatives`() {
        val nums = intArrayOf(-5, -2, -3)
        val result = maxSumOfLenK(nums, 2)
        assertEquals(-7, result) // [-5, -2]
    }

    @Test
    fun `k equals array size`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = maxSumOfLenK(nums, 4)
        assertEquals(10, result)
    }

    @Test
    fun `k equals 1`() {
        val nums = intArrayOf(1, -5, 2, 0)
        val result = maxSumOfLenK(nums, 1)
        assertEquals(2, result)
    }

    @Test
    fun `invalid k throws exception`() {
        val nums = intArrayOf(1, 2, 3)
        assertThrows<IllegalArgumentException> {
            maxSumOfLenK(nums, 0)
        }
        assertThrows<IllegalArgumentException> {
            maxSumOfLenK(nums, 4)
        }
    }
}