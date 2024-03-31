package com.example.lib.leetcode.backtrack1


class permutations {

    // 1st time
//    fun permute1(nums: IntArray): List<List<Int>>? {
//        val ans: MutableList<List<Int>> = ArrayList()
//        backtrack11(ArrayList(), ans, nums)
//        return ans
//    }
//
//    fun backtrack11(curr: MutableList<Int>, ans: MutableList<List<Int>>, nums: IntArray) {
//        if (curr.size == nums.size) {
//            ans.add(ArrayList(curr))
//            return
//        }
//        for (num in nums) {
//            if (!curr.contains(num)) {
//                curr.add(num)
//                backtrack1(curr, ans, nums)
//                curr.removeAt(curr.size - 1)
//            }
//        }
//    }

    // 2nd time
//    fun permute(input: IntArray): ArrayList<ArrayList<Int>> {
//        val visitedList = arrayListOf<Int>()
//        val ansList = arrayListOf<ArrayList<Int>>()
//        backtrack1(input, visitedList, ansList)
//        return ansList
//    }
//
//    fun backtrack1(
//        input: IntArray,
//        visitedList: ArrayList<Int>,
//        ansList: ArrayList<ArrayList<Int>>
//    ) {
//
//        // base condition
//        if (visitedList.size == input.size) {
//            // we have ans
//            ansList.add(ArrayList(visitedList))
//            return
//        }
//
//
//        for (num in input) {
//            if (visitedList.contains(num).not()) {
//                visitedList.add(num)
//                backtrack1(input, visitedList, ansList)
//                visitedList.removeAt(visitedList.size - 1)
//            }
//        }
//
//    }

    // 3rd time
//    fun permute(input: IntArray): ArrayList<ArrayList<Int>> {
//        val output = arrayListOf<ArrayList<Int>>()
//        val tempList = arrayListOf<Int>()
//        backtrack1(input, tempList,output)
//        return output
//    }
//
//    fun backtrack1(input: IntArray, tempList: ArrayList<Int>, output: ArrayList<ArrayList<Int>>) {
//
//        // base condition
//        if (tempList.size == input.size) {
//            output.add(ArrayList(tempList))
//            return
//        }
//        // logic
//        for (i in input) {
//            if (tempList.contains(i).not()) {
//                tempList.add(i)
//                backtrack1(input, tempList, output)
//                tempList.removeLast()
//            }
//        }
//    }

    // 4th time
    fun permute(input: IntArray): ArrayList<ArrayList<Int>> {
        val ansList = arrayListOf<ArrayList<Int>>()
        val tempList = arrayListOf<Int>()
        btrack(input, tempList, ansList)
        return ansList
    }

    fun btrack(input: IntArray, tempList: ArrayList<Int>, ansList: ArrayList<ArrayList<Int>>) {

        // base condition
        if(tempList.size==input.size)
        {
            ansList.add(ArrayList(tempList))
            return
        }

        // traversal
        for (i in input) {
            if(tempList.contains(i).not())
            {
                // forward
                tempList.add(i)
                // deeper
                btrack(input, tempList,ansList)
                // reverse
                tempList.removeLast()
            }
        }
    }


}

fun main() {
    val result = permutations().permute(intArrayOf(1, 2, 3))
    println(result)
    println("size : ${result.size}")
}