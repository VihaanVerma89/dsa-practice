package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {

    fun reverseString(s: CharArray): Unit{

        if(s.isEmpty()) return 

        var l = 0 
        var r = s.size-1

        while(l<r){

            val t = s[l]
            s[l] = s[r]
            s[r] =t 
           
            l++
            r--
        }
    }

}


fun main() {
    val instance = Solution()
    val grid = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )
}

