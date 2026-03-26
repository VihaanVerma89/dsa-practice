package com.example.lib.leetcode.`01arrays`.demos

// https://kotlinlang.org/docs/arrays.html
class ArrayDemo {

    // --- Creating Arrays ---
    fun creatingArrays() {
        // Generic array (boxed — avoid for primitives in interviews)
        val nums = arrayOf(1, 2, 3, 4)
        println("arrayOf: ${nums.contentToString()}")

        // Array constructor with lambda
        val squares = Array(5) { i -> i * i }
        println("squares: ${squares.contentToString()}")

        // Primitive arrays (preferred — no boxing overhead)
        val intArr = intArrayOf(1, 2, 3)
        val doubleArr = doubleArrayOf(1.0, 2.0, 3.0)
        val boolArr = BooleanArray(5)
        val charArr = CharArray(26) { 'a' + it }

        println("intArr: ${intArr.contentToString()}")
        println("doubleArr: ${doubleArr.contentToString()}")
        println("boolArr: ${boolArr.contentToString()}")
        println("charArr: ${charArr.contentToString()}")
    }

    // --- Useful Properties & Functions ---
    fun propertiesAndFunctions() {
        val arr = intArrayOf(5, 2, 8, 1, 3)

        // Basics
        println("size: ${arr.size}")
        println("indices: ${arr.indices}")
        println("lastIndex: ${arr.lastIndex}")

        // Aggregates
        println("sum: ${arr.sum()}")
        println("average: ${arr.average()}")
        println("max: ${arr.max()}")
        println("min: ${arr.min()}")

        // Searching
        println("indexOf(8): ${arr.indexOf(8)}")
        println("contains(5): ${arr.contains(5)}")
        println("5 in arr: ${5 in arr}")

        // Copying / Slicing
        val copy = arr.copyOf()
        val slice = arr.copyOfRange(1, 4)
        val sliced = arr.sliceArray(1..3)
        println("copyOf: ${copy.contentToString()}")
        println("copyOfRange(1,4): ${slice.contentToString()}")
        println("sliceArray(1..3): ${sliced.contentToString()}")

        // Transformations
        println("reversed: ${arr.reversed()}")
        println("toList: ${arr.toList()}")
        println("toSet: ${arr.toSet()}")
    }

    fun printValue(array: IntArray): Unit {
        val toString = array.toString()
        println("toString: $toString ")

        val contentToString = array.contentToString()
        println("contentToString : $contentToString ")
    }

    // --- Filling & Initializing ---
    fun fillingArrays() {
        val zeros = IntArray(10)
        val ones = IntArray(10) { 1 }
        val indexed = IntArray(5) { it * 2 }

        println("zeros: ${zeros.contentToString()}")
        println("ones: ${ones.contentToString()}")
        println("indexed: ${indexed.contentToString()}")

        val arr = IntArray(5)
        arr.fill(7)
        println("fill(7): ${arr.contentToString()}")
        arr.fill(0, fromIndex = 1, toIndex = 3)
        println("fill(0, 1, 3): ${arr.contentToString()}")
    }

