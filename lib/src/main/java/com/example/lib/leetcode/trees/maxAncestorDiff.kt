package com.example.lib.leetcode.trees

class maxAncestorDiff {

    // v = | a - b |
    fun maxAncestorDiff(root: TreeNode?): Int {


        // traversal
        if (root == null)
            return 0
        diffDfs(root, root?.`val`!!, root?.`val`!!)
        return result
    }

    var result = 0

    fun diffDfs(root: TreeNode?, minValue: Int, maxValue: Int) {

        // base condition
        if (root == null)
            return

        // logic
        val currValue = root?.`val`

        val diffMin = Math.abs(currValue!! - minValue)
        val diffMax = Math.abs(currValue!! - maxValue)

        result = Math.max(diffMin, result)
        result = Math.max(diffMax, result)

        // traverse
        diffDfs(root?.left, Math.min(currValue, minValue), Math.max(currValue, maxValue))
        diffDfs(root?.right, Math.min(currValue, minValue), Math.max(currValue, maxValue))
    }
}