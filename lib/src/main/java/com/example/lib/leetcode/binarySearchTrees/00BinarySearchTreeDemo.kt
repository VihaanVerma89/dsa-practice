package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class BinarySearchTreeDemo {


    fun searchBst(root: TreeNode?, key: Int): TreeNode? {

        // term condition

        if (root == null || root.`val` == key) {
            return root
        }


        // logic : divide the search in half

        return if (key < root.`val`) {
            searchBst(root.left, key)
        } else {
            searchBst(root.right, key)
        }

    }


    fun insertBst(root: TreeNode?, key: Int): TreeNode {

        // term condition
        if (root == null) {
            return TreeNode(key)
        }

        //logic
        val value = root.`val`

        if (key < value) {
            root.left = insertBst(root.left, key)
        } else if (key > value) {
            root.right = insertBst(root.right, key)
        } else if (key == value) {
            println("invalid key")

        }

        //return to parent
        return root
    }

    /*
    Imp point:
    - Inorder traversal of bst prints the elements in sorted order.
     */
    fun inOrderTraversal(root: TreeNode?) {

        // term condition
        if (root == null) return

        inOrderTraversal(root?.left)
        println(root?.`val`)
        inOrderTraversal(root?.right)

    }


    fun sortedArrayToBST(nums: List<Int>): TreeNode? {
        if (nums.isEmpty()) return null
        return constructBST(nums, 0, nums.size - 1)
    }

    fun constructBST(nums: List<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val mid = (start + end) / 2
        val node = TreeNode(nums[mid])

        node.left = constructBST(nums, start, mid - 1)
        node.right = constructBST(nums, mid + 1, end)

        return node
    }

}

fun main() {

//    insertDemo()
    traversalDemo()
}

fun insertDemo() {
    val bst = BinarySearchTreeDemo()
    val insertRootInput = TreeNode(1)
    bst.insertBst(insertRootInput, 2)
    bst.insertBst(insertRootInput, 3)
    bst.insertBst(insertRootInput, 4)
    bst.insertBst(insertRootInput, 5)
    bst.insertBst(insertRootInput, 6)
}

fun traversalDemo() {
    val bst = BinarySearchTreeDemo()
    val list = listOf(1, 3, 4, 6, 7, 8, 10, 13, 14)
    val input = bst.sortedArrayToBST(list)
    bst.inOrderTraversal(input)
}









































