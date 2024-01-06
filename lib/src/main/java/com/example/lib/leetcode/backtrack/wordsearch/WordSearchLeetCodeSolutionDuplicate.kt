package com.example.lib.leetcode.backtrack.wordsearch

import com.sun.tools.javac.jvm.ByteCodes.ret
import javax.lang.model.util.Elements.Origin

// Runtime
//496ms
//Beats 53.47%of users with Kotlin
//Memory
//37.41MB
//Beats 66.31%of users with Kotlin
class WordSearchLeetCodeSolutionDuplicate() {
    private lateinit var board: Array<CharArray>
    private var rows = 0
    private var cols = 0
    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        this.rows = board.size
        this.cols = board[0].size

        for (row in 0 until this.rows) {
            for (col in 0 until this.cols) {


                val result = backtrack(row, col, word, 0)
                if (result) {
                    // match found
                    return true
                }
            }
        }

        return false
    }

    protected fun backtrack(
        row: Int,
        col: Int,
        word: String,
        index: Int
    ): Boolean {

        // base condition
        if (index >= word.length) {
            // we have found all matching chars till now and reached the end
            return true
        }
        //  **  boundry condition
        if (row < 0 || row == board.size) {
            // invalid row
            return false
        }

        if (col < 0 || col > board[0].size) {
            // invalid column
            return false
        }

        if (board[row][col] != word.get(index)) {
            // not a match
            return false
        }


        // traversal
        // mark node visited
        val orignalChar = board[row][col]
        board[row][col] = '#'

        var result = backtrack(row - 1, col, word, index)
        if (result) return true
        result = backtrack(row + 1, col, word, index)
        if (result) return true
        result = backtrack(row, col - 1, word, index)
        if (result) return true
        result = backtrack(row, col + 1, word, index)
        if (result) return true

        // current cell is not in solution
        board[row][col] = orignalChar
        return result
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