package com.example.lib.geeksforgeeks.stack

import java.util.*

class NextGreaterElement {
    fun printNextGreaterElement(array: IntArray) {
        val stack = Stack<Int>()
        for (i in array.indices) {
            var value = array[i]
            if (!stack.isEmpty()) {
                var peek = stack.peek()
                if (value > peek) {
                    while (value > peek) {
                        val pop = stack.pop()
                        println("$pop -> $value")
                        if (!stack.isEmpty()) {
                            peek = stack.peek()
                        } else {
                            stack.push(value)
                            break
                        }
                    }
                } else {
                    stack.push(value)
                }
            } else {
                stack.push(value)
            }
        }
    }
}

fun main() {
    println("hello")
    val nextGreaterElement = NextGreaterElement()
    val intArrayOf = intArrayOf(4, 5, 2, 25)
    nextGreaterElement.printNextGreaterElement(intArrayOf)
}