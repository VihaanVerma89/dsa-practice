package com.example.lib.topics.recursion

class RecursionVariable {

    fun recursiveFunction(n: Int) {
        println("value of n : $n")
        if (n == -10 || n == 10) {
            return
        }
        recursiveFunction(n - 1)
//        recursiveFunction(n + 1)
        val i = 0
    }
}

fun main() {
    val recursionVariable = RecursionVariable()
    recursionVariable.recursiveFunction(0)
}