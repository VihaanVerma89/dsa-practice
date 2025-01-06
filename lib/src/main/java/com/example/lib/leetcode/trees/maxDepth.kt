package com.example.lib.leetcode.trees

class maxDepth {

    var max = 0
    fun maxDepth(root: TreeNode?, depth: Int) {
        if (root == null) {
            if (depth > max) {
                max = depth
            }
            return
        }

        maxDepth(root?.left, depth + 1)
        maxDepth(root?.right, depth + 1)
    }

    fun maxDepth(root: TreeNode?): Int {
        maxDepth(root, 0)
        return max
    }

    fun maxDepth1(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
        }

    }

}

fun main() {
}