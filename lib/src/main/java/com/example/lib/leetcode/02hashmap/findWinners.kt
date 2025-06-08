package com.example.lib.leetcode.`02hashmap`

class findWinners {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winnerMap = hashMapOf<Int, Int>()
        val loserMap = hashMapOf<Int, Int>()

        var winner = -1
        var loser = -1

        // create winners -> freq map
        // create losers -> freq map
        for (match in matches) {
            winner = match[0]
            loser = match[1]

            if (winnerMap.contains(winner)) {
                winnerMap[winner] = winnerMap[winner]!!.plus(1)
            } else {
                winnerMap[winner] = 1
            }

            if (loserMap.contains(loser)) {
                loserMap[loser] = loserMap[loser]!!.plus(1)
            } else {
                loserMap[loser] = 1
            }
        }


        // iterate winners and check in loser if they lost any

        var r = arrayListOf<ArrayList<Int>>(arrayListOf(), arrayListOf())

        for (entry in winnerMap.entries) {
            if (loserMap.contains(entry.key)) {
                // has lost matches
            } else {
                // has only won matches
                r[0].add(entry.key)
            }
        }

        for (entry in loserMap.entries) {
            if (entry.value == 1) {
                // has lost only one match
                r[1].add(entry.key)
            }
        }

        r[0].sort()
        r[1].sort()
        // iterate loser and find only 1 lost match

        return r
    }
}

fun main() {
    var instance = findWinners()
    val input = Array<IntArray>(2) {
        intArrayOf(1, 2)
    }

    instance.findWinners(input)
}
