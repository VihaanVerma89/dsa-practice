package com.example.lib.topics.recursion


//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }

}

fun swapPairs(head: ListNode?): ListNode? {

    var resultNode: ListNode? = head
    if (head?.next != null) {
        val i = head
        val j = i?.next
        resultNode = j
        swapPairsRecursion(null, i, j, j?.next)
    }
    return resultNode
}

fun swapPairsRecursion(
    ns: ListNode?,
    i: ListNode?,
    j: ListNode?,
    ne: ListNode?
) {

    if (j == null) {
        return
    }

    swap(ns, i, j, ne)

    swapPairsRecursion(i, i?.next, i?.next?.next,i?.next?.next?.next )
}

fun swap(ns: ListNode?, i: ListNode?, j: ListNode?, ne: ListNode?) {

    if (ns == null && i != null && j != null && ne == null) {
        // start of linked list
        // only two elements in linkedlist

        j.next = i
        i.next = null

    } else if (ns == null && i != null && j != null && ne != null) {
        // start of linked list
        // more than three elements
        j.next = i
        i.next = ne

    } else if (ns != null && i != null && j != null && ne == null) {
        // end of linked list
        ns.next = j
        j.next = i
        i.next = null

    } else if (ns != null && i != null && j != null && ne != null) {
        // somewhere in the linked list
        // more than 4 elements

        ns.next = j
        j.next = i
        i.next = ne
    }

}


fun main() {


    var node = ListNode(1)
    node.next = ListNode(2)
    node.next?.next = ListNode(3)
    node.next?.next?.next = ListNode(4)

    val swapPairs = swapPairs(node)
    println(swapPairs)


}