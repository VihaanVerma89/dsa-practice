package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class rangeSumBST {


    var sum = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {

        if (root == null) {
            return 0
        }

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

    fun rangeSumBST1(root: TreeNode?, low: Int, high: Int): Int {
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
            rangeSumBST1(root?.left, low, high)
        }
        if (value < high) {
            rangeSumBST1(root?.right, low, high)
        }

        return sum
    }
}