package com.example.lib.leetcode.queue

class QueueDemo {

    fun queueDemoUsingArrayDequeue( )
    {

        val q = ArrayDeque<Int>()

        q.addLast(10)
        q.addLast(20)
        q.addLast(30)
        q.

        println(q.toString())


        val first = q.removeFirst()
        println("first element removed: $first")
        println("queue after removing first element: ${q.toString()}")

        val firstOrNull = q.firstOrNull()

        println("firstOrNull : $firstOrNull")

    }
}