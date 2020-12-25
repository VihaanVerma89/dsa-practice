package com.example.lib.leetcode.learn.linkedlist

class ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode? {

        var curr: ListNode? = null
        var prev: ListNode? = null
        var next: ListNode? = null
        curr = head
        prev = null
        while (curr != null) {
            next = curr.next
            curr.next = prev

            prev = curr
            curr = next
        }
        return prev
    }

}

fun main() {

}