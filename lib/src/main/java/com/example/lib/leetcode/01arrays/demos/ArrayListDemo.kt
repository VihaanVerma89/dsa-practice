package com.example.lib.leetcode.`01arrays`.demos

class ArrayListDemo {

    fun test() {

        val test0 = arrayListOf<Int>()
        println("test0 $test0")

        val test1 = ArrayList<Int>()
        println("test1 $test1")

        val test2 = arrayListOf(ArrayList<Int>())
        println("test2 $test2")

        val test3 = arrayListOf<ArrayList<Int>>()
        println("test3 $test3")
    }

}

fun main() {
    ArrayListDemo().test()
}