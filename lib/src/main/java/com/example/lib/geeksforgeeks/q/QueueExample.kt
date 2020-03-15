package com.example.lib.geeksforgeeks.q

import java.util.*

fun main() {
    val q = LinkedList<Int>()
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
