package com.example.lib.leetcode.graphs

import java.util.LinkedList

class shortestAlternatingPaths {

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray{

        val rGraph = mutableMapOf<Int,MutableList<Int>>()
        val bGraph = mutableMapOf<Int,MutableList<Int>>()

        for(edge in redEdges){
            val s = edge[0]
            val e = edge[1]

            rGraph.getOrPut(s){ mutableListOf() }.add(e)
        }

        for(edge in blueEdges){
            val s = edge[0]
            val e = edge[1]

            bGraph.getOrPut(s){ mutableListOf() }.add(e)
        }

        val dist = Array(n){ IntArray(2) {Int.MAX_VALUE}}
        dist[0][0] = 0
        dist[0][1] = 0

        data class NodeInfo(val n: Int, val c:Int, val s:Int)

        val q = LinkedList<NodeInfo>()

        q.offer(NodeInfo(0,0,0))
        q.offer(NodeInfo(0,1,0))


        while(q.isNotEmpty()){

            val ni = q.poll()
            val graph = if(ni.c == 0 ) bGraph else rGraph
            val nextColor = 1 - ni.c

            for( node in graph.getOrDefault(ni.n, emptyList())){

                if(ni.s+1 < dist[node][nextColor]){
                    dist[node][nextColor] = ni.s+1
                    q.offer(NodeInfo(node,nextColor,ni.s+1))
                }
            }
        }

        val ans = IntArray(n){ i ->
            val minDist = minOf(dist[i][0], dist[i][1])
            if( minDist == Int.MAX_VALUE) -1 else minDist
        }

        return ans
    }
}

fun main( ) {


    test()
}

fun test(){
    val n = 6
    val redEdges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 3),
        intArrayOf(3, 5)
    )
    val blueEdges = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(2, 4),
        intArrayOf(4, 5),
        intArrayOf(1, 4)
    )


    val instance = shortestAlternatingPaths()
    instance.shortestAlternatingPaths(n,redEdges,blueEdges).forEach {
        println(it)
    }
}