package com.example.lib.topics.linkedList


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

    //    fun flatten(head: Node?): Node? {
//        if (head == null) return head
//        val pseudoHead = Node(0, null, head, null)
//        var curr: Node
//        var prev = pseudoHead
//        val stack: Deque<Node> = ArrayDeque()
//        stack.push(head)
//        while (!stack.isEmpty()) {
//            curr = stack.pop()
//            prev.next = curr
//            curr.prev = prev
//            if (curr.next != null) stack.push(curr.next)
//            if (curr.child != null) {
//                stack.push(curr.child)
//                // don't forget to remove all child pointers.
//                curr.child = null
//            }
//            prev = curr
//        }
//        // detach the pseudo node from the result
//        pseudoHead.next!!.prev = null
//        return pseudoHead.next
//    }
    open fun flatten(head: Node?): Node? {
        if (head == null) return head
        // pseudo head to ensure the `prev` pointer is never none
        val pseudoHead = Node(0, null, head, null)
        flattenDFS(pseudoHead, head)

        // detach the pseudo head from the real head
        pseudoHead.next!!.prev = null
        return pseudoHead.next
    }

    /* return the tail of the flatten list */
    fun flattenDFS(prev: Node, curr: Node?): Node {
        if (curr == null) return prev
        curr.prev = prev
        prev.next = curr

        // the curr.next would be tempered in the recursive function
        val tempNext = curr.next
        val tail = flattenDFS(curr, curr.child)
        curr.child = null
        return flattenDFS(tail, tempNext)
    }

}

fun main() {

    val node1 = FlattenaMultilevelDoublyLinkedList.Node()
    node1.`val` = 1
    val node2 = FlattenaMultilevelDoublyLinkedList.Node()
    node2.`val` = 2
    node1.next = node2

    val node3 = FlattenaMultilevelDoublyLinkedList.Node()
    node3.`val` = 3
    node2.next = node3
    val node4 = FlattenaMultilevelDoublyLinkedList.Node()
    node4.`val` = 4
    node3.next = node4
    val node5 = FlattenaMultilevelDoublyLinkedList.Node()
    node5.`val` = 5
    node2.child = node5
    val node6 = FlattenaMultilevelDoublyLinkedList.Node()
    node6.`val` = 6
    node5.next = node6

    val node7 = FlattenaMultilevelDoublyLinkedList.Node()
    node7.`val` = 7
    node6.next = node7

    val node8 = FlattenaMultilevelDoublyLinkedList.Node()
    node8.`val` = 8
    node6.child = node8

    val node9 = FlattenaMultilevelDoublyLinkedList.Node()
    node9.`val` = 9
    node8.next = node9

    val i = FlattenaMultilevelDoublyLinkedList()
    var flatten = i.flatten(node1)

    if (flatten != null) {
        while (flatten != null) {
            println(flatten.`val`)
            flatten = flatten.next
        }
    }
}