    // --- Sorting ---
    fun sortingDemo() {
        val arr = intArrayOf(5, 2, 8, 1, 3)

        // In-place sort
        arr.sort()
        println("sorted: ${arr.contentToString()}")
        arr.sortDescending()
        println("sortDescending: ${arr.contentToString()}")

        // Returns new array
        val sorted = arr.sortedArray()
        val desc = arr.sortedArrayDescending()
        println("sortedArray: ${sorted.contentToString()}")
        println("sortedArrayDescending: ${desc.contentToString()}")

        // Custom sorting with comparators
        val intervals = arrayOf(intArrayOf(3, 5), intArrayOf(1, 4), intArrayOf(2, 6))
        intervals.sortBy { it[0] }
        println("sortBy start: ${intervals.map { it.contentToString() }}")

        // Multi-key sort
        val people = arrayOf(intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1))
        people.sortWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })
        println("multi-key sort: ${people.map { it.contentToString() }}")
    }

    // --- 2D Arrays ---
    fun twoDArrayDemo() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val rows = matrix.size
        val cols = matrix[0].size
        println("rows=$rows, cols=$cols")

        // Iterate with indices
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                print("${matrix[row][col]} ")
            }
            println()
        }

        // Grid initialized to zeros
        val grid = Array(3) { IntArray(4) }
        println("grid: ${grid.map { it.contentToString() }}")

        // Boolean visited grid
        val visited = Array(rows) { BooleanArray(cols) }

        // Transpose
        val transposed = Array(cols) { j -> IntArray(rows) { i -> matrix[i][j] } }
        println("transposed: ${transposed.map { it.contentToString() }}")

        // Flatten
        val flat = matrix.flatMap { it.toList() }
        println("flat: $flat")

        // Sum all elements
        val total = matrix.sumOf { it.sum() }
        println("total sum: $total")

        // 4-directional neighbors (BFS/DFS grids)
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    }

    // --- Equality Gotcha ---
    fun equalityDemo() {
        val a = intArrayOf(1, 2, 3)
        val b = intArrayOf(1, 2, 3)

        // == checks reference, NOT content
        println("a == b: ${a == b}")                   // false
        println("contentEquals: ${a.contentEquals(b)}") // true

        // 2D equality
        val m1 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val m2 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        println("contentDeepEquals: ${m1.contentDeepEquals(m2)}") // true

        // Printing
        println("contentToString: ${a.contentToString()}")
        println("contentDeepToString: ${m1.contentDeepToString()}")
    }

    // --- String / CharArray Interop ---
    fun stringCharArrayDemo() {
        val s = "hello"

        val chars = s.toCharArray()
        println("toCharArray: ${chars.contentToString()}")

        val back = String(chars)
        println("back to string: $back")

        // Modify characters
        chars[0] = 'H'
        println("modified: ${String(chars)}")

        // Frequency count with IntArray(26)
        val freq = IntArray(26)
        for (c in s) {
            freq[c - 'a']++
        }
        println("freq of 'l': ${freq['l' - 'a']}")

        // Anagram check
        println("isAnagram(listen, silent): ${isAnagram("listen", "silent")}")
        println("isAnagram(hello, world): ${isAnagram("hello", "world")}")
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val count = IntArray(26)
        for (i in s.indices) {
            count[s[i] - 'a']++
            count[t[i] - 'a']--
        }
        return count.all { it == 0 }
    }

    // --- fold & reduce ---
    fun foldReduceDemo() {
        val arr = intArrayOf(1, 2, 3, 4, 5)

        // reduce — first element as initial value
        val sum = arr.reduce { acc, num -> acc + num }
        val product = arr.reduce { acc, num -> acc * num }
        val max = arr.reduce { acc, num -> maxOf(acc, num) }
        println("reduce sum=$sum, product=$product, max=$max")

        // fold — custom initial value
        val sumStr = arr.fold("") { acc, num -> "$acc$num," }
        println("fold to string: $sumStr")

        // fold is safer on empty arrays (reduce throws)
        val empty = intArrayOf()
        val safeSum = empty.fold(0) { acc, num -> acc + num }
        println("fold on empty: $safeSum")

        // runningFold = prefix sum!
        val prefixSum = arr.runningFold(0) { acc, num -> acc + num }
        println("runningFold (prefix sum): $prefixSum")
    }

    // --- Binary Search ---
    fun binarySearchDemo() {
        val arr = intArrayOf(1, 3, 5, 7, 9, 11)

        val found = arr.binarySearch(7)
        println("binarySearch(7): $found") // 3

        val missing = arr.binarySearch(6)
        println("binarySearch(6): $missing") // negative = not found

        // Get insertion point: -(result + 1)
        val insertionPoint = -(missing + 1)
        println("insertion point for 6: $insertionPoint")
    }

    // --- Destructuring ---
    fun destructuringDemo() {
        val (a, b, c) = arrayOf(1, 2, 3)
        println("destructured: a=$a, b=$b, c=$c")

        // withIndex
        val arr = intArrayOf(10, 20, 30)
        for ((index, value) in arr.withIndex()) {
            println("arr[$index] = $value")
        }

        // Skip values with _
        val (_, second, _) = arrayOf("a", "b", "c")
        println("skipped: second=$second")
    }

    // --- Common Interview Snippets ---
    fun interviewSnippets() {
        val arr = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6)

        // Swap two elements
        arr[0] = arr[1].also { arr[1] = arr[0] }
        println("after swap(0,1): ${arr.contentToString()}")

        // Reverse in-place
        arr.reverse()
        println("reversed: ${arr.contentToString()}")

        // Check if sorted
        val isSorted = (0 until arr.size - 1).all { arr[it] <= arr[it + 1] }
        println("isSorted: $isSorted")

        // Frequency map
        val freq = HashMap<Int, Int>()
        for (num in arr) freq[num] = freq.getOrDefault(num, 0) + 1
        println("freq map: $freq")
        // Alternative:
        val freq2 = arr.toList().groupingBy { it }.eachCount()
        println("freq groupingBy: $freq2")

        // Kadane's algorithm — max subarray sum
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        var maxSum = nums[0]; var current = nums[0]
        for (i in 1 until nums.size) {
            current = maxOf(nums[i], current + nums[i])
            maxSum = maxOf(maxSum, current)
        }
        println("max subarray sum (Kadane's): $maxSum") // 6
    }
}

fun main() {
    val demo = ArrayDemo()

    println("=== Creating Arrays ===")
    demo.creatingArrays()

    println("\n=== Properties & Functions ===")
    demo.propertiesAndFunctions()

    println("\n=== Filling Arrays ===")
    demo.fillingArrays()

    println("\n=== Sorting ===")
    demo.sortingDemo()

    println("\n=== 2D Arrays ===")
    demo.twoDArrayDemo()

    println("\n=== Equality Gotcha ===")
    demo.equalityDemo()

    println("\n=== String / CharArray ===")
    demo.stringCharArrayDemo()

    println("\n=== fold & reduce ===")
    demo.foldReduceDemo()

    println("\n=== Binary Search ===")
    demo.binarySearchDemo()

    println("\n=== Destructuring ===")
    demo.destructuringDemo()

    println("\n=== Interview Snippets ===")
    demo.interviewSnippets()
}
