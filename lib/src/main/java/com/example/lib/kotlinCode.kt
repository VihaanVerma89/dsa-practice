package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class Solution {


    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray{

        val rGraph = mutableMapOf<Int, MutableList<Int>>()
        val bGraph = mutableMapOf<Int, MutableList<Int>>()

        for(i in redEdges){
            val s = i[0]
            val e = i[1]

            rGraph.getOrPut(s){ mutableListOf() }.add(e)
        }

        for( i in blueEdges){

            val s = i[0]
            val e = i[1]
            bGraph.getOrPut(s){ mutableListOf() }.add(e)
        }

        // bfs

        data class Node(val value:Int, val ec: Int, val d: Int )

        val q = LinkedList<Node>()

        q.add(Node(0,0,0))
        q.add(Node(0,1,0))

        val dist =  Array(2){ IntArray(2){ Int.MAX_VALUE } }
        dist[0][0] = 0
        dist[0][1] = 0

        while(q.isNotEmpty()){

            val currNode = q.poll()

            val graph = if(currNode.ec == 0) bGraph else rGraph
            
            val nodes = grpah.getOrDefault(currNode, emptyList())
            val nextColor = 1 - currNode.ec

            for(node in nodes){
                if(currNode.d+1 < dist[node][nextColor])
                {
                    q.add(Node(node, nextColor, currNode.d+1)
                }
            }

        }


    }
}


fun main() {
    val instance = Solution()
    val grid = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )
}

