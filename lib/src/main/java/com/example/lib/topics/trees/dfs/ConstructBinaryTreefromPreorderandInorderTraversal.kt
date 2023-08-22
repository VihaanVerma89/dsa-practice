package com.example.lib.topics.trees.dfs


class Solution {

    // start from first preorder element
    var pre_idx = 0
    lateinit var preorder: IntArray
    lateinit var inorder: IntArray
    var inorder_val_map = HashMap<Int, Int>()

    fun helper(in_left: Int, in_right: Int): TreeNode? {
        // if there is no elements to construct subtrees
        if (in_left == in_right) return null

        // pick up pre_idx element as a root
        val root_val = preorder[pre_idx]
        val root =
            TreeNode(root_val)

        // root splits inorder list
        // into left and right subtrees
        val index = inorder_val_map[root_val]!!

        // recursion
        pre_idx++
        // build left subtree
        root.left = helper(in_left, index)
        // build right subtree
        root.right = helper(index + 1, in_right)
        return root
    }

    fun buildTree(
        preorder: IntArray,
        inorder: IntArray
    ): TreeNode? {
        this.preorder = preorder
        this.inorder = inorder

        // build a hashmap value -> its index
        var idx = 0
        for (`val` in inorder) inorder_val_map[`val`] = idx++
        return helper(0, inorder.size)
    }
}

fun main() {

    val pre= intArrayOf(3, 9, 20, 15, 7)
    val ino= intArrayOf(9, 3, 15, 20, 7)

    val buildTree = Solution().buildTree(pre, ino)
}