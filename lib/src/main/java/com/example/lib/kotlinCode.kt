package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode

class Solution{


    var minDepth = Int.MAX_VALUE

    fun minDepth(root: TreeNode?): Int{

        if(root == null){return 0 }

        minDepthDfs(root,1)

        return minDepth
    } 

    fun minDepthDfs(root: TreeNode?, depth: Int):Int{

        // term condition
        if(root == null){
            // no more nodes to process
            return depth
        }
        else if(root?.left == null && root?.right == null){
            // we have leaf node
            minDepth = minOf(minDepth, depth)
            return minDepth
        }


        minDepthDfs(root?.left, depth+1)
        minDepthDfs(root?.right, depth+1)

        return depth
    }

}

fun main(){
    val root = arrayToTreeNode(arrayOf(2,null,3,null,4,null,5,null,6))
    Solution().minDepth(root)
}

fun arrayToTreeNode(arr: Array<Int?>): TreeNode? {
    if (arr.isEmpty() || arr[0] == null) return null

    // Create the root node
    val root = TreeNode(arr[0]!!)
    var current = root

    // Iterate through the array to build the tree
    for (i in 1 until arr.size) {
        val value = arr[i]
        if (value != null) {
            current.right = TreeNode(value)
            current = current.right!!
        }
    }

    return root
}
