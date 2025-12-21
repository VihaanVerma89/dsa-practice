package com.example.lib.leetcode.stack

class ArrayDequeueDemo {


    /*

    In Kotlin, ArrayDeque<E> inherits methods from MutableCollection plus some deque-specific ones for stack and queue operations.
Here’s the breakdown by category:

⸻

1. Adding Elements
	•	add(element: E) – Adds to the end (like addLast).
	•	addFirst(element: E) – Insert at the front.
	•	addLast(element: E) – Insert at the back.
	•	offer(element: E) – Same as addLast, returns true.
	•	offerFirst(element: E), offerLast(element: E) – Safe versions of addFirst/addLast that return false on failure.

⸻

2. Removing Elements
	•	remove() – Removes from the front (throws if empty).
	•	removeFirst(), removeLast() – Remove from front/back (throw if empty).
	•	poll() – Removes from the front, returns null if empty.
	•	pollFirst(), pollLast() – Safe remove front/back (return null if empty).
	•	clear() – Remove all elements.

⸻

3. Peeking (Look Without Removing)
	•	element() – Peek first element (throws if empty).
	•	getFirst(), getLast() – Peek front/back (throws if empty).
	•	peek() – Peek first element, return null if empty.
	•	peekFirst(), peekLast() – Safe peek front/back (return null if empty).

(In Kotlin stdlib, you’ll more often see first(), last(), firstOrNull(), lastOrNull() from collection extensions.)

⸻

4. Iteration & Queries
	•	isEmpty(), size – Check state.
	•	iterator(), descendingIterator() – Iterate forward or backward.
	•	contains(element: E) – Check existence.

⸻

5. Kotlin Extension Functions (from kotlin.collections)

You can also use:
	•	first(), firstOrNull()
	•	last(), lastOrNull()
	•	forEach {}, map {}, filter {}, etc.

⸻

💡 Stack pattern:
	•	Push → addLast()
	•	Pop → removeLast()
	•	Peek → last() / lastOrNull()

💡 Queue pattern:
	•	Enqueue → addLast()
	•	Dequeue → removeFirst()
	•	Peek front → first() / firstOrNull()

⸻

     */


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