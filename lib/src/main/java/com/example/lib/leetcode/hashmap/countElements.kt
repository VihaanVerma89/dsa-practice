package com.example.lib.leetcode.hashmap

class countElements {

    fun countElements(arr: IntArray): Int {

        val hmap = hashMapOf<Int, Int>()

        for (iv in arr.withIndex()) {
            if (hmap.contains(iv.value)) {
                hmap[iv.value] = hmap[iv.value]!!.plus(1)
            } else {
                hmap[iv.value] = 1
            }
        }

        // value -> freq map ready

        var c = 0
        for (iv in arr.withIndex()) {
            val onePlus = iv.value + 1
            if (hmap.contains(onePlus)) {
                hmap[onePlus] = hmap[onePlus]!!.minus(1)
                c++
            } else {
                // nothing
            }
        }

        return c
    }


}

fun main() {
//    [1,3,2,3,5,0]
    /*

    */
}