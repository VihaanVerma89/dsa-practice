package com.example.lib.leetcode.trees

class minDepth {


    fun minDepth(root: TreeNode?): Int {
        if(root == null) return 0
        minDfs(root, 1)
        return minDepth
    }

    var minDepth =Int.MAX_VALUE

    fun minDfs(root: TreeNode?, depth: Int) {

        // base condition
        if (root == null) {
            return
        }

        // logic
        if (root?.left == null && root?.right == null) {
            // leaf node
            if (depth < minDepth) {
                minDepth = depth
            }
        }

        minDfs(root?.left, depth + 1)
        minDfs(root?.right, depth + 1)

    }


}