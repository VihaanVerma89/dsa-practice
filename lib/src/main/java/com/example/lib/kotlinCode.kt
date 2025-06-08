package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {


    fun longestOnes(nums: IntArray, k: Int) : Int{

        var l = 0 
        var z = 0 
        var maxLen = Int.MIN_VALUE

        for(r in nums.indices){

            if(nums[r]==0){
                z++
            }

            while( z > k){

                if(nums[l]==0){
                    z--
                }

                l++
            }

            val len = r - l + 1
            maxLen = maxOf( maxLen, len)

        }

        return maxLen
       
    }

}


fun main() {
}

