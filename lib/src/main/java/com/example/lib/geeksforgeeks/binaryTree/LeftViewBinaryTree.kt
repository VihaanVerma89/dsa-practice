package com.example.lib.geeksforgeeks.binaryTree

import java.util.*

class LeftViewBinaryTree {

    fun printLeftView(binaryTree: BinaryTree) {
        val root = binaryTree.root

        val q = LinkedList<Node>()
        q.add(root)

        var level = 0
        while (q.isNotEmpty()) {
            val value = q.remove()
            if (value != null) {
                val leftNode = value.leftNode
                if (leftNode != null) {
                    q.add(leftNode)
                }
                val rightNode = value.rightNode
                if (rightNode != null) {
                    q.add(rightNode)
                }
            }
        }
    }
}

fun main() {

    val node = Node(4)
    val binaryTree = BinaryTree(node)
    binaryTree.root.leftNode = Node(5)
    binaryTree.root.rightNode = Node(2)
    binaryTree.root.rightNode.leftNode = Node(3)
    binaryTree.root.rightNode.rightNode = Node(1)
    binaryTree.root.rightNode.leftNode.leftNode = Node(6)
    binaryTree.root.rightNode.leftNode.rightNode = Node(7)
//    binaryTree.printLevelOrderTraversalUsingQ()

    val leftViewBinaryTree = LeftViewBinaryTree()
    leftViewBinaryTree.printLeftView(binaryTree)

}