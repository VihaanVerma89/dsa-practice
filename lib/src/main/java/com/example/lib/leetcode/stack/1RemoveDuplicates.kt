package com.example.lib.leetcode.stack

import java.util.ArrayDeque
import java.util.Stack

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class RemoveDuplicates {

    fun removeDuplicates(s: String): String {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pollLast())
        }
        return sb.toString()
    }

    fun removeDuplicates2(s: String): String {

        val stack = Stack<Char>()

        for (c in s) {
            if (stack.isNotEmpty()) {
                val top = stack.peek()
                if (top == c) {
                    // duplicate chars
                    stack.pop()
                } else {
                    // not duplicate chars
                    stack.push(c)
                }
            } else {
                stack.push(c)
            }
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }

        return sb.toString().reversed()
    }

    fun removeDuplicates1(s: String): String {
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
