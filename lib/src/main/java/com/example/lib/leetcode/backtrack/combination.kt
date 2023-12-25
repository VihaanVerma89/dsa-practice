package com.example.lib.leetcode.backtrack

//https://leetcode.com/problems/combinations/
class combination {

    fun combine(n: Int, k: Int): List<List<Int>> {

        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        backtrack(n, k, 1, tempList, ansList)
        return ansList
    }

    fun backtrack(
        n: Int,
        k: Int,
        j: Int,
        tempList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (tempList.size == k) {
            ansList.add(ArrayList(tempList))
            return
        }


        for (i in j..n) {
            tempList.add(i)
            backtrack(n, k, i + 1, tempList, ansList)
            // resume
            tempList.removeAt(tempList.size - 1)
        }

    }
}


fun main() {
    val result = combination().combine(4, 2)
    println(result)
}