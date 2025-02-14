package com.example.lib.leetcode.arrays

/*
comment

intArray

[0,1,0,3,12]


[1,0,0,3,12]
[1,0,0,3,12]
[1,3,0,0,12]

[1,3,12,0,0]

*/
class MoveZeroes {


    fun moveZeroes(nums: IntArray): Unit {

        var i = 0
        var j = 0


        while (j != nums.size) {

            if (nums[i] == 0) {
                val t = nums[j]
                nums[t] = nums[i]
                nums[i] = t
                j++
            } else {
                i++
            }

        }

    }

    fun moveZeroes1(nums: IntArray): Unit {
        var i = 0
        var j = 0
        while (j <= nums.lastIndex) {
            if (nums[i] == 0) {
                // i on zero
                if (nums[j] != 0) {
                    // i at zero and j at non zero
                    // swap
                    val temp = nums[j]
                    nums[j] = nums[i]
                    nums[i] = temp
                    j++
                } else {
                    // i & j both are on zero
                    j++
                }
            } else {
                // i is not on zero
                i++
                j = i
            }
        }
    }

}


fun main() {

}