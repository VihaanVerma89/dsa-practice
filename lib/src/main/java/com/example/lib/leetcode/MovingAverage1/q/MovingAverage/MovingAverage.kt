import java.util.LinkedList

class MovingAverage(val size: Int) {


    val q = LinkedList<Int>()
    var sum = 0

    fun next(`val`: Int): Double {

        var avg: Double = 0.0
        if (q.size < size) {
            q.offer(`val`)
            sum += `val`
        } else if (q.size == size) {
            // remove element at start
            val value = q.pop()
            sum -= value
            q.offer(`val`)
            sum+=`val`
        }
        avg = sum / q.size.toDouble()

        return avg
    }

}