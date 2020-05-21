package com.example.lib.topics.linkedList.addTwoNumbers

import org.w3c.dom.NodeList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var resultNode: ListNode? = null
    var rootNode: ListNode? = null
    var lastNode: ListNode? = null
    var i = l1
    var j = l2
    var carry = 0

    if (i != null && j != null) {

        while (i != null || j != null) {
            resultNode = ListNode(0)

            val n1 = i?.`val` ?: 0
            val n2 = j?.`val` ?: 0

            var sum = n1 + n2 + carry
            carry = 0

            if (sum >= 10) {
                carry = sum / 10
                sum %= 10
            }

            resultNode.`val` = sum

            if (rootNode == null) {
                rootNode = resultNode
            } else {
                lastNode?.next = resultNode
            }
            lastNode = resultNode

            i = i?.next
            j = j?.next
        }

        if (carry > 0) {
            val carryNode = ListNode(carry)
            lastNode?.next = carryNode
        }
    } else if (i == null && j != null) {
        rootNode = j
    } else if (i != null && j == null) {
        rootNode = i
    }

    return rootNode
}


fun main() {
    var l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    var l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next?.next = ListNode(4)

    val rootNode = addTwoNumbers(l1, l2)
    while (rootNode?.`val` != null) {
        print(rootNode?.`val`)
        print(" ")
    }


}