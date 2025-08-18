import java.util.Stack

class Solution {


    fun makeGood(s: String): String {

        val dq = ArrayDeque<Char>()


        for (c in s) {

            val peek = dq.lastOrNull()

            if (peek != c && (peek?.uppercaseChar() == c || peek?.lowercaseChar() == c)) {
                dq.removeLast()
            } else {
                dq.addLast(c)
            }

        }

        return dq.joinToString("")
    }

}
