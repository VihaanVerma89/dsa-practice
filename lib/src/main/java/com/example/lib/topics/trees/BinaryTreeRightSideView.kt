package com.example.lib.topics.trees

import apple.laf.JRSUIUtils
import com.example.lib.topics.linkedList.addTwoNumbers.LinedListUtil
import java.util.*

//https://leetcode.com/problems/binary-tree-right-side-view/
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {

        val l = mutableListOf<Int>()
        root?.let {
            val q: Queue<TreeNode> = LinkedList<TreeNode>()
            q.add(root)

            while (q.isNotEmpty()) {

                val last = q.last().`val`
                l.add(last)

                val s = q.size
                var i = 0
                while (i < s) {
                    val poll = q.poll()

                    poll?.let {
                        it.left?.let {
                            q.add(it)
                        }
                        it.right?.let {
                            q.add(it)
                        }
                    }
                    i++
                }
            }
        }
        return l
    }
}


fun main() {
    val o = BinaryTreeRightSideView()
    val treeNode = TreeNode(0)
    o.rightSideView(treeNode)
}

