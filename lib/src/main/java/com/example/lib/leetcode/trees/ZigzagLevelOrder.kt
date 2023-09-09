package com.example.lib.leetcode.trees

import com.example.lib.leetcode.trees.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class zigzagLevelOrder {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val r = arrayListOf<ArrayList<Int>>()

        if (root != null) {
            val q = LinkedList<TreeNode>()
            var node = root
            q.add(node)
            var d = 0
            val s = Stack<TreeNode>()
            while (q.isNotEmpty()) {

                val l2r = arrayListOf<Int>()
                val r2l = arrayListOf<Int>()

                for (i in 0 until q.size) {
                    node = q.remove()
                    if (d % 2 == 0) {
                        // l -> r traversal
                        if (node != null) {
                            l2r.add(node.`val`)
                        }
                    } else {
                        // l <-r traversal
                        s.push(node)
                    }
                    node?.left?.let { q.add(it) }
                    node?.right?.let { q.add(it) }
                }

                // level traversal complete
                if (d % 2 == 0) {
                    // l -> r
                    r.add(l2r)
                } else {
                    // l <- r
                    while (s.isNotEmpty()) {
                        var tempNode = s.pop()
                        r2l.add(tempNode.`val`)
                    }
                    r.add(r2l)
                }
                d++
            }

        }

        return r
    }

}