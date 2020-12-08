package com.example.lib.leetcode.learn.linkedlist

class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        var cycle = false
        head?.let {
            var i = head
            var j = head.next
            while (j != null && j != i) {
                i = i?.next
                j = j?.next?.next
            }

            if (j == i) {
                cycle = true
            } else if (j == null) {
                cycle = false
            }
        }
        return cycle
    }
}

fun main() {


}