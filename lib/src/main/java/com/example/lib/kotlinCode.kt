package com.example.lib

import java.util.LinkedList

class Solution {

    fun bfs(node: Int){

        val q = LinkedList<Int>()
        val visited = hashSetOf<Int>()

        q.add(node)
        visited.add(node)


        while(q.isNotEmpty()){

            val currentNode = q.poll()
            println("current node : $currentNode")


            val nodes = graphMap.get(currentNode).orEmpty()

            for(n in nodes){

                if(visited.contains(n)){

                }
                else{
                    q.add(n)
                    visited.add(n)
                }
            }


        }




    }
}

fun main() {
}

