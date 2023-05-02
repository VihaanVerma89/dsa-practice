package com.example.lib.leetcode.MovingAverage1.q.MyCircularQ

class MyCircularQueue(k: Int) {


    var f = -1
    var r = -1
    val q = IntArray(k)

    fun enQueue(value: Int): Boolean {
        var added = false
        if (isFull()) {
            // full
            added = false
        } else if (isEmpty()) {
            // empty
            f = 0
            r = 0
            q[f] = value
            added = true
        } else {
            // q has some values
            r = (r + 1) % q.size
            q[r] = value
            added = true
        }
        return added
    }

    fun deQueue(): Boolean {
        var removed = false
        if (isEmpty()) {

        } else if (f == r) {
            // single element in q
            q[f] = 0
            f = -1
            r = -1
            removed = true
        } else {
            // more than 1 element in q
            q[f] = 0
            f = (f + 1) % q.size
            removed = true
        }
        return removed
    }

    fun Front(): Int {
        var result = -1

        if (isEmpty()) {

        } else {
            result = q[f]
        }
        return result
    }

    fun Rear(): Int {
        var result = -1
        if (isEmpty()) {

        } else {
            result = q[r]
        }
        return result
    }

    fun isEmpty(): Boolean {
        return f == -1 && r == -1
    }

    fun isFull(): Boolean {
        return (r + 1) % q.size == f
    }

    fun print() {

    }
}

fun main() {
    val k = 10
    val obj = MyCircularQueue(k)
    obj.enQueue(3)
    obj.enQueue(1)
    obj.enQueue(2)
    obj.enQueue(4)

    obj.print()

    obj.Rear()
    obj.isFull()
    obj.deQueue()
    obj.enQueue(4)
    obj.Rear()

    obj.print()

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */