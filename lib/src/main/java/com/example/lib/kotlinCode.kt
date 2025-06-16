package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {


    fun intersection(nums: Array<IntArray>): List<Int>{

        val hm = hashMapOf<Int,Int>( )


        for( array in nums){

            for(num in array){

                hm[num] = hm.getOrDefault(num, 0)+1

            }
        }

        val result = mutableListOf<Int>( )

        for( (k,v) in hm ){

            if( v == nums.size ){
                result.add(k)
            }

        }


        return result.sorted()

    }


}



fun main() {


}

