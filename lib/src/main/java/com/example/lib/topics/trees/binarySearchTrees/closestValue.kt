package com.example.lib.topics.trees.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class closestValue {

    var minNode: TreeNode? = null
    var minDiff: Double = 0.0
    fun closestValue(root: TreeNode?, target: Double): Int {

        // base condition
        if (root == null) {
            return 0
        }

        // logic
        // diff at each node and keep the min stored
        val diff: Double = Math.abs(target - root.`val`.toFloat())
        if (minNode == null) {
            minNode = root
            minDiff = diff
        } else {
            if (diff < minDiff) {
                minNode = root
                minDiff = diff
            } else if (diff == minDiff) {
                if (minNode!!.`val` < root.`val`) {

                } else if (root.`val` < minNode!!.`val`) {
                    minNode = root
                }
            }
        }

        // traversal
        // full or smart ?

        closestValue(root?.left, target)
        closestValue(root?.right, target)


        return minNode!!.`val`!!
    }

}