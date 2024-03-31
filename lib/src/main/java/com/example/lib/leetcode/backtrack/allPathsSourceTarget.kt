package com.example.lib.leetcode.backtrack1

class allPathsSourceTarget {

    fun backtrack1(
        hmap: HashMap<Int, IntArray>,
        node: Int,
        tempList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
//        if (node == hmap.size - 1) {
        if (node == hmap.size - 1) {
            val r = ArrayList(tempList)
            r.add(node)
            ansList.add(r)
        }

        // traversal
        val connectionsList = hmap[node]
        for (connection in connectionsList!!) {
            tempList.add(node)
            backtrack1(hmap, connection, tempList, ansList)
            tempList.removeAt(tempList.size - 1)
        }

    }

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {

        val hmap = hashMapOf<Int, IntArray>()

        for (iv in graph.withIndex()) {
            // 0 - 1,2,3
            hmap.put(iv.index, iv.value)
        }

        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        backtrack1(hmap, 0, tempList, ansList)
        return ansList
    }

}

fun main() {

    val input = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf())
    val result = allPathsSourceTarget().allPathsSourceTarget(input)
    val resultString = result.joinToString(",")
    println("result : $resultString")

}
