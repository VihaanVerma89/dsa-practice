package com.example.lib.leetcode.`03linkedlist`

class deleteDuplicates {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        fun deleteDuplicates(head: ListNode?): ListNode? {

            var root = head

            var p = head
            var n = head

            var duplicateFound = false

            while (n != null) {

                n = n?.next

                if (p?.`val` == n?.`val`) {
                    // duplicate found
                    duplicateFound = true
                }

                if (duplicateFound && p?.`val` != n?.`val`) {
                    // n is at a non duplicate value
                    p?.next = n
                    duplicateFound = false
                    p = n
                }

            }



            return head
        }

    }
}