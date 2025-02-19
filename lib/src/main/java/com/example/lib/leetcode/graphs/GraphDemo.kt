package com.example.lib.leetcode.graphs

class GraphDemo {

    val graphMap = mutableMapOf<Int, MutableList<Int>>()

    // map.computeIfAbsent
    fun addEdgeInMap(source: Int, destination: Int) {
        graphMap.computeIfAbsent(source) { mutableListOf() }.add(destination)
        graphMap.computeIfAbsent(destination) { mutableListOf() }.add(source)
    }

    // for ((k,v) in map)
    fun printMapGraph() {

        for ((key, value) in graphMap) {
            println("$key -> $value ")
        }

    }


}

class GraphMatrix(private val size: Int) {

    private val matrix = Array(size) { IntArray(size) }


    fun addEdge(source: Int, destination: Int) {
        matrix[source][destination] = 1
        matrix[destination][source] = 1
    }

    fun printMatrix() {
        for (intArray in matrix) {
            println(intArray.contentToString())
        }
    }
}

fun main() {

    mapDemo()
    println()
    matrixDemo()

}

fun mapDemo() {
    val graph = GraphDemo()
    graph.addEdgeInMap(1, 2)
    graph.addEdgeInMap(1, 3)
    graph.addEdgeInMap(2, 4)
    graph.addEdgeInMap(3, 4)
    graph.printMapGraph()
}

fun matrixDemo() {
    val graph = GraphMatrix(5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)
    graph.printMatrix()
}