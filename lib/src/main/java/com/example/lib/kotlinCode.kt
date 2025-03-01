package com.example.lib

import java.util.LinkedList

class Solution {

    /*
    time- o(n+m+r)
    o(m) + o(r) + o(n) = o(m+n+r)
    space - o (n + m + r)
     */
    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {

        val graph = mutableMapOf<Int, MutableList<Int>>()

        // o(m)
        for(edge in edges){
            val s = edge[0]
            val e = edge[1]

            graph.getOrPut(s){ mutableListOf() }.add(e)
            graph.getOrPut(e){ mutableListOf() }.add(s)

        }

        val visited = hashSetOf<Int>()
        val rSet = hashSetOf<Int>()
        // o(r)
        for(r in restricted){
            rSet.add(r)
        }

        // o(n)
        fun dfs(node: Int) {

            if(visited.contains(node)){
                return
            }
            else if(rSet.contains(node)){
                return
            }

            visited.add(node)

            for(childNode in graph.get(node).orEmpty()){
                dfs(childNode)
            }
        }

        dfs(0)
        return visited.size
    }

}

fun main() {
}

