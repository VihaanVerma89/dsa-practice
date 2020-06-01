package com.example.lib.topics.recursion


private var head: ListNode? = null
fun reverseList(position: Int, node: ListNode?): ListNode? {

    if (node == null) {
        return null
    }

    if (node.next == null) {
        head = node
    }
    reverseList(position + 1, node.next)
    node.next?.next = node
    if (position == 0) {
        node?.next = null
    }
//    else {
//        node.next?.next = node
//    }
    return head
}

fun printLinkedList(node: ListNode?) {

    var i = node
    while (i?.`val` != null) {
        print("[${i?.`val`}]")
        i = i.next
    }

}

fun main() {

    var node = ListNode(1)
    node.next = ListNode(2)
    node.next?.next = ListNode(3)
    node.next?.next?.next = ListNode(4)
    node.next?.next?.next?.next = ListNode(5)

    printLinkedList(node)
    val reverseList = reverseList(0, node)
    printLinkedList(reverseList)
}
