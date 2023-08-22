package com.example.lib.topics.trees

import java.util.*
import kotlin.collections.ArrayList


fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

    val r = ArrayList<ArrayList<Int>>()

    if (root != null) {
        val q: Deque<TreeNode> = LinkedList()
        q.addLast(root)
        var l = 0
        var l2r = true
        var lNodes = LinkedList<Int>()
        while (q.isNotEmpty()) {
            val n = q.pollFirst()
            if (n != null) {
                if (l2r) {
                    lNodes.addLast(n.`val`)
                } else {
                    lNodes.addFirst(n.`val`)
                }
                if (n.left != null) {
                    q.addLast(n.left)
                }
                if (n.right != null) {
                    q.addLast(n.right)
                }
            } else {

            }
        }
    }

    return r
}

fun zigzagLevelOrderMine(root: TreeNode?): List<List<Int>> {

    val r = ArrayList<ArrayList<Int>>()
    val q: Deque<TreeNode> = LinkedList()

    if (root != null) {
        q.add(root)
        var l = 0
        while (q.isNotEmpty()) {
            val s = q.size
            val lNodes = arrayListOf<Int>()
            var n: TreeNode? = null

            for (i in 0 until s) {

                if (l % 2 == 0) {
                    // l to r
                    n = q.removeFirst()
                    lNodes.add(n.`val`)
                } else {
                    // r to l
                    n = q.removeLast()
                    lNodes.add(n.`val`)
                }

                if (n?.left != null) {
                    q.addLast(n.left)
                }
                if (n?.right != null) {
                    q.addLast(n.right)
                }
            }
            r.add(lNodes)
            l++
        }
    }

    return r
}


fun main() {
//    [3,9,20,null,null,15,7]

    val treeNode = TreeNode(3)
    treeNode?.left = TreeNode(9)
    treeNode?.right = TreeNode(20)

    treeNode?.left?.left = null
    treeNode?.right?.left = TreeNode(15)
    treeNode?.right?.right = TreeNode(7)
    zigzagLevelOrder(treeNode)
}
