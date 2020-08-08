package com.example.lib.topics.arrays

import java.util.*

class NumberofIslands {

    fun numIslands(grid: Array<CharArray>): Int {
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
}

fun main() {
    val o = NumberofIslands()
    val g = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
    )

    var numIslands = o.numIslands(g)
    println(numIslands)

}
