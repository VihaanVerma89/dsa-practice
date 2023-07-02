package com.example.lib.leetcode.stack

import java.util.*

class ValidParentheses {
    fun isValid1(s: String): Boolean {
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
            if (isOpen1(char)) {
                // char is open
                stack.push(char)
            } else if (isClose1(char)) {
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

    fun isOpen1(char: Char): Boolean {
        return char == '(' || char == '{' || char == '['
    }

    fun isClose1(char: Char): Boolean {
        return char == ')' || char == '}' || char == ']'
    }


    fun isValid2(s: String): Boolean {
        var valid = true

        val stack = Stack<Char>()

        for (c in s) {
            if (isOpen1(c)) {
                stack.push(c)
            } else {
                // c is close
                if (stack.isEmpty().not()) {
                    val pc = stack.peek()
                    if (isCloseMatch(pc, c)) {
                        stack.pop()
                    } else {
                        // stack peek doesnt match it not valid
                        valid = false
                        break
                    }
                } else {
                    // stack is empty
                    valid = false
                    break
                }
            }
        }


        if (stack.isEmpty().not()) {
            // matching close not found
            valid = false
        }

        return valid
    }

    fun isCloseMatch(pc: Char, c: Char): Boolean {
        var match = false
        if (pc == '(' && c == ')') {
            match = true
        } else if (pc == '[' && c == ']') {
            match = true
        } else if (pc == '{' && c == '}') {
            match = true
        }
        return match
    }


    fun isValid(s: String): Boolean {
        var result = true
        if (s.length < 2) {
            return false
        }
        val stack = Stack<Char>()
        for (c in s) {
            if (c == '[' || c == '(' || c == '{') {
                // opening start
                stack.push(c)
            } else if (c == ']' || c == ')' || c == '}') {
                // closing found check stack for matching opening
                if (stack.isEmpty()) {
                    return false
                } else {
                    // stack is not empty
                    // does stack have matching opening chars
                    val top = stack.pop()
                    if (top == '[' && c == ']') {

                    } else if (top == '(' && c == ')') {

                    } else if (top == '{' && c == '}') {

                    } else {
                        // didnt find matching opening and close
                        return false
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            result = false
        }
        return result
    }


}


fun main() {
    val o = ValidParentheses()
//    val s = "(){}}{"
//    o.isValid1(s)
//    val s = "(]"
    val s = "()"
    o.isValid(s)
}