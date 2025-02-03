package com.example.lib.leetcode.binaryTrees

class SumUsingRecursion {

    fun sum(i: Int): Int {

        // term condition
        if (i == 10) {
            return 1
        }

        return 1 + sum(i + 1)
    }

}

fun main(){
   val result =  SumUsingRecursion().sum(0)
    println("result: $result")
}