package com.example.lib.topics.arrays

//https://leetcode.com/articles/set-matrix-zeroes/
class SetMatrixZeros {

    fun setZeroes1(matrix: Array<IntArray>): Unit {
        val r = matrix.size
        val c = matrix[0].size

        val rows = hashSetOf<Int>()
        val cols = hashSetOf<Int>()

        for (ri in 0 until r) {
            for (ci in 0 until c) {
                if (matrix[ri][ci] == 0) {
                    rows.add(ri)
                    cols.add(ci)
                }
            }
        }

        for (ri in 0 until r) {
            for (ci in 0 until c) {
                if (rows.contains(ri) || cols.contains(ci)) {
                    matrix[ri][ci] = 0
                }
            }
        }

    }


//    fun setZeroes3(matrix: Array<IntArray>) {
//        var isCol = false
//        val r = matrix.size
//        val c = matrix[0].size
//
//        for (ri in 0 until r) {
//
//            if (matrix[ri][0] == 0) {
//                isCol = true
//            }
//
//            for (ci in 0 until c) {
//                if (matrix[ri][ci] == 0) {
//                    matrix[0][ci] = 0
//                    matrix[ri][0] = 0
//                }
//            }
//        }
//
//        for (ri in 0 until r) {
//            for (ci in 0 until c) {
//                if (matrix[ri][0] == 0 || matrix[0][ci] == 0) {
//                    matrix[ri][ci] = 0
//                }
//            }
//        }
//
//    }

    fun setZeros2(matrix: Array<IntArray>) {

        val modified = -1000000
        val r = matrix.size
        val c = matrix[0].size


        for (ri in 0 until r) {
            for (ci in 0 until c) {
                if (matrix[ri][ci] == 0) {
                    for (ti in 0 until c) {
                        if (matrix[ri][ti] != 0) {
                            matrix[ri][ti] = modified
                        }
                    }

                    for (ti in 0 until r) {
                        if (matrix[ti][ci] != 0) {
                            matrix[ti][ci] = modified
                        }
                    }
                }
            }
        }

        for (ri in 0 until r) {
            for (ci in 0 until c) {
                if (matrix[ri][ci] == modified) {
                    matrix[ri][ci] = 0
                }
            }
        }


    }

}

fun rangeTest() {
    for (i in 0 until 10) {
        println(i)
    }
}

fun main() {
    val setMatrixZeros = SetMatrixZeros()
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
//    setMatrixZeros.setZeroes1(matrix)
    rangeTest()


}



