package com.example.lib.topics.trees.dfs

import com.example.lib.geeksforgeeks.binaryTree.BinaryTree
import com.example.lib.geeksforgeeks.binaryTree.Node
import java.util.*

class LeftViewBinaryTree {

    fun printLeftView(binaryTree: BinaryTree) {
        val root = binaryTree.root

        val q = LinkedList<Node>()
        q.add(root)

        while (q.isNotEmpty()) {
            val levelNodeCount = q.size

            for (i in 0 until levelNodeCount) {
                val node = q.remove()
                if (i == 0) {
                    print(node.value)
                }

                if (node.leftNode != null) {
                    q.add(node.leftNode)
                }

                if (node.rightNode != null) {
                    q.add(node.rightNode)
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