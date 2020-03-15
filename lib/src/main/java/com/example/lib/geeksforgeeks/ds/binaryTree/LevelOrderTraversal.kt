package com.example.lib.geeksforgeeks.ds.binaryTree

fun main() {

    val node = Node(1)
    val binaryTree = BinaryTree(node)

    binaryTree.root.leftNode = Node(2)
    binaryTree.root.rightNode = Node(3);
    binaryTree.root.leftNode.leftNode = Node(4);
    binaryTree.root.rightNode.rightNode = Node(5);

    binaryTree.printLevelOrderTraversalUsingQ()
}