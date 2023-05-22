package com.example.lib.leetcode.linkedlist


class RemoveLinkedListElements {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {

        var prev: ListNode? = null
        var curr = head
        var rHead = head
        while (curr != null) {
            if (curr.`val` == `val`) {
                if (prev == null) {
                    // delete from root
                    curr = curr.next
                    rHead = curr
                } else {
                    val next = curr.next
                    prev?.next = next
                    curr.next = null
                    curr = next
                }
            } else {
                prev = curr
                curr = curr.next
            }
        }

        return rHead
    }

}

fun main() {


}