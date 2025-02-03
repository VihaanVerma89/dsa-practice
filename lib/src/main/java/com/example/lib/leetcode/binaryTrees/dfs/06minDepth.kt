package com.example.lib.leetcode.binaryTrees.dfs

import com.example.lib.leetcode.binaryTrees.TreeNode

class `06minDepth` {


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



    fun minDepth1(root: TreeNode?): Int {
        if(root == null) return 0
        minDfs1(root, 1)
        return minDepth
    }

    var minDepth1 =Int.MAX_VALUE

    fun minDfs1(root: TreeNode?, depth: Int) {

        // base condition
        if (root == null) {
            return
        }

        // logic
        if (root?.left == null && root?.right == null) {
            // leaf node
            if (depth < minDepth1) {
                minDepth1 = depth
            }
        }

        minDfs1(root?.left, depth + 1)
        minDfs1(root?.right, depth + 1)

    }


}