package com.example.lib.leetcode.backtrack


class combinationSum {


    fun backtrack(
        candidates: IntArray,
        target: Int,
        start: Int,
        sum: Int,
        tempList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (sum == target) {
            ansList.add(ArrayList(tempList))
            return
        } else if (sum > target) {
            return
        }

        // traversal
        for (i in start until candidates.size) {
            tempList.add(candidates[i])
            backtrack(candidates, target, i , sum + candidates[i], tempList, ansList)
            tempList.removeAt(tempList.size - 1)
        }


    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val tempList = arrayListOf<Int>()
        val ansList = arrayListOf<ArrayList<Int>>()
        backtrack(candidates, target, 0, 0, tempList, ansList)
        return ansList
    }

}


fun main() {
    val input = intArrayOf(2, 3, 6, 7)
    val target =7
    val result = combinationSum().combinationSum(input, target)
    val resultString = result.joinToString("")
    println("result : $resultString")

}
