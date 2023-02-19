package com.example.lib.topics.twoPointerApproach

import java.io.StringBufferInputStream
import java.lang.StringBuilder
import java.util.*

class MinimumRemovetoMakeValidParentheses {

    fun minRemoveToMakeValid(input: String): String {
        val indexToRemove = hashSetOf<Int>()
        val stack = Stack<Int>()
        for (i in input.withIndex()) {
            val c = input[i.index]
            if (c == '(') {
                stack.push(i.index)
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i.index)
                } else {
                    stack.pop()
                }
            }
        }
        while (stack.isNotEmpty()) {
            indexToRemove.add(stack.pop())
        }

        val stringBuilder = StringBuilder()
        for (i in input.withIndex()) {
            if (!indexToRemove.contains(i.index)) {
                stringBuilder.append(i.value)
            }
        }
        return stringBuilder.toString()
    }

    /*
    lee(t(c)o)de)
           se
    */
    fun minRemoveToMakeValid1(input: String): String {
        var s = input
        if (s.isNotEmpty()) {
            var start = 0
            var end = s.length - 1
            while (start != end) {
                val startChar = s[start]
                val endChar = s[end]
                if (startChar == ')') {
                    s = s.removeRange(start, start + 1)
                    start -= 1
                    start = start.coerceAtLeast(0)
                    end--
                    if (end < 0) {
                        end = 0
                    }
                } else if (startChar == '(') {
                    if (endChar == ')') {
                        start++
                        end--
                    } else if (endChar == '(') {
                        s = s.removeRange(end, end + 1)
                        end--
                    } else if (endChar != '(' && endChar != ')') {
                        end--
                    }
                } else if (startChar != '(' && startChar != ')') {
                    start++
                }
            }
            if (start in 0..s.length) {
                if (s[start] == '(' || s[start] == ')') {
                    s = s.removeRange(start, start + 1)
                }
            }
        }
        return s
    }
}

fun main() {

    val i = MinimumRemovetoMakeValidParentheses()
//    val s = "lee(t(c)o)de)"
//    val s = "))(("
    val s = "())()((("
    val minRemoveToMakeValid = i.minRemoveToMakeValid(s)
    print(minRemoveToMakeValid)

}