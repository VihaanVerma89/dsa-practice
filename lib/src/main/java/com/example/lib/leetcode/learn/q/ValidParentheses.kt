package com.example.lib.leetcode.learn.q

import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.isEmpty() || s.length == 1)
            return false
        val stack = Stack<Char>()
        val openCloseMap = hashMapOf(
            Pair('[', ']'),
            Pair('{', '}'),
            Pair('(', ')')
        )
        var result = true

        for (iv in s.withIndex()) {
            val char = iv.value
            if (isOpen(char)) {
                // char is open
                stack.push(char)
            } else if (isClose(char)) {
                // char is close
                if (stack.isEmpty()) {
                    // stack is empty
                    result = false
                    break
                } else if (stack.isNotEmpty()) {
                    // stack is not empty

                    // stack top is open
                    val peek = stack.peek()
                    if (openCloseMap.get(peek) == char) {
                        // matching open close found
                        stack.pop()
                    } else {
                        // peek is open but char is not a matching close
                        result = false
                        break
                    }
                }
            }
        }

        if (stack.isNotEmpty()) {
            // some opens chars didn't have matching close chars
            result = false
        }


        return result
    }

    fun isOpen(char: Char): Boolean {
        return char == '(' || char == '{' || char == '['
    }

    fun isClose(char: Char): Boolean {
        return char == ')' || char == '}' || char == ']'
    }
}

fun main() {
    val o = ValidParentheses()
    val s = "(){}}{"
    o.isValid(s)
}