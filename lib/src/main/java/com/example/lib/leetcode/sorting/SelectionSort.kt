package com.example.lib.leetcode.sorting

// https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4433/
class SelectionSort {

    fun selectionSort(arr: IntArray) {
        val result = arr.contentToString()
        println("$result")

        var i = 0
        var j = 0

        while (i <= arr.lastIndex) {

            while (j <= arr.lastIndex) {
                if (arr[i] < arr[j]) {
                    // already sorted
                    j++
                } else if (arr[i] == arr[j]) {
                    j++
                } else if (arr[i] > arr[j]) {
                    // swap when value at i is bigger than j
                    var temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
            i++
            j=i
        }

    }

}


fun main() {
    val instance = SelectionSort()
    var input = intArrayOf(7, 3, 2, 5, 6, 10, 9, 8, 1)
    instance.selectionSort(input)
    val result = input.contentToString()
    println("$result")
}