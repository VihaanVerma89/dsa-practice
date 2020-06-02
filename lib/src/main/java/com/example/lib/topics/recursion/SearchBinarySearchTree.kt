package com.example.lib.topics.recursion

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


val q = LinkedList<TreeNode>()

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {

    if (root?.`val` == `val`) {
        return root
    }

    if (root?.left != null) {
        q.push(root.left)
    }

    if (root?.right != null) {
        q.push(root.right)
    }


    var result: TreeNode? = null
    if (q.isNotEmpty()) {
        val pop = q.pop()
        result = searchBST(pop, `val`)
    }

    return result
}


fun main() {

}