package com.example.lib.leetcode.trees

import kotlin.math.abs


class maxAncestorDiff {

    /*
    Time - o(n)
    - we visit each node once
    Space - o(n)
    - We are storing data on the stack
    - In worst case the depth can be equal to number of nodes
    - so worst storage would be o(n)
    - in normal cases the depth will half in traversal
    - so best case storage would be o(log n)
     */
    fun maxAncestorDiff(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            val value = root.`val`
            maxAncestorDiffWithData(root, value, value)
        }

        return result
    }

    fun maxAncestorDiffWithData(root: TreeNode?, minValue: Int, maxValue: Int) {

        // term condition
        if (root == null) {
            return
        }

        // logic
        val nodeValue = root?.`val`!!
        val minDiff = abs(nodeValue - minValue)
        val maxDiff = abs(nodeValue - maxValue)


        result = maxOf(minDiff, maxDiff, result)

        // traversal
        maxAncestorDiffWithData(root?.left, minOf(nodeValue, minValue), maxOf(nodeValue, maxValue))
        maxAncestorDiffWithData(root?.right, minOf(nodeValue, minValue), maxOf(nodeValue, maxValue))

    }

    // v = | a - b |
    fun maxAncestorDiff1(root: TreeNode?): Int {
        // traversal
        if (root == null)
            return 0
        diffDfs1(root, root?.`val`!!, root?.`val`!!)
        return result
    }

    var result = 0

    fun diffDfs1(root: TreeNode?, minValue: Int, maxValue: Int) {

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
        diffDfs1(root?.left, Math.min(currValue, minValue), Math.max(currValue, maxValue))
        diffDfs1(root?.right, Math.min(currValue, minValue), Math.max(currValue, maxValue))
    }
}