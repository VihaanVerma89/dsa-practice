package com.example.lib.leetcode.graphs


class findCircleNum {


    fun dfs(isConnected: Array<IntArray>, row: Int) {

        val cols = isConnected[row].size

        visitedSet.add(row)
        for (col in 0 until cols) {
            if (visitedSet.contains(col).not() && isConnected[row][col] == 1) {
                dfs(isConnected, col)
            }
        }

    }

    val visitedSet = hashSetOf<Int>()
    var provinces = 0
    fun findCircleNum(isConnected: Array<IntArray>): Int {

        // at each node perform dfs
        val rows = isConnected.size

        for (row in 0 until rows) {

            if (visitedSet.contains(row)) {

            } else {
                provinces++
                dfs(isConnected, row)
            }
        }

        return provinces
    }

}

fun main() {
    val input = arrayOf(
        //         0,1,2,3,4,5,6,7,8,9,10
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,1,0,0,0,1,1,1,0,0),
        intArrayOf(0,1,0,1,0,0,0,0,0,0,0),

        intArrayOf(0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,1,0,0,0,0,0,1,0),
        intArrayOf(0,0,0,1,0,0,0,0,0,0,0),

        intArrayOf(0,1,0,0,0,0,0,0,0,1,0),
        intArrayOf(0,1,0,0,0,0,0,0,0,0,1),
        intArrayOf(0,1,0,0,0,0,0,0,0,0,0),

        intArrayOf(0,0,0,0,1,0,1,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,0,0,0),
    )

    findCircleNum().findCircleNum(input)
}