import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the stringSimilarity function below.
fun stringSimilarity(s: String): Long {

    var result: Long = 0L
//    var result: Long = s.length.toLong();

//    var j = 1;
//
//    val l = s.length
//
//    while (j < l) {
//        var i = 0
//        var k = j
//        while (k < l) {
//            if (s[k] == s[i]) {
//                result++
//                i++
//                k++
//            } else {
//                break
//            }
//        }
//        j++
//    }

//    var end = l-1

//    while (end > 0) {
//        if (s[0]==s[end]) {
//            result++
//        }
//        end--
//    }

//    var i = 0
//    var k = j
//    while (j < l) {
//        if (k < l && s[k] == s[i]) {
//            result++
//            i++
//            k++
//        } else {
//            i = 0
//            j++
//            k = j
//        }
//    }

    //zFunction
    val n = s.length
    val z = IntArray(n)
    var R = 0
    var L = 0

    for (i in 1 until n) {
        z[i] = 0
        if (R > i) {
            z[i] = Math.min(R - i, z[i - L])
        }
        while (i + z[i] < n && s[i + z[i]] == s[z[i]]) {
            z[i]++
        }
        if (i + z[i] > R) {
            L = i
            R = i + z[i]
        }
    }

    z[0] = n
    //zFunction
    for (i in 0 until z.size) {
        result += z[i]
    }
    return result;
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()
    val start1 = System.currentTimeMillis()
    for (tItr in 1..t) {
        val s = scan.nextLine()


        val start = System.currentTimeMillis()
        val result = stringSimilarity(s)
        val end = System.currentTimeMillis()

        println("$result length: \t ${s.length} \t in: ${end - start}")
    }
    val end1 = System.currentTimeMillis()
    println("result in: ${end1 - start1}")
}
