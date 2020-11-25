package com.example.lib.topics.arrays

class SpiralMatrixWrong {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = arrayListOf<Int>()

        val r = "r"
        val d = "d"
        val l = "l"
        val u = "u"
        var items = matrix.size * matrix[0].size
        val visitedSet = hashSetOf<String>()
        var ri = 0
        var ci = 0
        var pair = Pair(ri, ci)
        var direction = r
        while (visitedSet.size != items - 1) {
//            for (direction in arrayOf(r, d, l, u)) {

            if (visitedSet.contains("$ri,$ci")) {
                //already visited
            } else {
                list.add(matrix[ri][ci])
            }

            if (direction == r) {
                pair = moveRight(matrix, visitedSet, ri, ci)
            } else if (direction == d) {
                pair = moveDown(matrix, visitedSet, ri, ci)
            } else if (direction == l) {
                pair = moveLeft(matrix, visitedSet, ri, ci)
            } else if (direction == u) {
                pair = moveUp(matrix, visitedSet, ri, ci)
            }

            ri = pair.first
            ci = pair.second

            if (direction == r) {
                if (ci == matrix[0].size - 1) {
                    direction = d
                } else if (visitedSet.contains("$ri,$ci")) {
                    direction = d
                }
            } else if (direction == d) {

            } else if (direction == l) {
            } else if (direction == u) {

            }
        }
        return list
    }

    fun moveRight(matrix: Array<IntArray>, visitedSet: HashSet<String>, ri: Int, ci: Int): Pair<Int, Int> {
        var pair = Pair(ri, ci)
        var nci = ci + 1
        if (nci < matrix[0].size) {
            if (visitedSet.contains("$ri,$nci")) {
                // already visited
            } else {
                visitedSet.add("$ri,$nci")
                pair = Pair(ri, nci)
            }
        }
        return pair
    }

    fun moveDown(matrix: Array<IntArray>, visitedSet: HashSet<String>, ri: Int, ci: Int): Pair<Int, Int> {
        var pair = Pair(ri, ci)
        var nri = ri + 1
        if (nri < matrix.size) {
            if (visitedSet.contains("$nri,$ci")) {
                // already visited
            } else {
                visitedSet.add("$nri,$ci")
                pair = Pair(nri, ci)
            }
        }
        return pair
    }

    fun moveLeft(matrix: Array<IntArray>, visitedSet: HashSet<String>, ri: Int, ci: Int): Pair<Int, Int> {
        var pair = Pair(ri, ci)
        var nci = ci - 1
        if (nci >= 0) {
            if (visitedSet.contains("$ri,$nci")) {
                // already visited
            } else {
                visitedSet.add("$ri,$nci")
                pair = Pair(ri, nci)
            }
        }
        return pair
    }

    fun moveUp(matrix: Array<IntArray>, visitedSet: HashSet<String>, ri: Int, ci: Int): Pair<Int, Int> {
        var pair = Pair(ri, ci)
        var nri = ri - 1
        if (nri < matrix.size) {
            if (visitedSet.contains("$nri,$ci")) {
                // already visited
            } else {
                visitedSet.add("$nri,$ci")
                pair = Pair(nri, ci)
            }
        }
        return pair
    }
}

fun main() {

//    val spiralMatrix = SpiralMatrix()
//    spiralMatrix.spiralOrder()
}