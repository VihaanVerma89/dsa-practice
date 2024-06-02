package com.example.lib.leetcode.backtrack

import kotlin.collections.ArrayList

class combinationSum3 {

    val ansList = arrayListOf<ArrayList<Int>>()
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val tempList = ArrayList<Int>()
        backtrack(k, n, tempList, ansList)
        println("ans list : $ansList")
        return ansList
    }

    fun checkDuplicate(tempHashSet: HashSet<Int>): Boolean {
        for (hashSet in ansHashSet) {
            if (tempHashSet == hashSet) {
                return true
            }
        }
        return false
    }

    //    val listHashMap = arrayListOf(HashMap<Int, Int>())
    val ansHashSet = hashSetOf(hashSetOf<Int>())
    val j = 0
    fun backtrack(k: Int, n: Int, tempList: ArrayList<Int>, ansList: ArrayList<ArrayList<Int>>) {

        // term condition
        if (tempList.size == k) {
            // check the sum
            var sum = 0
            for (i in tempList) {
                sum += i
            }

            if (sum == n) {
                println(tempList)
                // valid list found
                println("valid list found : $tempList")
                val tempHashSet = hashSetOf<Int>()
                for (k in tempList) {
                    tempHashSet.add(k)
                }

                if (ansHashSet.size == 0) {
                    ansHashSet.add(tempHashSet)
                    ansList.add(ArrayList(tempList))
                } else {
                    // check for duplicate & add to ansList
                    if (checkDuplicate(tempHashSet)) {
                        // duplicate found ignore
                    } else {
                        ansHashSet.add(tempHashSet)
                        ansList.add(ArrayList(tempList))
                    }
                }
            }
            return
        }

        println("tempList $tempList")

        // traversal

        for (i in 1..9) {
            if (tempList.contains(i).not()) {
                tempList.add(i)
                backtrack(k, n, tempList, ansList)
                tempList.remove(i)
            }
        }
    }

}

fun main() {
    combinationSum3().combinationSum3(3, 7)


}