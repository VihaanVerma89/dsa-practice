package com.example.lib.leetcode.stack

import java.util.*

class EvaluateReversePolishNotation {

    /*
    *["2", "1", "+", "3", "*"]
    * 2+1
    * 3,3,*
    * 3*3
    *
    *
    * ["4", "13", "5", "/", "+"]
    * 13/5
    * 4 , 2.6, +
    * 4 + 2 = 6
    *
    *
    * ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    * 10 , 6 , 12 , -11, *
    * 10, 6, -132, /
    * 10 , 0 , *
    * 0, 17, +
    * 17 , 5 , +
    * 22
    * */
    fun evalRPN(tokens: Array<String>): Int {
        val s = Stack<Int>()
        val add = "+"
        val sub = "-"
        val mul = "*"
        val div = "/"
        val hashSetOf = hashSetOf<String>(
            add, sub, mul, div
        )

        for (token in tokens) {
            if (hashSetOf.contains(token)) {
                // operator found
                val n2 = s.pop()
                val n1 = s.pop()
                var r = 0
                if (token == add) {
                    r = n1 + n2
                } else if (token == sub) {
                    r = n1 - n2
                } else if (token == mul) {
                    r = n1 * n2
                } else if (token == div) {
                    r = n1 / n2
                }
                s.push(r)
            } else {
                s.push(token.toInt())
            }
        }
        val pop = s.pop()
        return pop
    }

}