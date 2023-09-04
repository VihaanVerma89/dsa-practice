package com.example.lib.topics.trees.dfs

import com.example.lib.leetcode.trees.TreeNode
import com.example.lib.topics.linkedList.addTwoNumbers.LinedListUtil
import com.example.lib.topics.recursion.q
import java.util.*

//https://leetcode.com/problems/binary-tree-right-side-view/
class BinaryTreeRightSideView {
    fun rightSideView1(root: TreeNode?): List<Int> {

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

    fun rightSideView(root: TreeNode?): List<Int> {

        val result = arrayListOf<Int>()
        if (root == null) {

        } else {
            val q = LinkedList<TreeNode>()

            q.add(root)
            root?.`val`?.let { result.add(it) }

            var node: TreeNode? = null
            var size = 0

            while (q.isNotEmpty()) {

                size = q.size

                for (i in 0 until size) {
                    node = q.poll()

                    if (node.left != null) {
                        q.add(node.left!!)
                    }

                    if (node.right != null) {
                        q.add(node.right!!)
                    }
                    if (i == size - 1) {
                        // last node of level
                        result.add(node.`val`)
                    }
                }

                //
            }
        }

        return result
    }

}


fun main() {
    val o = BinaryTreeRightSideView()
    val treeNode = TreeNode(0)
    o.rightSideView(treeNode)
}

