package com.example.lib.leetcode.learn.linkedlist.cycle

import com.example.lib.leetcode.learn.linkedlist.ListNode

class LinkedListCycle {

    fun hasCycle2020(head: ListNode?): Boolean {
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

    fun hasCycle(head: ListNode?): Boolean {
        var cycle = false
        var i: ListNode? = null
        var j: ListNode? = null

        i = head
        j = head
        while (j != null && i != j) {
            i = i?.next
            j = j?.next?.next
            println("$i.`val`")
        }

        // j == null or j == i
        if (j == null) {
            cycle = false
        } else if (j == i) {
            cycle = true
        }
        return cycle
    }
}

fun main() {


}