package com.example.lib.geeksforgeeks.arrays


fun sort012(intArray: IntArray) {

    var lo = 0
    var hi = intArray.size.minus(1)
    var index = 0
    while (index <= hi) {
        val value = intArray[index]
        when (value) {
            0 -> {
                swapValues(intArray, index, lo)
                lo++
                index++
            }
            1 -> {
                index++
            }
            2 -> {
                swapValues(intArray, index, hi)
                hi--
            }
        }
        val contentToString = intArray.contentToString()
        println(contentToString)
    }

}

fun swapValues(array: IntArray, fromIndex: Int, toIndex: Int) {
    val temp = array[toIndex]
    array[toIndex] = array[fromIndex]
    array[fromIndex] = temp
}

fun main() {
    val arr = intArrayOf(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1)
    sort012(arr)
    println("Array after seggregation ")
    println(arr.contentToString())
}


