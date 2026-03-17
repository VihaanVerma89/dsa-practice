package com.example.lib.leetcode.`01arrays`

fun main() {

    val intArrayOf = intArrayOf(1, 2, 3, 4, 5, 6)
    printValue(intArrayOf)

}

fun printValue(array: IntArray): Unit {
    val toString = array.toString()
    println("toString: $toString ")

    val contentToString = array.contentToString()
    println("contentToString : $contentToString ")
}

