package com.example.lib.kotlinsDemo.collections


fun filterList() {
    val numbers = listOf("one", "two", "three", "four")
    val filter = numbers.filter {
        it.length > 3
    }
    println("numbers $numbers")
    println("filtered numbers $filter")
}

fun filterMap() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)

    val filter = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println("map $numbersMap")
    println("filtered map $filter")
}

fun main() {
//    filterList()
    filterMap()
}