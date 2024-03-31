package com.example.lib.topics.backtrack1ing


fun allSubsets(pos: Int, len: Int, subset: Array<Int?>) {

    if (pos == 8) {
        print(subset.contentToString())
        return
    }
    subset[len] = S[pos]
    allSubsets(pos + 1, len + 1, subset)
    allSubsets(pos + 1, len, subset)

}

val S = intArrayOf(1, 2, 3)
fun main() {
    println(S.contentToString())

    val subset = arrayOfNulls<Int>(8)
    allSubsets(0, 0, subset)
}