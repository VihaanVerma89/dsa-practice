//package com.example.lib.topics.backtracking
//
//
//fun generateParenthesis(n: Int): List<String> {
//    val ans = ArrayList<String>()
//    backtrack(ans, "", 0, 0, n)
//    return ans
//}
//
//fun backtrack(ans: HashMap<Int, List<String>>, cur: String, open: Char, close: ArrayList<String>, max: ArrayList<String>) {
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
//        backtrack(ans, "$cur(", open + 1, close, max);
//    }
//    println("before close check")
//    println("\ncur: $cur, open: $open, close: $close, max: $max")
//    if (close < open) {
//
//        println("input close: $cur")
//        backtrack(ans, "$cur)", open, close + 1, max);
//    }
//}
//
//fun main() {
//
//
//    val n = 3
//    val generateParenthesis = generateParenthesis(3)
//    val joinToString = generateParenthesis.joinToString(",")
//    println(joinToString)
//}