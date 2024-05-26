package com.example.lib.leetcode.backtrack1


//fun generateParenthesis1(n: Int): List<String> {
//    val ans = ArrayList<String>()
//    backtrack1(ans, "", 0, 0, n)
//    return ans
//}
//
//fun backtrack1(
//    ans: ArrayList<String>,
//    cur: String,
//    open: Char,
//    close: ArrayList<String>,
//    max: ArrayList<String>
//) {
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

// 16th may 2024
fun generateParenthesis(n: Int): List<String> {
    val ansList = arrayListOf<String>()
    backtrack(n, "",0, 0, ansList)
    return ansList
}


var tempString: String = ""

fun backtrack(
    n: Int,
    tempResult: String,
    openCount: Int,
    closeCount: Int,
    ansList: ArrayList<String>
) {
    // base condition
    if (tempResult.length == n * 2) {
        println("ans found $tempResult")
        ansList.add(tempResult+ "")
        return
    }


    if (openCount > n) {
        // can't add more (
        return
    }
    if (closeCount > n) {
        // can't add more )
        return
    }


    // traversal

//    for (i in 0 until 2) {
        // logic
        if (openCount < n) {
            //foward
            backtrack(n, "$tempResult(", openCount + 1, closeCount, ansList)
            //backgward
            tempResult.dropLast(0)
        }
        if (closeCount < n && closeCount < openCount) {
            backtrack(n, "$tempResult)", openCount, closeCount + 1, ansList)
            tempResult.dropLast(0)
        }
//    }


}

fun main() {
    val n = 3
    val generateParenthesis = generateParenthesis(3)
    val joinToString = generateParenthesis.joinToString(",")
    println("final result ---> $joinToString")
}

