package com.example.lib.leetcode.`01arrays`

class firstUniqChar {

    fun firstUniqChar(s: String): Int {

        val hmap = hashMapOf<Char, Int>()

        for (c in s) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1)
        }

        for( iv in s.withIndex())
        {
            val value = hmap.get(iv.value)
            if(value ==1){
                return iv.index
            }
        }

        return -1

    }
}