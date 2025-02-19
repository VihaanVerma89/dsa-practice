package com.example.lib.leetcode.graphs

import com.example.lib.Solution

class GraphDemo {

    val graph = mutableMapOf<Int, MutableList<Int>>()

    // map.computeIfAbsent
    fun addEdge(source: Int, destination: Int) {
        graph.computeIfAbsent(source) { mutableListOf() }.add(destination)
        graph.computeIfAbsent(destination) { mutableListOf() }.add(source)
    }

    // for ((k,v) in map)
    fun printGraph() {

        for ((key, value) in graph) {
            println("$key -> $value ")
        }

    }

}

fun main() {

    val graph = GraphDemo()
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)
    graph.addEdge(3, 4)
    graph.printGraph()

}