package com.example.lib.topics.arrays

//https://leetcode.com/problems/maximal-square/
class MaximalSquare {

    fun maximalSquare(matrix: Array<CharArray>): Int {

        var maxArea = 0

        if (matrix.isNotEmpty()) {
            for (riv in matrix.withIndex()) {
                for (civ in riv.value.withIndex()) {
                    val maxAreaFromPoint = getMaxAreaFromPoint(riv, civ, matrix)
                    if (maxAreaFromPoint > maxArea) {
                        maxArea = maxAreaFromPoint
                    }
                }
            }
        }

        return maxArea
    }


    private fun getMaxAreaFromPoint(riv: IndexedValue<CharArray>, civ: IndexedValue<Char>, matrix: Array<CharArray>): Int {
        var max = 0

        val c = matrix[0].size
        val r = matrix.size

        var ci = civ.index
        var ri = riv.index
        var maxSquareArea = -1
        if (matrix[riv.index][civ.index] == '1') {
            //square starting point
            var squareArea = 1
            while (ri < r && ci < c && matrix[riv.index][ci] == '1' && matrix[ri][civ.index] == '1') {
                squareArea = getSquareArea(riv, civ, ri, ci, matrix)
                if (squareArea != -1) {
                    maxSquareArea = squareArea
                } else if (squareArea == -1) {
                    break
                }
                ri++
                ci++
            }

        }
        return max.coerceAtLeast(maxSquareArea)
    }

    private fun getSquareArea(riv: IndexedValue<CharArray>, civ: IndexedValue<Char>, ri: Int, ci: Int, matrix: Array<CharArray>): Int {
        var a = -1
        var rec = civ.index
        var cer = riv.index
        while (rec <= ci && cer <= ri && matrix[ri][rec] == '1' && matrix[cer][ci] == '1') {
            rec++
            cer++
        }

        if (rec == ci + 1 && cer == ri + 1) {
            val e = (ri - riv.index) + 1
            a = e * e
        }
        return a
    }

    fun maximalSquare1(matrix: Array<CharArray>): Int {

        var maxArea = 0
        for (riv in matrix.withIndex()) {
            for (civ in riv.value.withIndex()) {

                val value = matrix[riv.index][civ.index]
                if (value == '1') {

                    var cr = riv.index
                    var cc = civ.index

                    while ((cc + 1) < riv.value.size && matrix[riv.index][cc++] == '1' && (cr + 1) < matrix.size && matrix[cr++][civ.index] == '1') {

                        var ci = civ.index
                        var ri = riv.index
                        var cArea = 0
                        while (ci <= cc && matrix[cr][ci] == '1' && ri <= cr && matrix[ri][cc] == '1') {

                            if (ci == cc && ri == cr) {
                                // square end reached
                                cArea = (cc - civ.index) * (cr - riv.index)
                                if (cArea > maxArea) {
                                    maxArea = cArea
                                }
                            }
                            ci++
                            ri++
                        }

                    }
                }
            }
        }
        return maxArea
    }
}

fun main() {
    val o = MaximalSquare()

//    val i = arrayOf(charArrayOf('1', '0', '1', '0', '0'), charArrayOf('1', '0', '1', '1', '1'), charArrayOf('1', '1', '1', '1', '1'), charArrayOf('1', '0', '0', '1', '0'))
//    val i = arrayOf(charArrayOf( '0', '1'))
    val i = arrayOf(
            charArrayOf('1', '0', '1', '1', '0', '1'),
            charArrayOf('1', '1', '1', '1', '1', '1'),
            charArrayOf('0', '1', '1', '0', '1', '1'),
            charArrayOf('1', '1', '1', '0', '1', '0'),
            charArrayOf('0', '1', '1', '1', '1', '1'),
            charArrayOf('1', '1', '0', '1', '1', '1')
    )

//    val i = arrayOf(
//            charArrayOf('1', '0', '1', '0', '0'),
//            charArrayOf('1', '0', '1', '1', '1'),
//            charArrayOf('1', '1', '1', '1', '1'),
//            charArrayOf('1', '0', '0', '1', '0'))

    o.maximalSquare(i)
}