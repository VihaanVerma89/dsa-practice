package com.example.lib.leetcode.trees


class BinaryTreePreorderTraversal {
    fun preOrder(root: TreeNode?) {

        // base condition
        if (root == null) {
           return
        }

        println(root?.`val`)
        preOrder(root?.left)
        preOrder(root?.right)

    }

}

fun main() {
    val root = TreeNode(0).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(6).apply { }
            }
            right = TreeNode(4).apply {
                left = TreeNode(7)
                right = TreeNode(8)
            }
        }
        right = TreeNode(2).apply {
            right = TreeNode(5)
        }
    }

    val instance = BinaryTreePreorderTraversal()
    instance.preOrder(root)

}