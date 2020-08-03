package com.example.lib.kotlinsDemo.strings

class StringDemo {

    fun nullTest() {
        val s: String = null
        println(s)
    }
}

fun main() {
    val stringDemo = StringDemo()
    stringDemo.nullTest()
}