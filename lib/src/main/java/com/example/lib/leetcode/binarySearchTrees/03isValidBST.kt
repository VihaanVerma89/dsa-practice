package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class isValidBST {

    fun isValidBST(root: TreeNode?): Boolean {

        return dfs(root,Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun dfs(node: TreeNode?, s: Long, l: Long) : Boolean{


        if(node == null) { return true}

        val value = node.`val`
//        if(value>= l || value <= s) return false

        println("node value : $value , s: $s, l: $l")

        val left = dfs(node?.left, s, node.`val`.toLong())
        val right = dfs(node?.right, node.`val`.toLong(),l)

        return left &&  right
    }


}


fun main() {

//    invalidBstTest()
    invalidBstTest1()

}

fun invalidBstTest() {
    val instance = isValidBST()

    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(15)
    root.right?.left = TreeNode(6)  // Invalid BST
    root.right?.right = TreeNode(20)
    val solution = instance.isValidBST(root)
}

/*
        10
       /  \
      5    15
          /   \
        14     20
       /  \
     13    16
    /        \
   6         17


 */
fun invalidBstTest1() {
    val instance = isValidBST()

    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(15)
    root.right?.left = TreeNode(14)
    root.right?.right = TreeNode(20)


    root.right?.left?.left = TreeNode(13)
    root.right?.left?.right = TreeNode(16)

    root.right?.left?.right?.right = TreeNode(17)
    root.right?.left?.left?.left = TreeNode(6)

    val solution = instance.isValidBST(root)
}