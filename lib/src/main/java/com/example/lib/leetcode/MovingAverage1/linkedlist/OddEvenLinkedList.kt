package com.example.lib.leetcode.MovingAverage1.linkedlist

//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
class OddEvenLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {
        var e = head
        var pe: ListNode? = null
        var o = head?.next
        val fo = o
        var po: ListNode? = null

        while (e != null || o != null) {
            if (e != null) {
                pe = e
            }
            if (o != null) {
                po = o
            }
            e = e?.next?.next
            o = o?.next?.next
            pe?.next = e
            po?.next = o
        }

        // both e, o are null
        pe?.next = fo
        return head
    }
}

fun main() {

}