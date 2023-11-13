package com.example.lib.leetcode.graphs

// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/707/traversals-trees-graphs/4693/
class validPath {

    val visitedNodes = hashSetOf<Int>()
    fun dfs(hmap: HashMap<Int, ArrayList<Int>>, source: Int, destination: Int): Boolean {

        var result = false
        if (source == destination) {
            return true
        }

        val vertices = hmap.get(source)

        visitedNodes.add(source)
        if (vertices != null) {
            for (vertice in vertices) {
                if (!visitedNodes.contains(vertice)) {
                    result = dfs(hmap, vertice, destination)
                    if(result)
                        break;
                }
            }
        }
        return result
    }

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        var reachable = false

        if (source == destination) {
            return true
        }

        // prepare node -> list hashmap
        val hMap = hashMapOf<Int, ArrayList<Int>>()
        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]

            if (hMap.contains(start)) {
                hMap.get(start)?.add(end)
            } else {
                val arrayListOf = arrayListOf<Int>()
                arrayListOf.add(end)
                hMap.put(start, arrayListOf)
            }

            if (hMap.contains(end)) {
                hMap.get(end)?.add(start)
            } else {
                val arrayListOf = arrayListOf<Int>()
                arrayListOf.add(start)
                hMap.put(end, arrayListOf)
            }
        }
        // traverse the node
        val sourceConnections = hMap.get(source)
        if (sourceConnections == null) {

        } else if (sourceConnections.isNotEmpty()) {
            // dfs to reach destination
            reachable = dfs(hMap, source, destination)
        }
        return reachable
    }

}

fun main() {
    val n = 10

    val input = arrayOf(
        intArrayOf(0, 7),
        intArrayOf(0, 8),
        intArrayOf(6, 1),
        intArrayOf(2, 0),
        intArrayOf(0, 4),
        intArrayOf(5, 8),
        intArrayOf(4, 7),
        intArrayOf(1, 3),
        intArrayOf(3, 5),
        intArrayOf(6, 5),
    )
    val source = 7
    val destination = 5

    val reachable = validPath().validPath(n, input, source, destination)
    println("reachable : $reachable")
}