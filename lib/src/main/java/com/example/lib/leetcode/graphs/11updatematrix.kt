package com.example.lib.leetcode.graphs

import java.util.LinkedList

// https://leetcode.com/problems/01-matrix/description/
class updatematrix {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray>{

        val rows = mat.size
        val cols = mat[0].size

        val dist = Array(rows){ IntArray(cols){ Int.MAX_VALUE } }
        val q = LinkedList<Pair<Int,Int>>()


        for( r in 0 until  rows){
            for(c in 0 until cols){
                if( mat[r][c] == 0 ){
                    dist[r][c] = 0
                    q.offer(Pair(r,c))
                }
            }
        }

        val dirs = arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,-1),
            intArrayOf(1,0),
            intArrayOf(-1,0)
        )

        while(q.isNotEmpty()){
            val (r,c) = q.poll()

            for(d in dirs){
                val nr = r + d[0]
                val nc = c + d[1]

                if( nr in 0 until rows && nc in 0 until cols){
                    if(dist[nr][nc] > dist[r][c] +1 ){

                        dist[nr][nc]= dist[r][c] + 1
                        q.offer(Pair(nr,nc))
                    }
                }
            }
        }

        return dist

    }

}
