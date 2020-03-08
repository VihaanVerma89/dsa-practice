package com.example.hackerRank.interviewPrep.arrays.minimumSwap2

import java.util.*

// Complete the minimumSwaps function below.
//fun minimumSwaps(arr: Array<Int>): Int {
//    var count = 0
//    for ((index, value) in arr.withIndex()) {
//        if (value != index + 1) {
//            count++
//        }
//    }
//    var result = 0
//    if (count > 0) {
//        result = count - 1
//    }
//    return result
//}

fun minimumSwaps(array: Array<Int>): Int {
    var swaps = 0
    var index = 0
    var value = 0
    while (index < array.size) {
        value = array[index]
        val expectedValue = index + 1
        if (expectedValue != value) {
            val to = value - 1
            swap(array, index, to)
            swaps++
        } else {
            index++
        }
    }
    return swaps
}

fun swap(array: Array<Int>, from: Int, to: Int) {
    val temp = array[to]
    array[to] = array[from]
    array[from] = temp
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
