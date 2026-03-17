package com.example.lib.leetcode.`01arrays`

class GameofLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val c = board[0].size
        val r = board.size

        val bCopy = Array(r) { IntArray(c) }
        for (ri in 0 until r) {
            for (ci in 0 until c) {
                bCopy[ri][ci] = board[ri][ci]
            }
        }

        for (ri in 0 until r) {
            for (ci in 0 until c) {
                val nCount = getNCount(bCopy, ri, ci)
                if (board[ri][ci] == 1 && nCount < 2) {
                    // dies
                    board[ri][ci] = 0
                } else if (board[ri][ci] == 1 && (nCount == 2 || nCount == 3)) {
                    // lives
                } else if (board[ri][ci] == 1 && nCount > 3) {
                    // dies
                    board[ri][ci] = 0
                } else if (board[ri][ci] == 0 && nCount == 3) {
                    board[ri][ci] = 1
                }
            }
        }
    }

    fun getNCount(board: Array<IntArray>, r: Int, c: Int): Int {
        var n = 0
        val cols = board[0].size
        val rows = board.size

        // left
        if ((c - 1) >= 0 && board[r][c - 1] == 1) {
            n++
        }

        // right
        if ((c + 1) < cols && board[r][c + 1] == 1) {
            n++
        }

        // top
        if ((r - 1) >= 0 && board[r - 1][c] == 1) {
            n++
        }

        // bottom
        if ((r + 1) < rows && board[r + 1][c] == 1) {
            n++
        }

        // top left
        if ((c - 1) >= 0 && (r - 1) >= 0 && board[r - 1][c - 1] == 1) {
            n++
        }

        // bottom left
        if ((c - 1) >= 0 && (r + 1) < rows && board[r + 1][c - 1] == 1) {
            n++
        }

        // top right
        if ((r - 1) >= 0 && (c + 1) < cols && board[r - 1][c + 1] == 1) {
            n++
        }

        // bottom right
        if ((r + 1) < rows && (c + 1) < cols && board[r + 1][c + 1] == 1) {
            n++
        }
        return n
    }
}

fun main() {
    val o = GameofLife()
    val matrix = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
    )
    o.gameOfLife(matrix)
    println(matrix)

}