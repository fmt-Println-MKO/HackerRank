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

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {

    var result = 0L
    for (c in s) {
        if (c == 'a') {
            result++
        }
    }
    val multi = n / s.length
    val mod: Int = (n % s.length).toInt()

    result *= multi
    if (mod > 0) {
        for (c in s.substring(0 until mod)) {
            if (c == 'a') {
                result++
            }
        }
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}