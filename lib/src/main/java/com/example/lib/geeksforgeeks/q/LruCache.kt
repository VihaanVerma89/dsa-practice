package com.example.lib.geeksforgeeks.q

import java.util.*

class LruCache(val n: Int) {
    val dq = LinkedList<Int>()
    val map = hashSetOf<Int>()
    val csize = n

    fun refer(x: Int): Unit {
        if (!map.contains(x)) {
            if (dq.size == csize) {
                val removeLast = dq.removeLast()
                map.remove(removeLast)
            }
        } else {

            var index = 0
            var i = 0
            val iterator = dq.iterator()
            while (iterator.hasNext()) {
                if (iterator.next() == x) {
                    index = i
                    break
                }
                i++
            }
            dq.remove(index)
        }
        dq.push(x)
        map.add(x)
    }

    fun display(): Unit {
        val iterator = dq.iterator()
        while (iterator.hasNext()) {
            print(iterator.next())
            print(" ")
        }
    }
}

fun main() {
    val cache = LruCache(4)
    cache.refer(1)
    cache.refer(2)
    cache.refer(3)
    cache.refer(4)
    cache.refer(5)
    cache.display()
}