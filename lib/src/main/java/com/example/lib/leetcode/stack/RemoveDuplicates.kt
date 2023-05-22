package com.example.lib.leetcode.stack

import java.util.Stack

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class RemoveDuplicates {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        var r = ""

        for (c in s) {
            if (stack.isEmpty().not()) {
                val peek = stack.peek()
                if (peek == c) {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            } else {
                stack.push(c)
            }
        }

        // what is left in stack is not duplicate
        if (stack.isEmpty()) {

        } else {
            while (stack.isEmpty().not()) {
                r = stack.pop() + r
            }
        }
        return r
    }
}

fun main() {
    val instance = RemoveDuplicates()
    val r = instance.removeDuplicates("abbaca")
    println("result : $r")
}
