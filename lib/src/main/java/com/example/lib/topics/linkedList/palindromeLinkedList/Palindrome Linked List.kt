package com.example.lib.topics.linkedList.palindromeLinkedList

import com.example.lib.leetcode.linkedlist.ListNode
import java.util.*

class PalindromeLinkedList {

    /*
        Time = o(n) + o(n)
        2o(n)
        o(n)

        Space
        - o(n)
     */

    fun isPalindromeWithStack(head: ListNode?): Boolean {
        var result = true

        // o(n)
        val s = Stack<ListNode>()

        // o(n)
        var node = head
        while (node != null) {
            s.push(node)
            node = node.next
        }

        node = head
        // o(n)
        while (s.isNotEmpty()) {
            val pop = s.pop()
            if (pop.`val` != node?.`val`) {
                result = false
                return result
            }
            node = node.next
        }


        return result
    }

    fun isPalindromeInPlace(head: ListNode?): Boolean {
        var r = false

        return r
    }
}