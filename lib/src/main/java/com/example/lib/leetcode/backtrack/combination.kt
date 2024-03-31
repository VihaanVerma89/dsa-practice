package com.example.lib.leetcode.backtrack1

//https://leetcode.com/problems/combinations/
class combination {

    fun combine1(n: Int, k: Int): List<List<Int>> {

        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        backtrack1(n, k, 1, tempList, ansList)
        return ansList
    }

    fun backtrack1(
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
            backtrack1(n, k, i + 1, tempList, ansList)
            // resume
            tempList.removeAt(tempList.size - 1)
        }

    }


    fun combine(n: Int, k: Int): List<List<Int>> {

        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        btrack(n, k, 1, tempList, ansList)
        return ansList
    }

    fun btrack(
        n: Int,
        k: Int,
        index: Int,
        tempList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (tempList.size == k) {
            ansList.add(ArrayList(tempList))
            return
        }

        // traversal
        for (i in index .. n) {
            if (tempList.contains(i).not()) {
                tempList.add(i)
                btrack(n, k, i+ 1, tempList, ansList)
                tempList.removeLast()
            } else {
                // duplicate
            }
        }
    }

}


fun main() {
    val result = combination().combine1(4, 2)
    println(result)
}