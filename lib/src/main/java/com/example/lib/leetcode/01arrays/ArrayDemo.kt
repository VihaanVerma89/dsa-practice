package com.example.lib.leetcode.`01arrays`

// https://kotlinlang.org/docs/arrays.html
class ArrayDemo {

    fun test() {
        val a1 = arrayOf(1, 2, 3)
        val a2 = Array<Int>(3) { 0 }


        val twoDArray = Array(10) { Array(2) { 0 } }

        // Array( size, { value } )
        Array(10) {
            Array(10) { 0 }

            fun main() {
                ArrayDemo().test()
            }

        }

        fun arrayOfDemo() {

            val a1 = arrayOf(1, 2, 3)
            val a2 = arrayOf("kotlin", "java", "swift")

            println("a1 : ${a1.contentToString()}")
            println("a2 : ${a2.contentToString()}")

            val intArray = intArrayOf(1, 2, 3)
            println("intArray : ${intArray.contentToString()}")

            val doubleArray = doubleArrayOf(1.1, 2.2, 3.3)
            println("doubleArray : ${doubleArray.contentToString()}")
            val booleanArray = booleanArrayOf(true, false, true)
            println("booleanArray : ${booleanArray.contentToString()}")
        }

        fun arrayClassDemo() {
            val a1 = Array<Int>(3) { i -> i + 1 }
            println(a1.contentToString())
        }

        fun twoDimenArrayDemo() {

            val matrix = Array(3) { IntArray(3) } // 3x3 Matrix initialized with zeros

            for (row in matrix) {
                println(row.contentToString())
            }
        }


    }
}

fun main() {
    val instance = ArrayDemo()
//    instance.arrayOfDemo()
//    instance.arrayClassDemo()
//    instance.twoDimenArrayDemo()

}

