package com.example.lib.leetcode.queue.MyCircularQ

class MyCircularQueue2(k: Int) {

    var f = -1
    var r = -1
    var q = IntArray(k)
    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            // q is full
            return false
        } else if (f == -1 && r == -1) {
            // star the q
            f = 0
            r = 0
            q[f] = value
            return true
        } else {
            // q is not full
            // r ranges
            r = (r + 1) % q.size
            q[r] = value
            return true
        }
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        } else if (f == r) {
            // single element in q
            q[f] = 0
            f = -1
            r = -1
            return true
        } else {
            // more than 1 element in q
            q[f] = 0
            f = (f + 1) % q.size
            return true
        }
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1
        } else {
            return q[f]
        }
    }

    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        } else {
            return q[r]
        }
    }

    fun isEmpty(): Boolean {
        if (f == -1 && r == -1) {
            return true
        }
        return false
    }

    /*
    f
    0 1 2 3 4 5
   f,r
   -1 0 1 2 3 4 5
    */
    fun isFull(): Boolean {
        var full = false
        //f..r
        if ((r + 1) % q.size == f) {
            full = true
        }
        return full
    }

    fun print() {
        var i = f
        println()
        while (i <= r) {
            print(q[i])
            i++
        }
        println()
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