package com.example.lib

class Solution {


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


}

fun main() {
}

