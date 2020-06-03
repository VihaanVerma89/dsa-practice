package com.example.lib.topics.recursion


val numbersHashMap = hashMapOf<Int, Int>()
fun fib(N: Int): Int {

    if (numbersHashMap.containsKey(N)) {
        return numbersHashMap.get(N)!!
    }

    if (N == 0) {
        return 0
    } else if (N == 1) {
        return 1
    } else {
        val value = fib(N - 1) + fib(N - 2)
        numbersHashMap.put(N, value)
        return value
    }

}

fun main() {}
