package com.example.lib.leetcode

.01arrays

class JumpGame {

    fun canJump( nums: IntArray ) : Boolean {

        if(nums.size == 1 ) return true

        var maxR = Int.MIN_VALUE

        for( (i,v) in nums.withIndex( ) ) {


            if ( i > maxR && maxR != Int.MIN_VALUE ) return false

            val r = i + v
            maxR = maxOf( maxR, r )


            if( maxR >= nums.lastIndex) return true
        }

        return false


    }





}