package com.example.lib.leetcode.trees

class diameterOfBinaryTree {

    fun diameterOfBinaryTree(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }
        dfs(root)
        return result
    }

    var result = 0
    fun dfs(root: TreeNode?): Int {

        // base condition
        if (root == null) {
            return 0
        } else if (root?.left == null && root?.right == null) {
           // leaf node
            return 1
        }

        val l = dfs(root?.left)
        val r = dfs(root?.right)

        val d = l + r
        if (d > result) {
            result = d
        }

        return Math.max(l, r)
    }

}