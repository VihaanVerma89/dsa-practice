package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {

    fun subarraySum(nums: IntArray, k: Int) : Int {
        
        var l = 0 
        var r = 0 
        var diff = 0 
        var cSum = 0 
        val map = mutableMapOf<Int, Int>()
        var count = 0 


        for( i in nums.indices ){

            cSum += nums[i]
            diff = cSum - k

            if( map.contains(diff)){
                count += map.getOrDefault(diff,0)
            }


            map[cSum] = map.getOrDefault(cSum, 0 )+1

        }
        return count

    }

}


fun main() {
    val instance = Solution()
    val grid = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )
}

