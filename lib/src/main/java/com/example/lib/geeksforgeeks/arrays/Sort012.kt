package com.example.lib.geeksforgeeks.arrays


fun sort012(a: IntArray) {
    var lo = 0
    var hi = a.size - 1
    var mid = lo
    while (lo <= hi) {
        when (a[mid]) {
            0 -> {
                swapElement(a,a[mid], a[lo])
                lo++
            }
            1 -> {
                mid++
            }
            2 -> {
                swapElement(a, a[mid], a[hi])
                hi--
            }
        }
    }
}

fun swapElement(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun main() {
    val arr = intArrayOf(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1)
    sort012(arr)
    println("Array after seggregation ")
    println(arr.contentToString())
}
