package com.example.lib.javaUtilDemo.classes

import java.util.*

class TreeMapDemo {


}


fun main() {

    val treeMap = TreeMap<Int, String>()

    treeMap[3] = "vihaan 3"
    treeMap[2] = "vihaan 2"
    treeMap[1] = "vihaan 1"
    treeMap[0] = "vihaan 0"

    println("Tree Map contents")
    println(treeMap)

    val ceilingEntry = treeMap.ceilingEntry(2)
    println("Tree Map ceilingEntry : 2 ")
    println(ceilingEntry)

    val headMap = treeMap.headMap(2)
    println("Tree Map headMap : 2 ")
    println(headMap)

    val tailMap= treeMap.tailMap(2)
    println("Tree Map tailMap: 2 ")
    println(tailMap)

}
