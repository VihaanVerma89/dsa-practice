package com.example.lib.geeksforgeeks.q

class LruCacheLeetCode(val capacity: Int) {

    val cache = hashMapOf<Int, DLinkNode>()
    var size: Int = 0
    var head: DLinkNode
    var tail: DLinkNode


    init {
        head = DLinkNode()
        tail = DLinkNode()
        head.next = tail
        tail.prev = head
    }


    class DLinkNode {
        var key: Int = 0
        var value: Int = 0
        lateinit var prev: DLinkNode
        lateinit var next: DLinkNode
    }


    fun get(key: Int): Int {
        val dLinkNode = cache[key] ?: return -1
        moveToHead(dLinkNode)
        return dLinkNode.value
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]
        if (node == null) {
            val dLinkNode = DLinkNode()
            with(dLinkNode)
            {
                this.key = key
                this.value = value
            }

            cache[key] = dLinkNode
            addNode(dLinkNode)
            size++
            if (size > capacity) {
                val popTail = popTail()
                cache.remove(popTail)
                size--
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }


    fun addNode(node: DLinkNode) {
        node.prev = head
        node.next = head.next

        head.next.prev = node
        head.next = node
    }

    fun removeNode(node: DLinkNode) {
        node.prev.next = node.next
        node.next.prev = node.prev
    }

    fun moveToHead(node: DLinkNode) {
        removeNode(node)
        addNode(node)
    }

    fun popTail(): DLinkNode {
        val prev = tail.prev
        removeNode(prev)
        return prev
    }


}