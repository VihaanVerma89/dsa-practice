package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {


    fun findLongestSubstring(s:String, k: Int): Int{

        var l = 0
        var maxLen = Int.MIN_VALUE
        val hm = HashMap<Char, Int>( ) 


        for ( r in s.indices ) {

            val c = s[r]

            hm[c] = hm.getOrDefault(c, 0 ) + 1

             
            while( hm[c] > k ){

                val lc = s[l]
                hm[lc] = hm[lc]!! - 1

                l++
            }

            // hm[c] <=k 

            val len = r - l + 1
            maxLen = maxOf(maxLen, len)
        }

        return maxLen
    }


}



fun main() {


}

