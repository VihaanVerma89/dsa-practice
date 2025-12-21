package com.example.lib.topics.linkedList.palindromeLinkedList

import com.example.lib.leetcode.`03linkedlist`.ListNode
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
        var result = false

        if (head == null) {
            // no elements
        } else if (head?.next == null) {
            // only one element
            result=true
        } else {
            // more than 2 elements
            var fastNode = head

            var prev: ListNode? = null
            var curr: ListNode? = head
            var next: ListNode? = null

            while (fastNode != null && fastNode?.next != null) {
                fastNode = fastNode?.next?.next
                next = curr?.next
                curr?.next = prev
                prev = curr
                curr = next
            }

            // here when either fn is null or fn->next is null
            var l: ListNode? = null
            var r: ListNode? = null
            if (fastNode == null) {
                // even
                l = prev
                r = curr
            } else if (fastNode.next == null) {
                // odd
                l = prev
                r = curr?.next
            }

            // assume its palindrome till its not
            if (l != null && r != null) {
                result = true
            }

            while (l != null && r != null) {
                if (l.`val` == r.`val`) {
                    l = l.next
                    r = r.next
                } else {
                    result = false
                    break
                }
            }

        }
        return result
    }
}

fun main() {
    val instance = PalindromeLinkedList()
    val list = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2).apply {
                next = ListNode(1).apply {
                    next = null
                }
            }
        }
    }
    val result = instance.isPalindromeInPlace(list)
    println("palindrome list : $result")
}