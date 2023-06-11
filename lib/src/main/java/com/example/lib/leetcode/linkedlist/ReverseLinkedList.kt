package com.example.lib.leetcode.linkedlist

class ReverseLinkedList {

    //    https://leetcode.com/problems/reverse-linked-list/editorial/
    fun reverseList1(head: ListNode?): ListNode? {

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

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        } else {
            var curr = head
            var prev: ListNode? = null
            var next: ListNode? = null
            while (curr != null) {
                next = curr.next

                curr.next = prev
                prev = curr
                curr = next
            }
            return prev
        }
    }

}

fun main() {

}