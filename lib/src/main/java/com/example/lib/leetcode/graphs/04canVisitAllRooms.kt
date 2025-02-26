package com.example.lib.leetcode.graphs

class `04canVisitAllRooms` {


    val vHashSet = hashSetOf<Int>()
    fun dfs(node: Int, hmap: HashMap<Int, List<Int>>) {

        if (vHashSet.contains(node)) {
            return
        } else {
            vHashSet.add(node)
            val childNodes = hmap.get(node)
            if (childNodes != null) {
                for (childNode in childNodes) {
                    dfs(childNode, hmap)
                }
            }
        }
    }

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {

        val hmap = hashMapOf<Int, List<Int>>()

        // make dfs graph
        for (roomIv in rooms.withIndex()) {
            hmap[roomIv.index] = roomIv.value
        }

        // visit all possible nodes
        dfs(0, hmap)

        return vHashSet.count() == rooms.size
        // visitCount == nodeCount ?
    }


}
