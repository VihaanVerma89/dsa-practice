package com.example.lib.topics.recursion

fun printReverseDec(s: String, r: String, i: Int) {
    if (i == -1) {
        println("Reverse : $r")
        return
    }
    val plus = r.plus(s[i])
    printReverseDec(s, plus, i - 1)
}

fun printReverseInc(s: String, i: Int) {
    if (i == s.length) {
        return
    }

    printReverseInc(s, i + 1)
    print(s[i])
}

fun reverseString(s: CharArray, start: Int, end: Int): Unit {
    if (start >= end) {
        return
    }

    swap(s, start, end)
    reverseString(s, start + 1, end - 1)
}

fun swap(s: CharArray, from: Int, to: Int) {
    val temp = s[to]
    s[to] = s[from]
    s[from] = temp
}

@ExperimentalStdlibApi
fun main() {
    val s = "vihaan"
    val r = ""
//    printReverseDec(s, r, s.length - 1)
//    printReverseInc(s, 0)

//    val c = charArrayOf('h', 'e', 'l', 'l', 'o')
    val c = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    reverseString(c, 0, c.size - 1)
    println(c.concatToString())
}

