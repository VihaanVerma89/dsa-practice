package com.example.lib.topics.trees.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class insertIntoBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {

        if (root == null) {
            // empty input
            return TreeNode(`val`)
        } else {
            insertIntoBstWithTraversal(root, `val`)
        }
        return root
    }

    fun insertIntoBstWithTraversal(root: TreeNode?, `val`: Int): TreeNode? {
        // base condition
        if (root == null) {
            return null
        }

        // logic
        // find the spot
        // traversal
        // manipulate the node ref
        val currValue = root?.`val`!!
        var result: TreeNode? = null
        if (`val` < currValue) {
            result = insertIntoBstWithTraversal(root?.left, `val`)
            if (result == null) {
                root.left = TreeNode(`val`)
            }
        } else if (currValue < `val`) {
            result = insertIntoBstWithTraversal(root?.right, `val`)
            if (result == null) {
                root.right = TreeNode(`val`)
            }
        }
        return root
    }
}