//class Timeutils {
//
//    fun getValidTimeCount( s : String ) : Int {
//
//        if ( s.length !=5 || s[2] != ':' ){
//            // invalid string
//            return -1
//        }
//
//
//        val h1 = s [ 0 ]
//        val h2 = s [ 1 ]
//        val m1 = s [ 3 ]
//        val m2 = s [ 4 ]
//
//        var result = 1
//
//        val qm = '?'
//
//        // hours
//
//        if( h1 == qm && h2 == qm ) {
//            result *= 24
//        }
//        else if ( h1 == qm ) {
//
//            // what is h2 ?
//            if ( h2 in '0' .. '3' ) {
//                result *= 3 // 0, 1, 2
//            }
//            else if( h2 in '4' .. '9' ) {
//                result *= 2 // 0, 1
//            }
//        }
//        else if ( h2 == qm ) {
//            // what is in h1 ?
//            if( h1 in '0' .. '1' ) {
//
//                result *= 10
//            }
//            else {
//                result *= 4
//            }
//
//        }
//        else {
//            val h = (h1 - '0') * 10 + (h2 - '0')
//            if( h !in 0..23 ) return -1
//        }
//
//
//
//        // minutes
//
//
//        if( m1 == qm && m2 == qm ) {
//            result *= 60
//        }
//        else if( m1 == qm ) {
//            // m1 0 .. 5
//            result * = 6
//        }
//        else if( m2 == qm ) {
//            result *= 10
//        }
//        else {
//
//            val m = m1 + m2
//            if( m !in 0..59 ) return -1
//        }
//
//
//
//        return result
//    }
//
//
//
//}
