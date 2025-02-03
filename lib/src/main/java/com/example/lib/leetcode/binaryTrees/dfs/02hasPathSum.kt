package com.example.lib.leetcode.binaryTrees.dfs

import com.example.lib.leetcode.binaryTrees.TreeNode

class `02hasPathSum` {


//    https://leetcode.com/problems/path-sum/


    var result = false
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root != null) {
            hasPathSumDfs(root, targetSum, 0)
        }
        return result
    }

    fun hasPathSumDfs(root: TreeNode?, targetSum: Int, currentSum: Int) {

        // term condition
        if (root != null && root?.left == null && root?.right == null) {
            if (targetSum == (currentSum + root.`val`)) {
                result = true
            }
        } else if (root == null) {
            return
        }

        // logic
        val value = root?.`val` ?: 0

        hasPathSumDfs(root?.left, targetSum, currentSum + value)
        hasPathSumDfs(root?.right, targetSum, currentSum + value)
    }


    fun hasPathSum1(root: TreeNode?, targetSum: Int): Boolean {

        // base condition
        if (root == null)
            return false
        val value = targetSum - root.`val`
        if (root.left == null && root.right == null && value == 0)
            return true

        var l = hasPathSum1(root?.left, targetSum - value)
        var r = hasPathSum1(root?.right, targetSum - value)
        return l || r
    }

    fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
        // Base condition
        val value = root?.`val` ?: 0
        val remainingSum = targetSum - value

        if (root == null) {
            return false
        } else if (root?.left == null && root?.right == null && remainingSum == 0) {
            // leaf node with matching sum found
            return true
        } else if (root?.left == null && root?.right == null && remainingSum != 0) {
            // leaf node without matching sum
            return false
        }

        var l = hasPathSum2(root?.left, remainingSum)
        var r = hasPathSum2(root?.right, remainingSum)

        return l || r
    }


}

fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(11).apply {
                left = TreeNode(7)
                right = TreeNode(2)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(13)
            right = TreeNode(4).apply {
                right = TreeNode(1)
            }

        }
    }

    val result = `02hasPathSum`().hasPathSum(root, 22)
    println(result)
}