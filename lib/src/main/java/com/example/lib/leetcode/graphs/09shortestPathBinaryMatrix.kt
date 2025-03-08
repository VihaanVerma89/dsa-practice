package com.example.lib.leetcode.graphs

import java.util.LinkedList
import java.util.Queue

class shortestPathBinaryMatrix {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        // Check if the start or end is blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1

        // Directions for 8 possible movements
        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0),
            intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1)
        )

        val queue: Queue<Triple<Int, Int, Int>> = LinkedList() // (x, y, pathLength)
        queue.offer(Triple(0, 0, 1))
        grid[0][0] = 1 // Mark as visited

        while (queue.isNotEmpty()) {
            val (x, y, pathLength) = queue.poll()

            // If we reached the bottom-right cell, return the path length
            if (x == n - 1 && y == n - 1) return pathLength

            // Explore all 8 directions
            for (dir in directions) {
                val newX = x + dir[0]
                val newY = y + dir[1]
                if (newX in 0 until n && newY in 0 until n && grid[newX][newY] == 0) {
                    queue.offer(Triple(newX, newY, pathLength + 1))
                    grid[newX][newY] = 1 // Mark as visited
                }
            }
        }

        // No path found
        return -1
    }
}