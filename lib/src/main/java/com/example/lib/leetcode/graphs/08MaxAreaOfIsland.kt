package com.example.lib.leetcode.graphs

class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int{

        val rows = grid.size
        val cols = grid[0].size
        val visited = hashSetOf<String>()
        var maxArea = 0
        var area = 0


        fun dfs(r: Int, c: Int){


            val node = "$r,$c"
            if(visited.contains(node)){
                return
            }
            else {
                visited.add(node)
            }


            val value = grid[r][c]

            if(value == 0 )
            {
                return
            }


            area++

            if(c-1>=0 && grid[r][c-1]==1){
                dfs(r,c-1)
            }
            if( c+1<grid[0].size && grid[r][c+1]==1){
                dfs(r,c+1)
            }
            if(r-1>=0 && grid[r-1][c]==1){
                dfs(r-1,c)
            }
            if(r+1<grid.size && grid[r+1][c]==1){
                dfs(r+1,c)
            }



        }

        for(r in 0 until rows){
            for(c in 0 until cols){

                val value = grid[r][c]
                if(value ==1){

                    if(visited.contains("$r,$c"))
                    {

                    }else{
                        dfs(r,c)
                        maxArea = maxOf(maxArea,area)
                        area = 0
                    }
                }

            }

        }

        return maxArea

    }
}