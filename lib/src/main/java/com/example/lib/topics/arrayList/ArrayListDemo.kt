package com.example.lib.topics.arrayList

fun main(){

    val arrayListOf = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    printArrayList(arrayListOf)
    testArrayListRef()
}

fun printArrayList(arrayListOf: ArrayList<Int>) {
    val toString = arrayListOf.toString()
    println(".toString: $toString")
    val joinToString = arrayListOf.joinToString(",", "{", "}")
    println(".joinToString : $joinToString")
}

fun testArrayListRef(){

    val r = arrayListOf<ArrayList<Int>>()

    val l1 = arrayListOf<Int>(1,2,3)

    r.addAll(listOf(l1))
    l1.clear()
    println(r)
}