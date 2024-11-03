package com.example.lib.leetcode.queue

import java.util.*

class WallsandGates {


    private val gate = 0
    private val wall = -1
    private val emptyRoom = Int.MAX_VALUE
    fun wallsAndGates(rooms: Array<IntArray>): Unit {

        // find the gate
        // O(rc) * O(rc)
        for (ri in rooms.withIndex()) {
            for (ci in ri.value.withIndex()) {
                if (ci.value == gate) {
                    // run bfs from each gate
                    // O(rc)
                    gateBfs(rooms, ri.index, ci.index)
                }
            }
        }

    }

    // for each gate fill values into nodes
    // rc/4 *
    fun gateBfs(rooms: Array<IntArray>, gr: Int, gc: Int): Unit {
        val rows = rooms.size
        val cols = rooms[0].size
        val cells = rows * cols

        val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        val visited = hashSetOf<Pair<Int, Int>>()

        val nodeAddress = Pair(gr, gc)
        q.add(nodeAddress)

        var b = 0


        // 1 node has 4 neighbors
        // q increase by 4 for every node
        // q will not be empty for rc/4 times
        // O(rc)
        while (q.isNotEmpty()) {
            val size = q.size

            // O(4)
            for (i in 0 until size) {

                val poll = q.poll()
                if (visited.contains(poll)) {
                    //already visited for this gate
                } else {
                    // visiting for first time
                    visited.add(poll)
                    val r = poll.first
                    val c = poll.second
                    val value = rooms[r][c]
                    if (value == emptyRoom) {
                        //empty room
                        // add gate value
                        rooms[r][c] = b
                    } else if (value == gate) {
                        // gate found
                        // ignore
                    } else if (value == wall) {
                        // wall found
                        // ignore
                    } else {
                        // room with another gates value found
                        // check and update value
//                        rooms[r][c] = value.coerceAtMost(b)
                        rooms[r][c] = Math.min(value, b)
                    }

                    // add adjacent nodes into q
                    // left node
                    if (c - 1 in 0 until cols) {
                        val nextNode = rooms[r][c - 1]
                        if (nextNode != wall && nextNode != gate) {
                            q.add(Pair(r, c - 1))
                        }
                    }

                    // right node
                    if (c + 1 in 0 until cols) {
                        val nextNode = rooms[r][c + 1]
                        if (nextNode != wall && nextNode != gate) {
                            q.add(Pair(r, c + 1))
                        }
                    }

                    // top node
                    if (r - 1 in 0 until rows) {
                        val nextNode = rooms[r - 1][c]
                        if (nextNode != wall && nextNode != gate) {
                            q.add(Pair(r - 1, c))
                        }
                    }

                    // bottom node
                    if (r + 1 in 0 until rows) {
                        val nextNode = rooms[r + 1][c]
                        if (nextNode != wall && nextNode != gate) {
                            q.add(Pair(r + 1, c))
                        }
                    }
                }
            }
            b++
        }
    }

}

fun main() {

    val input = arrayOf(
        intArrayOf(2147483647, -1, 0, 2147483647),
        intArrayOf(2147483647, 2147483647, 2147483647, -1),
        intArrayOf(2147483647, -1, 2147483647, -1),
        intArrayOf(0, -1, 2147483647, 2147483647)
    )

    val o = WallsandGates()
    o.wallsAndGates(input)
    val joinToString = input.joinToString { "," }
    println(joinToString)
}