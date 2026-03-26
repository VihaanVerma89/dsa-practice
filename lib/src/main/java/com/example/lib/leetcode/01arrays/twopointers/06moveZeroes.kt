package com.example.lib.leetcode.`01arrays`.twopointers

// https://leetcode.com/problems/move-zeroes/
class `06moveZeroes` {

    /*

    0,1,0,3,12
    l
      r
    1,0,0,3
      l
          r
    1,3,0,0,12
        l
             r
    1,3,12,0,0

    swap when r is not at zero
 */

    fun moveZeroes25Mar26( nums: IntArray ) {

        var l = 0
        var r = 0

        for( r in nums.indices ){

            if(nums[r]!=0)
            {
                nums[l] = nums[r].also{nums[r]=nums[l]}
                l++
            }

        }
    }

    fun moveZeroes( nums: IntArray ) {

        var l = 0

        for( r in nums.indices ){

            if( nums[r] != 0 )
            {
                //we need to swap
                nums[l] = nums[r].also{ nums[r] = nums[l] }
                l++
            }


        }



    }
}