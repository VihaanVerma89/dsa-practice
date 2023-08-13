package com.example.lib.leetcode.trees


class isSameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {


        // base condition
        if (p == null && q == null) {
            return true
        } else if (p == null && q != null) {
            return false
        } else if (p != null && q == null) {
            return false
        }

        // logic
        val same = p?.`val` == q?.`val`

        // recursion
        return  same && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }


}

fun main() {
    val sameTree = isSameTree()
    val p = TreeNode(1).apply {
        left = TreeNode(2)
        right = null
    }

    val q = TreeNode(1).apply {
        right = TreeNode(2)
    }

    val  same = sameTree.isSameTree(p, q)
    println("same : $same")
}

