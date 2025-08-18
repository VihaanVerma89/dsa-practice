package com.example.lib.leetcode.stack

import java.util.*
import kotlin.collections.ArrayDeque

class makeGood {


    fun makeGood(s: String): String {

        val dq = ArrayDeque<Char>()


        for (c in s) {

            val peek = dq.lastOrNull()

            if (peek != c && (peek?.uppercaseChar() == c || peek?.lowercaseChar() == c)) {
                dq.removeLast()
            } else {
                dq.addLast(c)
            }

        }

        return dq.joinToString("")
    }

    fun makeGood2(s: String): String {
        if (s.isNullOrEmpty() || s.length == 1) {
            return s
        }

        val dq = ArrayDeque<Char>()
        for (c in s) {
            if (dq.isNotEmpty() && isBadChar(c, dq.last())) {
                dq.removeLast()
            } else {
                dq.addLast(c)
            }
        }
        var sb = StringBuilder()
        while (dq.isNotEmpty()) {
            sb.append(dq.removeFirst())
        }
        return sb.toString()
    }

    fun isBadChar(c1: Char, c2: Char): Boolean {
        var result = false
        if (c1 == c2) {
            // they are the same
        } else if (c1.lowercaseChar() == c2 || c1.uppercaseChar() == c2) {
            result = true
        } else if (c1 == c2.lowercaseChar() || c1 == c2.uppercaseChar()) {
            result = true
        }
        return result
    }

    fun makeGood1(s: String): String {
        val stack = Stack<Char>()

        for (c in s) {
            if (stack.isNotEmpty()) {
                val top = stack.peek()
                if (isLowerCase(top) && isUpperCase(c) && lowerCase(top) == lowerCase(c)
                    || isUpperCase(top) && isLowerCase(c) && lowerCase(top) == lowerCase(c)
                ) {
                    // upper and lower case found
                    stack.pop()
                } else {
                    stack.add(c)
                }
            } else {
                stack.add(c)
            }
        }

        val sb = StringBuilder()
        for (c in stack) {
            sb.append(c)
        }
        return sb.toString()
    }

    fun lowerCase(c: Char): Char {
        return Character.toLowerCase(c)
    }

    fun upperCase(c: Char): Char {
        return Character.toUpperCase(c)
    }

    fun isLowerCase(c: Char): Boolean {
        return Character.isLowerCase(c)
    }

    fun isUpperCase(c: Char): Boolean {
        return Character.isUpperCase(c)
    }

}

fun main() {
    val instance = makeGood()
    val input = "leEeetcode"
    val output = instance.makeGood(input)
    println("output $output")
}