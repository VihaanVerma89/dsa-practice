package com.example.lib.leetcode.graphs

import sun.jvm.hotspot.code.ConstantLongValue
import java.util.*

class NumberofIslands {


    fun numIslands2020(grid: Array<CharArray>): Int {
        var islands = 0

        if (grid.isNotEmpty()) {

            val r = grid.size
            val c = grid[0].size

            val vset = hashSetOf<String>()
            val q: Queue<String> = LinkedList()

            for (ri in 0 until r) {
                for (ci in 0 until c) {

                    val cell = "$ri,$ci"
                    if (vset.contains(cell)) {
                        // already visited

                    } else {
                        val value = grid[ri][ci]

                        // new island cell found
                        if (value == '1') {
                            islands++

                            q.add(cell)
                            // visit entire island and mark cell visited
                            while (q.isNotEmpty()) {
                                val commaCell = q.remove()

                                if (vset.contains(commaCell)) {
                                    // this cell has already been visited

                                } else {
                                    // cell visited for the first time
                                    vset.add(commaCell)

                                    val splits = commaCell.split(",")

                                    //cell row index
                                    val cri = splits[0].toInt()
                                    //cell col index
                                    val cci = splits[1].toInt()

                                    // visit all neighbor cells

                                    //top cell
                                    if (cri - 1 >= 0 && grid[cri - 1][cci] == '1') {
                                        q.add("${cri - 1},$cci")
                                    }

                                    //bottom cell
                                    if (cri + 1 < r && grid[cri + 1][cci] == '1') {
                                        q.add("${cri + 1},$cci")
                                    }

                                    //left cell
                                    if (cci - 1 >= 0 && grid[cri][cci - 1] == '1') {
                                        q.add("$cri,${cci - 1}")
                                    }

                                    //right cell
                                    if (cci + 1 < c && grid[cri][cci + 1] == '1') {
                                        q.add("$cri,${cci + 1}")
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return islands
    }


    var numberOfIslands: Int = 0
    var visitedNodes = hashSetOf<String>()
    fun dfs(grid: Array<CharArray>, row: Int, col: Int) {


        if (visitedNodes.contains("$row$col"))
            return
        else
            visitedNodes.add("$row$col")


        val topIndex = row - 1
        val rightIndex = col + 1
        val leftIndex = col - 1
        val bottomIndex = row + 1

        // left
        if (leftIndex >= 0 && grid[row][leftIndex] == '1' && visitedNodes.contains("$row$leftIndex")
                .not()
        ) {
            dfs(grid, row, leftIndex)
        }
        // right
        if (rightIndex < grid[row].size && grid[row][rightIndex] == '1' && visitedNodes.contains("$row$rightIndex")
                .not()
        ) {
            dfs(grid, row, rightIndex)
        }
        // top
        if (topIndex >= 0 && grid[topIndex][col] == '1' && visitedNodes.contains("$topIndex$col")
                .not()
        ) {
            dfs(grid, topIndex, col)
        }
        // bottom
        if (bottomIndex < grid.size && grid[bottomIndex][col] == '1' && visitedNodes.contains("$bottomIndex$col")
                .not()
        ) {
            dfs(grid, bottomIndex, col)
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {


        // traverse the grid
        val rows = grid.size
        for (rowIv in grid.withIndex()) {
            for (colIv in rowIv.value.withIndex()) {
                val node = "${rowIv.index}${colIv.index}"
                if (colIv.value == '1' && visitedNodes.contains(node).not()) {
                    // for each island perform dfs
                    numberOfIslands++
                    dfs(grid, rowIv.index, colIv.index)

                } else if (colIv.value == '0') {
                    // water
                } else if (colIv.value=='1' && visitedNodes.contains(node)) {
                    println("already visited")
                }
                else{
                    println("should not happen")
                }
            }
        }



        return numberOfIslands
    }

}

fun main() {
    val o = NumberofIslands()
    val g = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )

    var numIslands = o.numIslands2020(g)
    println(numIslands)

}
