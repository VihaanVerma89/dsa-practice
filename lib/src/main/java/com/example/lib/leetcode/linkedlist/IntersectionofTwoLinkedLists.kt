package com.example.lib.leetcode.linkedlist

class IntersectionofTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var result: ListNode? = null
        if (headA != null && headB != null) {
            var node: ListNode? = null

            node = headA
            var count1 = 0
            var lastNode1: ListNode? = headA
            while (node != null) {
                lastNode1 = node
                node = node.next
                count1++
            }

            node = headB
            var lastNode2: ListNode? = headB
            var count2 = 0
            while (node != null) {
                lastNode2 = node
                node = node.next
                count2++
            }

            if (lastNode1 == lastNode2) {
                // lists intersect
                var biggerList: ListNode? = null
                var smallerList: ListNode? = null
                if (count1 >= count2) {
                    biggerList = headA
                    smallerList = headB
                } else if (count2 > count1) {
                    biggerList = headB
                    smallerList = headA
                }

                val d = Math.abs(count1 - count2)

                for (i in 0 until d) {
                    biggerList = biggerList?.next!!
                }

                while (biggerList != null) {

                    if (biggerList == smallerList) {
                        result = biggerList
                        break
                    }

                    biggerList = biggerList.next
                    smallerList = smallerList?.next
                }
            }
        }

        return result
    }
}
