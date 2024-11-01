package com.example.lib.leetcode.stack

class ArrayDequeueDemo {


    fun arrayDequeueDemo() {
        val dq = ArrayDeque<Int>()

        dq.addFirst(1)
        dq.addLast(2)
        dq.addLast(3)
        dq.addLast(4)
        dq.addLast(5)
        dq.addFirst(0)

        println("dq first() ${dq.first()}")
        println("dq last() ${dq.last()}")
        println(dq.removeFirst())
        println("dq first() ${dq.first()}")

        println(dq.removeLast())
        println(dq.last())
    }

}

fun main(){
    ArrayDequeueDemo().arrayDequeueDemo()
}