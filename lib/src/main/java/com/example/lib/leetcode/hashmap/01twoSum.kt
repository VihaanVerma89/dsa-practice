package com.example.lib.leetcode.hashmap

class `01twoSum` {

    fun twoSum(nums: IntArray, target: Int) : IntArray{

        val map = hashMapOf<Int, Int>()
        val result = IntArray(2){ -1 }

        for( iv in nums.withIndex() ) {
            val value = target - iv.value
            if( map.contains(value)){
                result[0] = map.getOrDefault(value, -1)
                result[1] = iv.index
            }
            else{
                map[ iv.value ] = iv.index
            }

        }

        return result

    }
}