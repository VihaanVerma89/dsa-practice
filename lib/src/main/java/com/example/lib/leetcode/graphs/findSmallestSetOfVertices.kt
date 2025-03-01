package com.example.lib.leetcode.graphs

class findSmallestSetOfVertices {

    fun findSmallestSetOfVertices(n: Int, edges:List<List<Int>>): List<Int> {

        val hSet = hashSetOf<Int>()
        for(i in 0 until n){
            hSet.add(i)
        }

        for(edge in edges){
            var s = edge[0]
            var e = edge[1]

            if(hSet.contains(e)){
                hSet.remove(e)
            }
        }


        val result = mutableListOf<Int>()
        for(value in hSet){

            result.add(value)
        }
        return result

    }

    fun findSmallestSetOfVerticesAI(n: Int, edges: List<List<Int>>): List<Int> {
        val hSet = mutableSetOf<Int>().apply { addAll(0 until n) }

        for (edge in edges) {
            hSet.remove(edge[1])
        }

        return hSet.toList()
    }
}

fun main() {
//    val instance = findSmallestSetOfVertices()
//    val n =
//    instance.findSmallestSetOfVertices()
}