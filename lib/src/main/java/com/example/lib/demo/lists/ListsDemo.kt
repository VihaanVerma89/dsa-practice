package com.example.lib.demo.lists

class ListsDemo {

    fun test() {

        val arrayList = arrayListOf<ArrayList<Int>>()
        val mutableListOf = mutableListOf<MutableList<Int>>()

        // both arrayList and mutableList produce arrayList

        for (i in 0..10) {
//            arrayList[i] = arrayListOf()
            arrayList.add(arrayListOf())
            for (j in 1..10) {
                arrayList[i].add(i * j)
            }
        }

        val result = arrayList.joinToString(",")
        println(result)
    }
}

fun main() {
    val listsDemo = ListsDemo()
    listsDemo.test()
}