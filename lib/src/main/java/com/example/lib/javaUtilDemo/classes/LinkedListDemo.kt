package com.example.lib.javaUtilDemo.classes

import java.util.*


fun reverse(){
    val ll = LinkedList<Int>()
    ll.add(1)
    ll.add(2)
    ll.add(3)
    ll.add(4)
    ll.add(5)
    ll.add(6)
    ll.add(7)
    ll.add(8)
    ll.add(9)
    ll.add(10)

    ll.reversed()
    val joinToString = ll.joinToString(",", "[", "]")
    println(joinToString)

    val first = ll.first
}


fun deQueueDemo(){

    val ll = LinkedList<Int>()


    ll.addFirst(0)
    ll.addLast(2)
    ll.addFirst(1)
    ll.addLast(4)
    ll.addFirst(3)
    // 3 1 0 2 4

    println("ll : $ll")

}
fun main() {

    deQueueDemo()
}

