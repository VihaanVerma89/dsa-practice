package com.example.lib.leetcode.backtrack.wordsearch

// Runtime
//496ms
//Beats 53.47%of users with Kotlin
//Memory
//37.41MB
//Beats 66.31%of users with Kotlin
class WordSearchLeetCodeSolution() {
    private lateinit var board: Array<CharArray>
    private var ROWS = 0
    private var COLS = 0
    fun exist(board: kotlin.Array<kotlin.CharArray>, word: kotlin.String): kotlin.Boolean {
        this.board = board
        this.ROWS = board.size
        this.COLS = board[0].size
        for (row in 0 until this.ROWS)
            for (col in 0 until this.COLS)
                if (this.backtrack(row, col, word, 0))
                    return true
        return false
    }

    protected fun backtrack(
        row: kotlin.Int,
        col: kotlin.Int,
        word: kotlin.String,
        index: kotlin.Int
    ): kotlin.Boolean {

        /* Step 1). check the bottom case. */
        if (index >= word.length) return true

        /* Step 2). Check the boundaries. */
        if ((row < 0) || (row == this.ROWS) || (col < 0) || (col == this.COLS
                    ) || (this.board[row].get(col) != word.get(index))
        ) return false

        /* Step 3). explore the neighbors in DFS */
        var ret = false
        // mark the path before the next exploration
        this.board.get(row)[col] = '#'
        val rowOffsets = kotlin.intArrayOf(0, 1, 0, -1)
        val colOffsets = kotlin.intArrayOf(1, 0, -1, 0)
        for (d in 0..3) {
            ret = this.backtrack(row + rowOffsets.get(d), col + colOffsets.get(d), word, index + 1)
            if (ret) break
        }

        /* Step 4). clean up and return the result. */
        this.board.get(row)[col] = word.get(index)
        return ret
    }
}

fun main() {
    val board =
    // input 1
//        arrayOf(
//            charArrayOf('A', 'B', 'C', 'E'),
//            charArrayOf('S', 'F', 'C', 'S'),
//            charArrayOf('A', 'D', 'E', 'E')
//        )

    // input 2
//        arrayOf(
//            charArrayOf('A', 'A', 'A', 'A'),
//            charArrayOf('A', 'A', 'A', 'A'),
//            charArrayOf('A', 'A', 'A', 'A')
//        )
//        arrayOf(
//            charArrayOf('A', 'B', 'C', 'E'),
//            charArrayOf('S', 'F', 'C', 'S'),
//            charArrayOf('A', 'D', 'E', 'E')
//        )


//        arrayOf(
//            charArrayOf('a', 'a', 'b', 'a', 'a', 'b'),
//            charArrayOf('a', 'a', 'b', 'b', 'b', 'a'),
//            charArrayOf('a', 'a', 'a', 'a', 'b', 'a'),
//            charArrayOf('b', 'a', 'b', 'b', 'a', 'b'),
//            charArrayOf('a', 'b', 'b', 'a', 'b', 'a'),
//            charArrayOf('b', 'a', 'a', 'a', 'a', 'b')
//        )
//        arrayOf(
//            charArrayOf('a', 'b'),
//            charArrayOf('c', 'd')
//        )


        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'E', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )


//    val word = "cdba"
    val word = "ABCESEEEFS"
    val result = WordSearchLeetCodeSolution().exist(board, word)
    println("Exists : $result")
}