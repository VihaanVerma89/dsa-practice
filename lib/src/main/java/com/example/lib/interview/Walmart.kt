package com.example.lib.interview

class Walmart {

//    fun getProductArray(a: IntArray): IntArray {
//
//        var product = 1
//        for ((index, value) in a.withIndex()) {
//            product *= value
//        }
//
////        val productArray = intArrayOf()
//        val productArray = IntArray(a.size)
//
//        for ((index, value) in a.withIndex()) {
//            productArray[index] = product / value
//        }
//        return productArray
//    }

    fun getProductArray(a: IntArray): IntArray {

        val productArray = IntArray(a.size)
        for ((i, v1) in a.withIndex()) {
            for (j in a.indices) {
                if (i != j) {
                    productArray[i] *= a[j]
                } else {
                    productArray[i] = 1
                }
            }
        }
        return productArray
    }


}

fun main() {

//    val a = intArrayOf(1, 2, 3, 4, 5)
//    val a = intArrayOf(10,2,4,5)
//    val a = intArrayOf(-10,2,4,5)
//    val a = intArrayOf(10)
    val a = intArrayOf(0, 2, 4, 5)

    val w = Walmart()

    val productArray = w.getProductArray(a)

    val contentToString = productArray.contentToString()
    println(contentToString)

}