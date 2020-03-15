package com.example.lib.geeksforgeeks.stack

class StackArray(private val size: Int) {

    private var stack = Array(size) { 0 }
    var i = -1

    fun push(value: Int) {
        if (!isFull()) {
            i++
            stack[i] = value
        } else {
            printStackIsFull()
        }
    }

    private fun isFull(): Boolean {
        var full = false
        if (i == (size - 1)) {
            full = true
        }
        return full
    }


    private fun isEmpty(): Boolean {
        var empty = false
        if (i == -1) {
            empty = true
        }
        return empty
    }

    fun top(): Int {
        var topValue = Int.MAX_VALUE
        if (isEmpty()) {
            printStackIsEmpty()
        } else {
            topValue = stack[i]
        }
        return topValue
    }

    fun pop(): Int {
        var poppedValue: Int = Int.MAX_VALUE
        if (isEmpty()) {
            printStackIsEmpty()
        } else {
            poppedValue = stack[i]
            stack[i] = Int.MAX_VALUE
            i--
        }
        return poppedValue
    }

    private fun printStackIsFull() {
        println("Stack is full")
    }

    private fun printStackIsEmpty() {
        println("Stack is empty")
    }

}

fun main() {
    val stackArray = StackArray(5)

    for (i in 0..5) {

    }
    with(stackArray) {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        push(6)
    }
    var top = stackArray.top()
    printTopValue(top)
    var pop = stackArray.pop()
    printPoppedValue(pop)
    pop = stackArray.pop()
    printPoppedValue(pop)
}

fun printTopValue(value: Int) {
    println("Top value : $value")
}

fun printPoppedValue(value: Int) {
    println("Popped value : $value")
}