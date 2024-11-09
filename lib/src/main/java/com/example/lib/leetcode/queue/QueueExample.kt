package com.example.lib.leetcode.queue

import java.util.*

fun main() {
    val q : Queue<Int> = LinkedList<Int>()
    for (i in 0..5) {
        q.add(i)
    }

    println("elements of q $q")

    val remove = q.remove()
    println("removed element $remove")
    println("elements of q $q")


    val peek = q.peek()
    println("peek element $peek")

    println("q size ${q.size}")
}
