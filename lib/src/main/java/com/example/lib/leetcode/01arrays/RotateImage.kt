package com.example.lib.leetcode.`01arrays`

class RotateImage {


    /*

    https://leetcode.com/explore/interview/card/google/59/array-and-strings/3052/

    1 2 3         7 4 1
    4 5 6         8 5 2
    7 8 9         9 6 3

    */

    fun rotate19Mar26(matrix: Array<IntArray>): Unit {

        // transpose
        val rows = matrix.size
        val cols = matrix[0].size
        var r = 0
        var c = 0

        for (i in 0 until rows) {


            r = i
            c = i
            while (r < rows && c < cols) {

                matrix[r][i] = matrix[i][c].also { matrix[i][c] = matrix[r][i] }

                r++
                c++
            }

        }


        // reverse
        for (row in matrix) {
            var l = 0
            var r = row.lastIndex
            while (l < r) {
                row[l] = row[r].also { row[r] = row[l] }
                l++
                r--
            }
        }

    }

}