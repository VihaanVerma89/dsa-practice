package com.example.lib.leetcode.backtrack


class permutations {

//    fun permute1(nums: IntArray): List<List<Int>>? {
//        val ans: MutableList<List<Int>> = ArrayList()
//        backtrack1(ArrayList(), ans, nums)
//        return ans
//    }
//
//    fun backtrack1(curr: MutableList<Int>, ans: MutableList<List<Int>>, nums: IntArray) {
//        if (curr.size == nums.size) {
//            ans.add(ArrayList(curr))
//            return
//        }
//        for (num in nums) {
//            if (!curr.contains(num)) {
//                curr.add(num)
//                backtrack(curr, ans, nums)
//                curr.removeAt(curr.size - 1)
//            }
//        }
//    }

    fun permute(input: IntArray): ArrayList<ArrayList<Int>> {
        val visitedList = arrayListOf<Int>()
        val ansList = arrayListOf<ArrayList<Int>>()
        backtrack(input, visitedList, ansList)
        return ansList
    }

    fun backtrack(
        input: IntArray,
        visitedList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (visitedList.size == input.size) {
            // we have ans
            ansList.add(ArrayList(visitedList))
            return
        }


        for (num in input) {
            if (visitedList.contains(num).not()) {
                visitedList.add(num)
                backtrack(input, visitedList, ansList)
                visitedList.removeAt(visitedList.size - 1)
            }
        }

    }
}

fun main() {
    val result = permutations().permute(intArrayOf(1, 2, 3))
    println(result)
}