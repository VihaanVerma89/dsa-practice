package com.example.lib.leetcode.greedy


class numRescueBoats {

    // one boat two ppl only
    // total TC - o ( n log n )  + o ( n )
    // = o ( n log n )
    // SC - o ( n )
    fun numRescueBoats(people: IntArray, limit: Int): Int {

        if (people.isEmpty()) {
            return 0
        }
        // TC - o ( n log n )
        people.sort()
        var i = 0
        var j = people.size - 1

        var ans = 0
        // TC - o ( n )
        while (i <= j) {
            if (i == j) {
                // last person left
                ans++
                i++
                j--
            } else {
                val sum = people[i] + people[j]
                if (sum <= limit) {
                    ans++
                    i++
                    j--
                } else {
                    // use one boat to send heavy person
                    ans++
                    j--
                }
            }
        }
        return ans
    }


}