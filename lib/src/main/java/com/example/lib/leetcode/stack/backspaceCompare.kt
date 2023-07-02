package com.example.lib.leetcode.stack

import java.util.*

class backspaceCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        var result = false

        val stack1 = Stack<Char>()
        val stack2 = Stack<Char>()

        for (c in s) {
            if (c == '#') {
                // delete char
                if (stack1.isNotEmpty()) {
                    val top = stack1.pop()
                }
            } else {
                stack1.add(c)
            }
        }

        for (c in t) {
            if (c == '#') {
                // delete char
                if (stack2.isNotEmpty()) {
                    val top = stack2.pop()
                }
            } else {
                stack2.add(c)
            }
        }

        // are stack1 & stack2 same ?
        if (stack1.isEmpty() && stack2.isEmpty()) {
            result = true
        }
        // stack have chars and are of same size
        else if (stack1.size == stack2.size) {
            // are the chars same ?
            while (stack1.isNotEmpty()) {
                val top1 = stack1.pop()
                val top2 = stack2.pop()

                if (top1 == top2) {
                    // stacks match at top continue popping
                } else if (top1 != top2) {
                    // terminate func
                    return false
                }
            }

            // will reach here only when stacks are same
            result = true
        } else {
            // stacks are not same
            result = false
        }

        return result
    }
}