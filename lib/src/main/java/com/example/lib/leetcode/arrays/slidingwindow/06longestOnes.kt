package com.example.lib.leetcode.arrays.slidingwindow

class `06longestOnes` {

    //https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4595/
    fun longestOnes(nums: IntArray, k: Int) : Int{

        var l = 0
        var z = 0
        var maxLen = Int.MIN_VALUE

        for( r in nums.indices ){


            if(nums[r] == 0 ){
                z++
            }

            while(z > k ){

                if(nums[l] == 0 ){
                    z--
                }

                l++
            }

            maxLen = maxOf( maxLen, r-l+1)

        }
        return maxLen
    }
}