package com.example.lib.leetcode

.01arrays

class JumpGame {


    fun canJump21Mar26( nums: IntArray ) : Boolean {


        var maxJump = 0

        for ( (i,v) in nums.withIndex() ) {


            if ( i > maxJump){
                // we cant jump any more
                return false
            }

            val jump = i + v
            maxJump = maxOf( maxJump, jump)
            if( maxJump >= nums.lastIndex){
                return true
            }
        }

        return false
    }

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