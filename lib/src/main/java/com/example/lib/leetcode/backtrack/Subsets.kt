package com.example.lib.leetcode.backtrack1


class Subsets {

//    fun subsets1(nums: IntArray): List<List<Int>>? {
//        val input = intArrayOf(1, 2, 3)
//        val ans = arrayListOf<ArrayList<Int>>()
//        val currList = arrayListOf<Int>()
//        backtrack11(input,0, currList, ans)
//        return ans
//    }
//
//
//    fun backtrack11(
//        input: IntArray,
//        start: Int,
//        currList: ArrayList<Int>,
//        ans: ArrayList<ArrayList<Int>>
//    ) {
//
//        // base condition
//        if (start > input.size) {
//            return
//        }
//
//        // collect
//        ans.add(ArrayList(currList))
//
//        for (i in start until input.size) {
//            currList.add(input[i])
//            backtrack11(input, i + 1, currList, ans)
//            // travel back in stack
//            currList.removeAt(currList.size - 1)
//        }
//
//    }


    fun subsets(nums: IntArray): List<List<Int>> {
        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        backtrack1(nums, 0, tempList, ansList)
        return ansList
    }

    fun backtrack1(
        nums: IntArray,
        index: Int,
        tempList: ArrayList<Int>,
        ansList: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (tempList.size == nums.size) {
            ansList.add(ArrayList(tempList))
            return
        }

        ansList.add(ArrayList(tempList))

        // logic
        for (i in index until nums.size) {
            if (tempList.contains(nums[i]).not()) {
                tempList.add(nums[i]) // down
                backtrack1(nums, i + 1, tempList, ansList)
                tempList.remove(nums[i])
            } else {
                // duplicate
            }
        }

    }


}

fun main() {
    Subsets().subsets(intArrayOf(1, 2, 3))
//    Subsets().limitedbacktrack1(intArrayOf(1, 2, 3), 0)
}