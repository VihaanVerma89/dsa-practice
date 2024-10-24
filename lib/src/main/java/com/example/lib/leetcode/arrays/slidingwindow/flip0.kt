package com.example.lib.leetcode.arrays.slidingwindow

//https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4502/
class flip0 {


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