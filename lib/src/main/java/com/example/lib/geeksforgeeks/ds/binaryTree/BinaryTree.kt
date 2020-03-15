package com.example.lib.geeksforgeeks.ds.binaryTree

import java.util.*

class BinaryTree(val root: Node) {

    fun printLevelOrderTraversalUsingQ() {
        val q = LinkedList<Node>()
        q.add(root)

        while (q.isNotEmpty()) {
            val remove = q.remove()
            print(remove.value)
            print(" ")
            if (remove.leftNode != null) {
                q.add(remove.leftNode)
            }
            if (remove.rightNode != null) {
                q.add(remove.rightNode)
            }
        }
    }
}