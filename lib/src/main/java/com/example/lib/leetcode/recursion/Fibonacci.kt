package com.example.lib.leetcode.recursion

class Fibonacci {

    fun getFibNumber(n: Int): Int {
        println("n : $n")
        if (n == 0) {
            return 0
        } else if (n == 1) {
            return 1
        }
        val part1 = getFibNumber(n - 1)
        println("n: $n , part1 = $part1")
        val part2 = getFibNumber(n - 2)
        println("n: $n , part2 = $part2")
        val sum = part1 + part2
        println("sum: $sum")
        return sum
    }

}

fun main() {

    val instance = Fibonacci()
    val result = instance.getFibNumber(5)
    println("Result : $result")

}