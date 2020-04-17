package com.example.lib.topics.arrays

fun main(){

    val arrayListOf = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    printArrayList(arrayListOf)
}

fun printArrayList(arrayListOf: ArrayList<Int>) {
    val toString = arrayListOf.toString()
    println(".toString: $toString")
    val joinToString = arrayListOf.joinToString(",", "{", "}")
    println(".joinToString : $joinToString")
}