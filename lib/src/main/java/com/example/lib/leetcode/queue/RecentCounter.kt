package com.example.lib.leetcode.queue

import java.util.*

// https://leetcode.com/problems/number-of-recent-calls/

class RecentCounter {

    val q = LinkedList<Int>()
    fun ping(t: Int): Int {
        q.add(t)
        while (q.isNotEmpty() && q.peek() > t - 3000) {
            q.poll()
        }
        return q.size
    }
}

class RecentCounter2 {

    val q = LinkedList<Int>()
    fun ping(t: Int): Int {

        q.add(t)
        while (q.isNotEmpty() && q.peek() < t - 3000) {
            q.removeFirst()
        }

        // q only contains valid values
        return q.size
    }
}

class RecentCounter1 {

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