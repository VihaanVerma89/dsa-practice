package com.example.lib

class Solution {


    fun findCircleNum(isConnected: Array<IntArray>): Int {

        val r = isConnected.size
        val c = isConnected[0].size

        val graphMap = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until r) {

            for (j in 0 until c) {
                val value = isConnected[i][j]
                if (value == 1) {
                    graphMap.computeIfAbsent(i) { mutableListOf<Int>() }.add(j)
                    graphMap.computeIfAbsent(j) { mutableListOf<Int>() }.add(i)
                }
            }
        }

        // graphMap is ready

        val visited = hashSetOf<Int>()
        var p = 0

        for ((k, v) in graphMap) {

            if (visited.contains(k)) {

            } else {
                dfs(graphMap, visited, k)
                p++
            }
        }

        return p

    }

    fun dfs(graphMap: MutableMap<Int, MutableList<Int>>, visited: HashSet<Int>, node: Int) {

        if (visited.contains(node)) {

        } else {
            visited.add(node)
            val connectedNodes = graphMap.get(node)
            if (connectedNodes != null) {
                for (node in connectedNodes) {
                    dfs(graphMap, visited, node)
                }
            }
        }

    }

}

fun main() {
}

