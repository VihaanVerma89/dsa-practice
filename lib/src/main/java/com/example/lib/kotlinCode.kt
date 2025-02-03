package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode

class Solution{

    var maxD=0

    fun diameterOfBinaryTree(root:TreeNode?):Int{
        dfs(root)
        return maxD
    }

    fun dfs(node: TreeNode?):Int{
        // term condition
        if(node == null){return 0}

        // traversal
        val leftHeight = dfs(node.left)
        val rightHeight = dfs(node.right)

        maxD = maxOf(maxD, leftHeight + rightHeight)

        // logic
        return 1 + maxOf(leftHeight, rightHeight)
    }


}

fun main(){

}

