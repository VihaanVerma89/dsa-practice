package com.example.lib.leetcode.graphs



//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
class minReorder {

    val visitedHashSet = hashSetOf<Int>()


    fun minReorder(n: Int, connections: Array<IntArray>): Int {

        //graph

        val graph = mutableMapOf<Int, MutableList<Pair<Int, Boolean>>>()

        for (c in connections) {

            val s = c[0]
            val e = c[1]

            graph.getOrPut(s) { mutableListOf() }.add(Pair(e, true))
            graph.getOrPut(e) { mutableListOf() }.add(Pair(s, false))

        }


        val visited = mutableSetOf<Int>()

        var changes = 0
        fun dfs(city: Int) {

            visited.add(city)

            val connections = graph.getOrDefault(city, emptyList())

            for (c in connections) {

                val nextCity = c.first
                val isTrue = c.second

                if (visited.contains(nextCity).not()) {
                    if (isTrue) {
                        changes++
                    }
                    dfs(nextCity)
                }
            emptyArray<>()
        }

        dfs(0)
        return changes
    }




    fun dfs2(
        node: Int?, parent: Int, hmap: HashMap<Int, ArrayList<List<Any>>>
    ) {

        if (node == null) {
            return
        } else {

            val listOfList = hmap[node]
            if (listOfList != null) {

                for (list in listOfList) {
                    val child = list.get(0) as Int
                    val direction = list?.get(1) as Int

                    if (child != parent) {
                        count+=direction
                        dfs2(child, node, hmap)
                    } else {
                        // pointing to parent
                    }
                }
            }
        }
    }

    var count = 0
    fun minReorder2(n: Int, connections: Array<IntArray>): Int {

        val hmap = hashMapOf<Int, ArrayList<List<Any>>>()

        for (connection in connections) {

            val start = connection[0]
            val end = connection[1]

            val startValue = listOf(end, 1)
            if (hmap.contains(start)) {
                hmap[start]?.add(startValue)
            } else {
                hmap[start] = arrayListOf(startValue)
            }

            val endValue = listOf(start, 0)
            if (hmap.contains(end)) {
                hmap[end]?.add(endValue)
            } else {
                hmap[end] = arrayListOf(endValue)
            }
        }

        dfs2(0, -1, hmap)

        return count
    }

//    fun dfs1(node: Int, parent: Int, adj: Map<Int?, MutableList<List<Int>>>) {
//        if (!adj.containsKey(node)) {
//            return
//        }
//        for (nei in adj[node]!!) {
//            val child = nei[0]
//            val sign = nei[1]
//            if (child != parent) {
//                count += sign
//                dfs1(child, node, adj)
//            }
//        }
//    }

//    fun minReorder1(n: Int, connections: Array<IntArray>): Int {
//        val adj: MutableMap<Int?, MutableList<List<Int>>> = HashMap()
//        for (connection in connections) {
//            adj.computeIfAbsent(
//                connection[0]
//            ) { k: Int? -> ArrayList() }.add(
//                Arrays.asList(connection[1], 1)
//            )
//            adj.computeIfAbsent(
//                connection[1]
//            ) { k: Int? -> ArrayList() }.add(
//                Arrays.asList(connection[0], 0)
//            )
//        }
//        dfs1(0, -1, adj)
//        return count
//    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 0),
        intArrayOf(4, 5),
    )
    minReorder().minReorder2(6, input)
//    minReorder().minReorder1(6, input)
}