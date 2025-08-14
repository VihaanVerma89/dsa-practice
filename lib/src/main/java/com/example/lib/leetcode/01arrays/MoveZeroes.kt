package com.example.lib.leetcode.`01arrays`

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


    // my logic on how to handle the pointer.
    // it has extra maxOf logic to always keep r>= l
    fun moveZeroes2( nums: IntArray ) {

        var l = 0
        var r = 0


        while ( r < nums.size ) {

            if( nums[ l ] == 0 && nums[ r ] !=0 ) {
                // swap
                val t = nums[ l ]
                nums[ l ]  = nums[ r ]
                nums[ r ] = t
                l ++
                r++
            } else if ( nums [ l ] != 0 ) {
                l++
                r = maxOf( l, r )
            }
            else if ( nums[ r ] == 0 ) {
                r++
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


    fun moveZeroes(nums: IntArray) {
        var l = 0
        for (r in nums.indices) {

            if (nums[r] != 0) {

                if (l != r) {
                    val t = nums[l]
                    nums[l] = nums[r]
                    nums[r] = t
                }

                l++
            }

        }
    }
}


fun main() {
    val instance = MoveZeroes()
    val input = intArrayOf(1, 2, 0)
    instance.moveZeroes(input)

    println(input.contentToString())

}