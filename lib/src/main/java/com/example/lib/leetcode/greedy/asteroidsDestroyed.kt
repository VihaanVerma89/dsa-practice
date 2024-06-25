package com.example.lib.leetcode.greedy

class asteroidsDestroyed {

    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {

        var r: Long = mass.toLong()
        asteroids.sort()
        for (asteroid in asteroids) {
            if (r < asteroid) {
                return false
            } else {
                r += asteroid
            }
        }

        return true
    }

}

fun main() {

}