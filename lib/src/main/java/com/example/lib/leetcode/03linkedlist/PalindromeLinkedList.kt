package com.example.lib.leetcode.`03linkedlist`

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        var result = true
        head?.let {
            var s = head
            var f = head
            var prev: ListNode? = null
            var len = 1
            while (f != null) {


                if (f.next?.next != null) {
                    len += 2
                } else if (f.next != null) {
                    len += 1
                }
                f = f.next?.next


                val next = s?.next
                s?.next = prev

                // move pointer
                prev = s
                s = next
            }

            if (len % 2 == 0) {
                // even len

            } else {
                // odd len
                prev = prev?.next
            }
            while (s != null && prev != null) {
                if (s.`val` == prev.`val`) {
                    s = s.next
                    prev = prev.next
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
    val o = PalindromeLinkedList()
    val listNode1 = ListNode(1)
    val listNode2 = ListNode(2)
    listNode1.next = listNode2
    val palindrome = o.isPalindrome(listNode1)
    println(palindrome)
}

