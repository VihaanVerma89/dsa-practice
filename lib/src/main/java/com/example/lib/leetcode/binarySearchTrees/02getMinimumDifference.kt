package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode
import kotlin.math.abs

class getMinimumDifference {

    fun getMinimumDifference(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }

        val sortedList = mutableListOf<Int>()
        inorder(root, sortedList)

        var minDiff = Int.MAX_VALUE
        for (i in 0 until sortedList.size - 1) {
            val diff = abs(sortedList[i] - sortedList[i + 1])
            minDiff = minOf(minDiff, diff)
        }

        return minDiff
    }

    fun inorder(root: TreeNode?, sortedList: MutableList<Int>) {

        if (root == null) {
            return
        }

        inorder(root?.left, sortedList)
        sortedList.add(root.`val`)
        inorder(root?.right, sortedList)

    }
}