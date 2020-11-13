package com.example.lib.topics.linkedList

import java.util.*


class FlattenaMultilevelDoublyLinkedList {

    class Node {
        var `val` = 0
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null

        constructor() {}
        constructor(_val: Int, _prev: Node?, _next: Node?, _child: Node?) {
            `val` = _val
            prev = _prev
            next = _next
            child = _child
        }

        override fun toString(): String {
            return "Node(`val`=$`val`)"
        }
    }

    fun flatten(root: Node?): Node? {

        root?.let {
            var node = root
            val s = Stack<Node>()
            while (node != null) {

                val next = node.next
                val child = node.child
                if (child == null && next != null) {
                    node = next
                } else if (child != null && next == null) {
                    node.child = null
                    node.next = child
                    child.prev = node
                    node = child
                } else if (child != null && next != null) {
                    node.next = child
                    child.prev = node
                    node.child = null
                    s.push(next)
                    node = child
                } else if (child == null && next == null) {
                    if (s.isNotEmpty()) {
                        val pop = s.pop()
                        node.next = pop
                        pop.prev = node
                        node = pop
                    } else {
                        node = null
                    }
                }
            }
        }
        return root
    }

}

fun main() {

    val node1 = FlattenaMultilevelDoublyLinkedList.Node()
    node1.`val` = 1

    val node2 = FlattenaMultilevelDoublyLinkedList.Node()
    node2.`val` = 2
    node1.next = node2
    node2.prev = node1

    val node3 = FlattenaMultilevelDoublyLinkedList.Node()
    node3.`val` = 3
    node2.next = node3
    node3.prev = node2


    val node4 = FlattenaMultilevelDoublyLinkedList.Node()
    node4.`val` = 4
    node3.next = node4
    node4.prev = node3

    val node5 = FlattenaMultilevelDoublyLinkedList.Node()
    node5.`val` = 5
    node4.next = node5
    node5.prev = node4


    val node6 = FlattenaMultilevelDoublyLinkedList.Node()
    node6.`val` = 6
    node5.next = node6
    node6.prev = node5


    val node7 = FlattenaMultilevelDoublyLinkedList.Node()
    node7.`val` = 7
    node3.child = node7

    val node8 = FlattenaMultilevelDoublyLinkedList.Node()
    node8.`val` = 8
    node7.next = node8
    node8.prev = node7

    val node9 = FlattenaMultilevelDoublyLinkedList.Node()
    node9.`val` = 9
    node8.next = node9
    node9.prev = node8


    val node10 = FlattenaMultilevelDoublyLinkedList.Node()
    node10.`val` = 10
    node9.next = node10
    node10.prev = node9

    val node11 = FlattenaMultilevelDoublyLinkedList.Node()
    node11.`val` = 11
    node8.child = node11

    val node12 = FlattenaMultilevelDoublyLinkedList.Node()
    node12.`val` = 12
    node11.next = node12
    node12.prev = node11


    val i = FlattenaMultilevelDoublyLinkedList()
    var flatten = i.flatten(node1)

    if (flatten != null) {
        while (flatten != null) {
            println(flatten.`val`)
            flatten = flatten.next
        }
    }
}
