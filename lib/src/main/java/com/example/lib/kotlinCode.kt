package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {


    fun longestStringWithFlip(nums: IntArray, k: Int) : Int{
        

        var l = 0 
        var maxLen = Int.MIN_VALUE
        var zCount = 0

        for(r in nums.indices){

            if(nums[r]==0){
                zCount++
            }
            
            while(zCount > 1){

                if(nums[l]==0){
                    zCount--
                }

                l++
            }

            maxLen = maxOf(maxLen, r-l+1)
        }
        return maxLen

    }

}


fun main() {
}

