package com.example.lib.leetcode.trees

class hasPathSum {


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

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {


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


        var l = hasPathSum(root?.left, remainingSum)
        var r = hasPathSum(root?.right, remainingSum)

        return l || r

    }


}