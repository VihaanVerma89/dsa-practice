package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode

class Solution{
    
    fun maxAncestorDiff(root:TreeNode?):Int{
        
        if(root==null){return 0 } 
        else{
            val nodeValue = root.val
            dfs(root,nodeValue,nodeValue)
        }

        return v

    }

    var v = 0 
    
    fun dfs(node: TreeNode?, maxValue: Int, minValue: Int){
        
        if(node == null){return}


        // logic
        val nodeValue = node?.`val`?:0

        val minDiff = abs(minValue- nodeValue)
        val maxDiff = abs(maxValue- nodeValue)

        v = maxOf(minDiff, maxDiff, v)


        dfs(node?.left, maxOf(nodeValue, maxValue), minOf(nodeValue,minValue))
        dfs(node?.right, maxOf(nodeValue, maxValue), minOf(nodeValue,minValue))


    }

}

fun main(){

}

