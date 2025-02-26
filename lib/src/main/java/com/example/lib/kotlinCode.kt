package com.example.lib

import java.util.LinkedList

class Solution {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean{

        val graph = mutableMapOf<Int, MutableList<Int>>()

        var i = 0
        for(room in rooms){

            graph.getOrPut(i){ mutableListOf() }.addAll(room)
            i++
        }

        val visited = hashSetOf<Int>()

        fun dfs(room: Int){
            if(visited.contains(room)){

                // already visited
                return
            }

            visited.add(room)

            val keys = graph.getOrDefault(room, emptyList())

            if(keys.isEmpty()){
                return
            }


            for(key in keys){
                dfs(key)
            }

        }

        dfs(0)

        return rooms.size == visited.size

    }




}

fun main() {
}

