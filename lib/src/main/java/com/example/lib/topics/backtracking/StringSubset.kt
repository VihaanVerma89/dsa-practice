package com.example.lib.topics.backtracking


fun printSubSets(str: String, index: Int, depth: Int, subset: String) {

    //base condition
    if (depth == str.length) {
        println(subset)
        return
    }

    val get = str[depth]
    printSubSets(str, index + 1, depth + 1, subset+get)
    printSubSets(str, index, depth+1 , subset)
}

fun main() {
    val str = "123"
    printSubSets(str, 0, 0, "")
//    test()
}

fun test(){
    val str = "123"
    val temp = ""
    val get = str.get(1)
    println(temp+get)
}
