package com.example.lib.leetcode

.01arrays.twopointers

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class `03TwoSumSortedArray` {

    fun twoSum25Mar26(numbers: IntArray, target: Int): IntArray {

        var l = 0
        var r = numbers.lastIndex
        val ans = intArrayOf(0,0)
        var sum = 0
        while( l < r )
        {
            sum = numbers[l]+ numbers[r]

            when{
                sum == target -> {
                    ans[0] = l + 1
                    ans[1] = r + 1
                    break
                }
                sum < target -> {
                    l++
                }
                sum > target -> {
                    r--
                }
            }

        }

        return ans

    }

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