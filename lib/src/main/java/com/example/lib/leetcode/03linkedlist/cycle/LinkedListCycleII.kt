package com.example.lib.leetcode.`03linkedlist`.cycle

import com.example.lib.leetcode.`03linkedlist`.ListNode

class LinkedListCycleII {

    fun detectCycle(head: ListNode?): ListNode? {
        var node: ListNode? = null
        head?.let {
            var i = head
            var j = head.next
            while (j != null && j != i) {
                i = i?.next
                j = j?.next?.next
            }
            node = j
        }
        return node
    }
}

fun main() {


}