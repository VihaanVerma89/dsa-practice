package com.example.lib.topics.recursion


fun printPascalTriangle(r: Int) {
    for (ri in 0..r) {
        for (cj in 0..ri) {
            val valueAt = getValueAt(ri, cj)
            print("$valueAt ")
        }
        println()
    }
}

fun getValueAt(r: Int, c: Int): Int {

    if (r == 0 && c == 0) {
        return 1
    } else if (c == 0) {
        return 1
    } else if (c == r) {
        return 1
    }

    return getValueAt(r - 1, c - 1) + getValueAt(r - 1, c)
}

fun main() {
    printPascalTriangle(5)
}