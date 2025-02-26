package com.example.lib.leetcode.graphs

import java.util.*

class NumberofIslands {


    fun numIslands(grid: Array<CharArray>):Int{

        val rows = grid.size
        val cols = grid[0].size

        val hSet = hashSetOf<String>()
        var result = 0

        for(r in 0 until rows){

            for(c in 0 until cols){
                if(grid[r][c]=='1'){

                    if(hSet.contains("$r,$c"))
                    {
                        //already visited
                    }
                    else{

                        dfs(grid,hSet, r,c)
                        result++
                    }
                }
            }
        }
        return result

    }

    fun dfs(grid: Array<CharArray>, hSet: HashSet<String>,r: Int, c:Int){

        // term condition
        if(hSet.contains("$r,$c")){
            return
        }

        hSet.add("$r,$c")

        if(c-1 >= 0)
        {
            val l = grid[r][c-1]
            if(l=='1'){ dfs(grid, hSet, r, c-1) }
        }
        if(c+1 < grid[0].size){
            val rv = grid[r][c+1]
            if(rv=='1'){ dfs(grid, hSet, r, c+1) }
        }

        if(r-1>=0)
        {
            val u = grid[r-1][c]
            if(u=='1'){ dfs(grid, hSet, r-1, c) }
        }

        if(r+1 <grid.size)
        {
            val d = grid[r+1][c]
            if(d=='1'){ dfs(grid, hSet, r+1, c) }
        }

    }

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


    var numberOfIslands23: Int = 0
    var visitedNodes23 = hashSetOf<String>()
    fun dfs23(grid: Array<CharArray>, row: Int, col: Int) {


        if (visitedNodes23.contains("$row$col"))
            return
        else
            visitedNodes23.add("$row$col")


        val topIndex = row - 1
        val rightIndex = col + 1
        val leftIndex = col - 1
        val bottomIndex = row + 1

        // left
        if (leftIndex >= 0 && grid[row][leftIndex] == '1' && visitedNodes23.contains("$row$leftIndex")
                .not()
        ) {
            dfs23(grid, row, leftIndex)
        }
        // right
        if (rightIndex < grid[row].size && grid[row][rightIndex] == '1' && visitedNodes23.contains("$row$rightIndex")
                .not()
        ) {
            dfs23(grid, row, rightIndex)
        }
        // top
        if (topIndex >= 0 && grid[topIndex][col] == '1' && visitedNodes23.contains("$topIndex$col")
                .not()
        ) {
            dfs23(grid, topIndex, col)
        }
        // bottom
        if (bottomIndex < grid.size && grid[bottomIndex][col] == '1' && visitedNodes23.contains("$bottomIndex$col")
                .not()
        ) {
            dfs23(grid, bottomIndex, col)
        }
    }

    fun numIslands23(grid: Array<CharArray>): Int {


        // traverse the grid
        val rows = grid.size
        for (rowIv in grid.withIndex()) {
            for (colIv in rowIv.value.withIndex()) {
                val node = "${rowIv.index}${colIv.index}"
                if (colIv.value == '1' && visitedNodes23.contains(node).not()) {
                    // for each island perform dfs
                    numberOfIslands23++
                    dfs23(grid, rowIv.index, colIv.index)

                } else if (colIv.value == '0') {
                    // water
                } else if (colIv.value=='1' && visitedNodes23.contains(node)) {
                    println("already visited")
                }
                else{
                    println("should not happen")
                }
            }
        }



        return numberOfIslands23
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
