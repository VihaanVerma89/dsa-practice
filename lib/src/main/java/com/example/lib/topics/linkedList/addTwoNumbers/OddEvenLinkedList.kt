package com.example.lib.topics.linkedList.addTwoNumbers

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/


class Solution {

    fun oddEvenList(head: ListNode?): ListNode? {
        var result = head
        var i = head
        if (i != null) {
            var on: ListNode? = null
            var onh: ListNode? = null
            var en: ListNode? = null
            var enh: ListNode? = null


            var cn: Int
            while (i != null) {
                cn = i.`val`
                if (isEven(cn)) {
                    if (en != null) {
                        en.next = i
                        en = i
                    } else {
                        en = i
                        enh = i
                    }
                } else {
                    // odd
                    if (on != null) {
                        on.next = i
                        on = i
                    } else {
                        on = i
                        onh = i
                    }
                }
                i = i?.next
            }

            en?.next = null

            if (onh != null) {
                result = onh
                if (enh != null) {
                    on?.next = enh
                }
            } else if (enh != null) {
                // odd nodes are not there
                result = enh
            }
        }
        return result
    }

    private fun isEven(nodeVal: Int): Boolean {
        return nodeVal % 2 == 0
    }


}

fun main() {
//        [1,2,3,4,5]
    var node = ListNode(1)
    node.next = ListNode(2)
    node.next?.next = ListNode(3)
    node.next?.next?.next = ListNode(4)
    node.next?.next?.next?.next = ListNode(5)

    val oddEvenList = Solution().oddEvenList(node)

    LinedListUtil.printList(oddEvenList)

}