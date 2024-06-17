package com.example.lib.demo.lists

// https://kotlinlang.org/docs/arrays.html
class ArrayDemo {

    fun test() {
        val a1 = arrayOf(1, 2, 3)
        val a2 = Array<Int>(3) { 0 }


        val twoDArray = Array(10) { Array(2) { 0 } }

        // Array( size, { value } )
        Array(10) { Array(10) { 0 } }

        fun main() {
            ArrayDemo().test()
        }

    }

}

