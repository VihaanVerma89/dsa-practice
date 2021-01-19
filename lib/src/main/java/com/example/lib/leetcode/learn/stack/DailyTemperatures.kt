package com.example.lib.leetcode.learn.stack

import java.util.*

class DailyTemperatures {
    /*
    * [73, 74, 75, 71, 69, 72, 76, 73]
    * [1, 1, 4, 2, 1, 1, 0, 0]
    *
    * */
    fun dailyTemperatures(T: IntArray): IntArray {
        val stack = Stack<IndexedValue<Int>>()
        val result = IntArray(T.size) { 0 }
        for (iv in T.withIndex()) {
            val value = iv.value
            val index = iv.index
            if (stack.isNotEmpty()) {
                var peek = stack.peek()
                if (peek.value == value) {
                } else if (peek.value < value) {
                    // pop elements from the stack till peek.value < value
                    while (peek.value < value) {
                        val pop = stack.pop()
                        result[pop.index] = iv.index - pop.index
                        if (stack.isNotEmpty()) {
                            peek = stack.peek()
                        } else {
                            break
                        }
                    }

                } else if (peek.value > value) {
                }
            }
            stack.push(iv)
        }

        return result
    }
}