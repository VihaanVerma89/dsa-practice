package com.example.lib.topics.arrays

//https://leetcode.com/problems/spiral-matrix/
class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val spiralOrder = arrayListOf<Int>()
        if (matrix.isNotEmpty()) {
            val matrixSize = matrix[0].size * matrix.size
            var direction = "r"
            val visitedHashSet = hashSetOf<String>()
            var r = 0
            var c = 0

            var node = "$r,$c"
            visitedHashSet.add(node)
            spiralOrder.add(matrix[r][c])

            while (visitedHashSet.size < matrixSize) {

                if (direction == "r") {
                    if (canMoveRight(matrix, visitedHashSet, r, c)) {
                        c += 1
                        visitedHashSet.add("$r,$c")
                        spiralOrder.add(matrix[r][c])
                    } else {
                        direction = "d"
                    }
                }

                if (direction == "d") {
                    if (canMoveDown(matrix, visitedHashSet, r, c)) {
                        r += 1
                        visitedHashSet.add("$r,$c")
                        spiralOrder.add(matrix[r][c])
                    } else {
                        direction = "l"
                    }
                }

                if (direction == "l") {
                    if (canMoveLeft(matrix, visitedHashSet, r, c)) {
                        c -= 1
                        visitedHashSet.add("$r,$c")
                        spiralOrder.add(matrix[r][c])
                    } else {
                        direction = "u"
                    }
                }

                if (direction == "u") {
                    if (canMoveUp(matrix, visitedHashSet, r, c)) {
                        r -= 1
                        visitedHashSet.add("$r,$c")
                        spiralOrder.add(matrix[r][c])
                    } else {
                        direction = "r"
                    }
                }
            }
        }
        return spiralOrder
    }

    private fun canMoveRight(matrix: Array<IntArray>, visitedHashSet: HashSet<String>, r: Int, c: Int): Boolean {
        var canMoveRight = false
        val nc = c + 1
        val nextNode = "$r,$nc"
        if (nc < matrix[r].size && !visitedHashSet.contains(nextNode)) {
            canMoveRight = true
        } else {
            // can't move right
            canMoveRight = false
        }
        return canMoveRight
    }

    private fun canMoveDown(matrix: Array<IntArray>, visitedHashSet: HashSet<String>, r: Int, c: Int): Boolean {
        var canMoveDown = false
        val nr = r + 1
        val nextNode = "$nr,$c"
        if (nr < matrix.size && !visitedHashSet.contains(nextNode)) {
            canMoveDown = true
        } else {
            canMoveDown = false
        }
        return canMoveDown
    }

    private fun canMoveLeft(matrix: Array<IntArray>, visitedHashSet: HashSet<String>, r: Int, c: Int): Boolean {
        var canMoveLeft = false
        val nc = c - 1
        val nextNode = "$r,$nc"
        if (nc >= 0 && !visitedHashSet.contains(nextNode)) {
            canMoveLeft = true
        } else {
            // can't move right
            canMoveLeft = false
        }
        return canMoveLeft
    }

    private fun canMoveUp(matrix: Array<IntArray>, visitedHashSet: HashSet<String>, r: Int, c: Int): Boolean {
        var canMoveUp = false
        val nr = r - 1
        val nextNode = "$nr,$c"
        if (nr >= 0 && !visitedHashSet.contains(nextNode)) {
            canMoveUp = true
        } else {
            canMoveUp = false
        }
        return canMoveUp
    }


}

fun main() {
    val spiralMatrix = SpiralMatrix()
    val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )
    val spiralOrder = spiralMatrix.spiralOrder(matrix)
    val joinToString = spiralOrder.joinToString(",")
    println(joinToString)
}