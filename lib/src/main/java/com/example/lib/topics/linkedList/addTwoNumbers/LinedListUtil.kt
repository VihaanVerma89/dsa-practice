package com.example.lib.topics.linkedList.addTwoNumbers

class LinedListUtil {
    companion object {
        fun printList(node: ListNode?) {
            var i = node
            while (i != null) {
                print("[${i.`val`}]")
                i = i.next
            }
        }
    }
}
