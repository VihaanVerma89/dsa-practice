package com.example.lib.leetcode.backtrack.wordsearch


// Runtime - 2943ms
// Memory - 66.32MB
class WordSearch {


    fun backtrack(
        board: Array<CharArray>,
        word: String,
        row: Int,
        col: Int,
        position: Int,
        nextChar: Char,
        prevDirection: Char
    ) {

        // base condition
        if (row < 0 || row > board.size - 1)
            return
        if (col < 0 || col > board[0].size - 1)
            return

        if (matchedIndexHashSet.contains("$row$col")) {
            // visited this index already in current word check
            return
        }

        val currentChar = board[row][col]
        println(" previous direction : $prevDirection currentChar : $currentChar,  i: $row, j: $col")

        if (currentChar == nextChar && position == word.length - 1 && nextChar == word.last()) {
            // matching word found
            result = true
            return
        }


        // traversal


        if (currentChar == nextChar) {
            matchedIndexHashSet.add("$row$col")
            // matching char found check for next char
            val nextPosition = position + 1

            val up = row - 1
            val down = row + 1
            val left = col - 1
            val right = col + 1

            if (nextPosition < word.length) {
                val nextChar = word.get(nextPosition)

                // go left if prev was not right
                if (prevDirection != 'r') {
                    backtrack(board, word, row, left, nextPosition, nextChar, 'l')
                }
                // go right
                if (prevDirection != 'l') {
                    backtrack(board, word, row, right, nextPosition, nextChar, 'r')
                }
                // go up
                if (prevDirection != 'd') {
                    backtrack(board, word, up, col, nextPosition, nextChar, 'u')
                }
                // go down
                if (prevDirection != 'u') {
                    backtrack(board, word, down, col, nextPosition, nextChar, 'd')
                }
            } else {
                // invalid word index
            }
            matchedIndexHashSet.remove("$row$col")

        } else {
            // return
        }
    }

    var result = false
    var matchedIndexHashSet = hashSetOf<String>()
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val startingChar = word.get(0)
        val boardSize = board.size * board[0].size
        if (word.length <= boardSize) {
            // valid search
            for (row in 0 until board.size) {
                for (col in 0 until board[0].size) {
                    val charValue = board[row][col]
                    if (charValue == startingChar) {
                        backtrack(board, word, row, col, 0, charValue, 'n')
                        if (result)
                            return true
                    } else {
                        // invalid starting char value
                    }
                    matchedIndexHashSet.clear()
                }
            }
        } else {
            // invalid search
        }
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
    val result = WordSearch().exist(board, word)
    println("Exists : $result")
}