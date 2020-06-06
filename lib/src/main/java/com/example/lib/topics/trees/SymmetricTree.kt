package com.example.lib.topics.trees

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode(`val`=$`val`)"
    }
}

//fun isSymmetric(root: TreeNode?): Boolean {
//
//    return isMirror(root, root)
//}

fun isMirror(n1: TreeNode?, n2: TreeNode?): Boolean {

    if (n1 == null && n2 == null)
        return true
    else if (n1 == null || n2 == null)
        return false


    val mirror = n1?.`val` == n2?.`val` &&
            isMirror(n1?.left, n2?.right) && isMirror(n1?.right, n2?.left)
    return mirror
}

fun isSymmetric(root: TreeNode?): Boolean {

    val q = LinkedList<TreeNode>()

    q.push(root)
    q.push(root)

    while (q.isNotEmpty()) {

        val n1 = q.poll()
        val n2 = q.poll()

        if (n1.`val` != n1.`val`) {
            return false
        }

        if (n1 == null && n2 == null) {
            continue
        }


        if (n1.left != null && n2.left != null) {
            q.push(n1.left)
            q.push(n2.right)
            q.push(n1.right)
            q.push(n2.left)
        }

        if (n1 == null || n2 == null) {
            return false
        }

    }

    return true

}


fun main() {

}