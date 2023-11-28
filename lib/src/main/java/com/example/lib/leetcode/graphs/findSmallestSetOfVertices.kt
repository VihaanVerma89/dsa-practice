package com.example.lib.leetcode.graphs

class findSmallestSetOfVertices {

    val visited = hashSetOf<Int>()
    fun dfs(n: Int, hmap: HashMap<Int, ArrayList<Int>>) {
        if (visited.contains(n)) {

        } else {
            visited.add(n)
            hmap[n]?.apply {
                for (node in hmap[n]!!) {
                    dfs(node, hmap)
                }
            }
        }
    }

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {

        // prepare the node -> connected node map

        val hmap = hashMapOf<Int, ArrayList<Int>>()
        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]

            if (hmap.contains(start)) {
                hmap[start]?.add(end)
            } else {
                hmap[start] = arrayListOf<Int>().apply { add(end) }
            }

        }

        // dfs
        val result = arrayListOf<Int>()
        for (i in 0 until n) {
            if (visited.contains(i)) {
            } else {
                if (hmap.contains(i)) {
                    dfs(i, hmap)
                    result.add(i)
                }
            }
        }

        return result
    }
}

fun main() {
//    val instance = findSmallestSetOfVertices()
//    val n =
//    instance.findSmallestSetOfVertices()
}