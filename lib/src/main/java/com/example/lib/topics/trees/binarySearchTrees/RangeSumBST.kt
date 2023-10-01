package com.example.lib.topics.trees.binarySearchTrees

import com.example.lib.leetcode.trees.TreeNode

class rangeSumBST {


    var sum = 0
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {

        // base condition
        if (root == null) {
            return 0
        }


        // logic
        val value = root.`val`
        if (value in low..high) {
            sum += value
        }

        // traversal
        if (low < value) {
            rangeSumBST(root?.left, low, high)
        }
        if (value < high) {
            rangeSumBST(root?.right, low, high)
        }

        return sum
    }
}