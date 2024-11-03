package com.example.lib.demo.strings

class StringDemo {

    fun splitDemo(){
//        val text = "apple,banana,cherry"
//        val fruits = text.split(",")
//        println(fruits) // Output: [apple, banana, cherry]

        val text = "apple,bannana,cherry"
        val fruits = text.split(",")
        println(fruits)
    }

    fun nullTest() {
    }

}

fun main() {
//    val stringDemo = StringDemo()
//    stringDemo.nullTest()

    println(StringDemo().splitDemo())
}