package com.example.lib.leetcode.arrays.slidingwindow

//https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4502/
class flip0 {


    // this function is better than findLength as it uses two pointers well and uses diff between
    // them to find the length of subarray when there are two zeros.
    fun longestStringWithFlip(nums: IntArray, k: Int) : Int{


        var l = 0
        var maxLen = Int.MIN_VALUE
        var zCount = 0

        for(r in nums.indices){

            if(nums[r]==0){
                zCount++
            }

            while(zCount > 1){

                if(nums[l]==0){
                    zCount--
                }

                l++
            }

            maxLen = maxOf(maxLen, r-l+1)
        }
        return maxLen

    }

    // This functions solves the problem but is not optimal and has the same logic inside multiple ifs.
    fun findLength(nums: IntArray): Int {

        var l = 0
        var r = 0

        var onZero = false
        var maxLen = Int.MIN_VALUE
        var len = 0

        while (r < nums.size) {

            if (nums[r] == 0) {
                if (onZero) {
                    // second zero found
                    len = r - l
                    maxLen = maxOf(maxLen, len)
                    l++
                    onZero = false
                } else {
                    // zero found first time
                    onZero = true
                    maxLen = maxOf(maxLen, r - l + 1)
                    r++
                }
            } else {
                // found 1
                maxLen = maxOf(maxLen, r - l + 1)
                r++
            }
        }

        return maxLen


    }

    fun findLen(s: String) {

        var l = 0
        var r = 0
        var ans = 0
        var zeroCount = 0
        var firstZeroIndex = 0
        for (r in 0 until s.length) {

            if (s[r] == '0') {
                if (zeroCount == 0) {
                    // first zero found
                    firstZeroIndex = r
                    zeroCount++
                } else if (zeroCount == 1) {
                    // second zero found
                    l = firstZeroIndex
                    zeroCount = 0
                }
            }

            ans = maxOf(ans, r - l + 1)
        }
    }


    fun findLen1(s: String): Int {

        var l = 0
        var r = 0
        var zeroCount = 0
        var ans = 0
        var lastZeroIndex = -1


        while (r < s.length) {

            if (s[r] == '0') {
                zeroCount++
                if (zeroCount > 1) {
                    l = lastZeroIndex + 1
                    zeroCount = 0
                } else if (zeroCount == 1) {
                    lastZeroIndex = r
                }
            }

            ans = maxOf(ans, r - l + 1)
            r++
        }
        return ans

    }


}

fun main() {
    val instance = flip0()

    val failingInput = intArrayOf(0, 1, 1, 0, 1, 1, 1)
    val result = instance.findLength(failingInput)
    println("result : $result")

}