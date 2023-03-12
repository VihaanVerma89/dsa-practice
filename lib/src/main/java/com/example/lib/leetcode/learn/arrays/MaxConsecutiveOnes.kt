package com.example.lib.leetcode.learn.arrays

import kotlin.math.max

/*
https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
*/
class MaxConsecutiveOnes {


    fun findMaxConsecutiveOnesWrong(nums: IntArray): Int {
        var c = 0
        var maxC = 0

        for (num in nums) {
            if (num == 1) {
                // c
                c++
            } else if (num == 0) {
                // non c
                c = 0
            }

            if (c > maxC) {
                maxC = c
            }
        }

        return maxC
    }

    fun findMaxConsecutiveOnesWhile(nums: IntArray): Int {

        var i = 0
        var j = 0
        var max = 0

        while (i < nums.size) {
            val value = nums[i]
            if (value == 1) {
                j = i
                while (j < nums.size && nums[j] == 1) {
                    j++
                }
                // i is 1 j is not
                val d = j - i
                if (d > max) {
                    max = d
                }
                i = j
            } else {
                i++
            }
        }
        return max
    }


    fun findMaxConsecutiveOnesOct20(nums: IntArray): Int {
        var mc = 0
        var c = 0

        for (num in nums) {

            if (num == 1) {
                c++
            } else if (num == 0) {
                c = 0
            }

            if (c > mc) {
                mc = c
            }
        }
        return mc
    }

}

fun main() {
    val m = MaxConsecutiveOnes()
    val a = intArrayOf()
//    val max = m.findMaxConsecutiveOnes(a)
//    println("max consecutive : $max")
}