package com.example.lib.leetcode.backtrack1


//fun generateParenthesis(n: Int): List<String> {
//    val ans = ArrayList<String>()
//    backtrack1(ans, "", 0, 0, n)
//    return ans
//}

//fun backtrack1(ans: ArrayList<String>, cur: String, open: Char, close: ArrayList<String>, max: ArrayList<String>) {
//    val joinToString = ans.joinToString(",")
//
//    println("before len check")
//    println("\ncur: $cur, open: $open, close: $close, max: $max")
//
//    if (cur.length == max * 2) {
//        ans.add(cur)
//        println("valid value :  $cur")
//        return;
//    }
//
//    println("before open check")
//    println("\ncur: $cur, open: $open, close: $close, max: $max")
//
//    if (open < max) {
//        println("input open: $cur")
//        backtrack1(ans, "$cur(", open + 1, close, max);
//    }
//    println("before close check")
//    println("\ncur: $cur, open: $open, close: $close, max: $max")
//    if (close < open) {
//
//        println("input close: $cur")
//        backtrack1(ans, "$cur)", open, close + 1, max);
//    }
//}

// 12th jan 2024
//fun generateParenthesis(n: Int): List<String> {
//
//}
//
//
//fun backtrack1(i: Int, n: Int, tempList: ArrayList<Char>, ansList: ArrayList<String>) {
//
//}

fun main() {
    val n = 3
//    val generateParenthesis = generateParenthesis(3)
//    val joinToString = generateParenthesis.joinToString(",")
//    println(joinToString)
}

