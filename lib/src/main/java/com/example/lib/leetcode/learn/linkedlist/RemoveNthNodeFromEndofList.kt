package com.example.lib.leetcode.learn.linkedlist

//https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
class RemoveNthNodeFromEndofList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var result = head
        head?.let {
            var p1 = head
            var p2 = head
            var leftNode = head

            var size = 1
            for (i in 1..n) {
                p2 = p2?.next
                size++
            }

            while (p2 != null) {
                p2 = p2?.next
                leftNode = p1
                p1 = p1?.next
                size++
            }

            if (n <= size) {
                // p2 is at null
                if (p1 == head) {
                    // delete from head
                    val rightNode = head.next
                    head.next = null
                    result = rightNode
                } else if (p1?.next == null) {
                    // p1 is at last node
                    p1?.next = null
                    leftNode?.next = null
                } else {
                    // delete from middle
                    val rightNode = p1.next
                    p1.next = null
                    leftNode?.next = rightNode
                }
            }
        }
        return result
    }


}