package com.example.lib.leetcode

.01arrays.twopointers

class `03TwoSumSortedArray` {
    fun twoSum( numbers: IntArray, target: Int) : IntArray {


        val result = intArrayOf( -1, -1 )

        if( numbers.isEmpty( ) ) return result

        var l = 0
        var r = numbers.lastIndex


        while ( l < r ) {
            val sum = numbers[ l ] + numbers [ r ]
            if ( sum == target) {
                result[ 0 ] = l+ 1
                result[ 1 ] = r+1
                return result
            }

            when {
                sum < target -> l++
                sum > target -> r--
            }
        }

        return result
    }
    fun main() {
        val input = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = twoSum(input, target)
        println(result.contentToString()) // Output: [1, 2]
    }
}