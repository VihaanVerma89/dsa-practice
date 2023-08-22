package com.example.lib.topics.trees

import java.util.*


class PopulatingNextRightPointersinEachNode {


    fun connect(root: Node?): Node? {
        if (root != null) {
            val q: Queue<Node> = LinkedList<Node>()
            q.add(root)
            while (q.isNotEmpty()) {
                val size = q.size
                for (i in 0 until size) {
                    val remove = q.poll()
                    val peek = q.peek()
                    remove.next = peek
                    if (remove.left != null) {
                        q.add(remove.left)
                    }
                    if (remove.right != null) {
                        q.add(remove.right)
                    }
                    if (i == size - 1) {
                        remove.next = null
                    }
                }
            }
        }
        return root
    }
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

fun main() {

}