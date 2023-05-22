package com.example.lib.leetcode.q.MyCircularQ

//https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
/*
            ht
* 0 1 2 3 4 5

* */
class MyCircularQueue1(val k: Int) {

    val q = IntArray(k)
    var h = -1
    var t = -1
    var items = 0

    /*
      h         t
    * 0 1 2 3 4 5
    h,t=-1
    h==t
    h<t
    h>t
    * */
    fun enQueue(value: Int): Boolean {
        var inserted = false

        fun insertItem(t: Int, value: Int) {
            q[t] = value
            items++
            inserted = true
        }

        if (isEmpty()) {
            // first enqueue
            h++
            t++
            insertItem(t, value)
        } else {
            var nt = t + 1
            nt %= k
            if (nt == h) {
                // q is full
            } else {
                t = nt
                insertItem(t, value)
            }
        }

        return inserted
    }

    /*
      h         t
    * 0 1 2 3 4 5
    h,t=-1
    h==t
    h<t
    h>t
    * */
    fun deQueue(): Boolean {
        var removed = false

        fun removeItem(h: Int, t: Int) {
            if (items == 1) {
                this.h = -1
                this.t = -1
            } else {
                this.h++
                this.h %= k
            }

            items--
            removed = true
        }

        if (isEmpty()) {
            // q is empty
        } else {
            removeItem(h, t)
        }
        return removed
    }

    fun Front(): Int {
        var item = -1
        if (!isEmpty()) {
            item = q[h]
        }
        return item
    }

    fun Rear(): Int {
        var item = -1
        if (!isEmpty()) {
            item = q[t]
        }
        return item
    }

    fun isEmpty(): Boolean {
        return items == 0
    }

    fun isFull(): Boolean {
        return items == k
    }

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