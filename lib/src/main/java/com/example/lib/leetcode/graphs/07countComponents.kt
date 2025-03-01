package com.example.lib.leetcode.graphs

class CountComponents {

    fun countComponents(n: Int, edges: Array<IntArray>): Int{


        val graph = mutableMapOf<Int, MutableList<Int>>()

        for(edge in edges){

            val s = edge[0]
            val e = edge[1]

            graph.getOrPut(s){ mutableListOf() }.add(e)
            graph.getOrPut(e){ mutableListOf() }.add(s)
        }

        var c = 0
        val visited = hashSetOf<Int>()

        fun dfs(node: Int){

            if(visited.contains(node)){
                return
            } else{
                visited.add(node)
            }

            for(nextNode in graph.get(node).orEmpty()){
                dfs(nextNode)
            }


        }

        for(key in 0 until n){
            if(visited.contains(key)){

            }
            else{
                c++
                dfs(key)
            }
        }

        return c
    }
}