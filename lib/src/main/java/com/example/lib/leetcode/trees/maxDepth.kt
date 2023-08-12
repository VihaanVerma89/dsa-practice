package com.example.lib.leetcode.trees

class maxDepth {

    fun maxDepth(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
        }

    }

}

fun main() {
}