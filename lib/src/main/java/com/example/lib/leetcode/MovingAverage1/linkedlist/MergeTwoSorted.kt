package com.example.lib.leetcode.MovingAverage1.linkedlist

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
class MergeTwoSorted {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var head: ListNode? = null
        var p: ListNode? = null

        var n: ListNode? = null
        var p1 = l1
        var p2 = l2

        while (p1 != null || p2 != null) {
            if (p1 == null && p2 != null) {
                n = p2
                p2 = p2.next
            } else if (p2 == null && p1 != null) {
                n = p1
                p1 = p1.next
            } else if (p1?.`val`!! < p2?.`val`!!) {
                n = p1
                p1 = p1.next
            } else if (p1.`val` == p2.`val`) {
                n = p1
                p1 = p1.next
            } else if (p1.`val` > p2.`val`) {
                n = p2
                p2 = p2.next
            }

            if (p == null) {
                n?.`val`?.let {
                    p = ListNode(it)
                    head = p
                }
            } else {
                n?.`val`?.let {
                    val listNode = ListNode(it)
                    p?.next = listNode
                    p = listNode
                }
            }
        }

        return head
    }


}

fun main() {
    val mergeTwoSorted = MergeTwoSorted()

    val l1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(4)
        }
    }

    val l2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }


    val head = mergeTwoSorted.mergeTwoLists(l1, l2)

    var n = head
    while (n != null) {
        print("${n.`val`} =>")
        n = n.next
    }
}