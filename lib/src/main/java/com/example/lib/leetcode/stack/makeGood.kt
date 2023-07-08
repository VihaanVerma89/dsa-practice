package com.example.lib.leetcode.stack

import java.lang.Character.isLowerCase
import java.lang.Character.isUpperCase
import java.util.*
import javax.xml.stream.events.Characters

class makeGood {

    fun makeGood(s: String): String {
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