package com.example.lib.leetcode.stack

import java.util.LinkedList
import java.util.Stack

class StackDemo {


    /*
    https://stackoverflow.com/questions/46900048/how-can-i-use-stack-in-kotlin

    Check ArrayDequeDemo.kt for ArrayDeque implementation
    */
    fun stackDemo() {

        val stack = Stack<Int>()

        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)



        while (stack.isEmpty().not()) {
            println(stack.pop())
        }

        if (stack.isEmpty()) {
            println("stack is empty and will give exception on popo")
            stack.pop()
        }


    }

}

fun main() {
    StackDemo().stackDemo()
}
