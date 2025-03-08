package com.example.lib.leetcode.graphs

import java.util.LinkedList
import java.util.Queue

class shortestPathBinaryMatrix {

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int{

        val n = grid.size
        var result =-1

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1

        val q = LinkedList<Triple<Int,Int,Int>>()

        q.add(Triple(0,0,1))

        val dirs = arrayOf(
            intArrayOf(0,-1), // l
            intArrayOf(0,1), // r
            intArrayOf(-1,0), // u
            intArrayOf(1,0), // d
            intArrayOf(-1,-1), // u l
            intArrayOf(-1,1), //  u r
            intArrayOf(1,-1), // d l
            intArrayOf(1,1), // d r
        )

        while(q.isNotEmpty()){
            val (r,c,s) = q.poll()

            if(r == n-1 && c ==n-1){
                result = s
                break
            }

            for(d in dirs){

                val nr = r+d[0]
                val nc = c+d[1]

                if(nr in 0 until n && nc in 0 until n && grid[nr][nc]==0){
                    q.add(Triple(nr,nc,s+1))
                    grid[nr][nc]=-1
                }
            }

        }

        return result

    }

    fun test(){

        val dirs = arrayOf(
            intArrayOf(1,1), // bottom right
            intArrayOf(0,1), // right
            intArrayOf(1,0), // down
            intArrayOf(-1,-1), // bottom left
            intArrayOf(-1,0),//left
            intArrayOf(-1,-1), // top left
            intArrayOf(0,-1), // top
            intArrayOf(-1,1), // top right
        )

        val dirs1 = arrayOf(
            intArrayOf(0,-1), // l
            intArrayOf(0,1), // r
            intArrayOf(-1,0), // up
            intArrayOf(1,0), // down
            intArrayOf(1,1), // b right
            intArrayOf(-1,-1), // b left
            intArrayOf(-1,1), // top r
            intArrayOf(-1,-1), // top left
        )



        var r = 0
        var c = 0
        for(d in dirs){

            var newR = r + d[0]
            var newC = c + d[1]

            println("new r,c : $newR,$newC")
        }
    }
}