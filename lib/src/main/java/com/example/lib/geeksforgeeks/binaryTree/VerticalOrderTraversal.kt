package com.example.lib.geeksforgeeks.binaryTree

import java.util.*


fun main() {

    val root = Node(1)
    val binaryTree = BinaryTree(root)
    root.leftNode = Node(2)
    root.rightNode = Node(3)
    root.leftNode.leftNode = Node(4)
    root.leftNode.rightNode = Node(5)
    root.rightNode.leftNode = Node(6)
    root.rightNode.rightNode = Node(7)
    root.rightNode.leftNode.rightNode = Node(8)
    root.rightNode.rightNode.rightNode = Node(9)
    verticalTraversal(root, 0)
    println("Vertical Order traversal is")
    printVerticalOrder(root)
}


val map = TreeMap<Int, ArrayList<Node>>()
fun verticalTraversal(node: Node, verticalCount: Int) {

    if (map.containsKey(verticalCount)) {
        val arrayList = map[verticalCount]
        arrayList?.add(node)
    } else {
        val arrayListOf = arrayListOf<Node>()
        map[verticalCount] = arrayListOf
        arrayListOf.add(node)
    }
    if (node.getLeftNode() != null) {
        verticalTraversal(node.leftNode, verticalCount - 1)
    }

    if (node.getRightNode() != null) {
        verticalTraversal(node.rightNode, verticalCount + 1)
    }
}

fun printVerticalOrder(root: Node) {
    for (mutableEntry in map) {
        val key = mutableEntry.key
        val value = mutableEntry.value
        val joinToString = value.joinToString(",")
        println("Level $key : $joinToString")
    }
}