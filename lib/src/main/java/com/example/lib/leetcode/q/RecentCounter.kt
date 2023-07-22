package com.example.lib.leetcode.q

import java.util.*

// https://leetcode.com/problems/number-of-recent-calls/
class RecentCounter {


    val q: Queue<Int> = LinkedList<Int>()

    fun ping(t: Int): Int {

        while (q.isNotEmpty() && q.peek() < t - 3000) {
            q.poll()
        }

        q.offer(t)
        return q.size
    }

}

fun main() {

}