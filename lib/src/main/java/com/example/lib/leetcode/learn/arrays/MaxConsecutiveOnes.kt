package com.example.lib.leetcode.learn.arrays

/*
https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
*/
class MaxConsecutiveOnes {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
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
    max = m.findMaxConsecutiveOnes(a)
    println("max consecutive : $max")
}