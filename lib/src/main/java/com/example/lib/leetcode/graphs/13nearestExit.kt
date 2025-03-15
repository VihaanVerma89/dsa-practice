package com.example.lib.leetcode.graphs

import java.util.LinkedList

class `13nearestExit` {


    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {

        val rows = maze.size
        val cols = maze[0].size

        data class Node(val r: Int, val c: Int, val s: Int)

        val q = LinkedList<Node>()
        val e = entrance
        q.add(Node(e[0], e[1], 0))

        val visited = hashSetOf<String>()
        visited.add("${e[0]},${e[1]}")

        val dirs = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
        )

        var result = -1

        while (q.isNotEmpty()) {

            val n = q.poll()

            val entryNode = if(n.r == e[0] && n.c == e[1]) true else false
            if (!entryNode && (n.c == 0 || n.c == cols - 1 || n.r == 0 || n.r == rows - 1)) {
                result = n.s
                break
            }



            for (d in dirs) {

                val nr = n.r + d[0]
                val nc = n.c + d[1]

                if (nr in 0 until rows && nc in 0 until cols && visited.contains("$nr,$nc")
                        .not() && maze[nr][nc] == '.'
                ) {
                    val node = Node(nr, nc, n.s + 1)
                    q.add(node)
                    visited.add("$nr,$nc")
                }

            }

        }

        return result
    }

}