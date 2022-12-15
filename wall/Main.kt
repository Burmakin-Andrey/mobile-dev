import java.io.File
import kotlin.math.max
import kotlin.math.min

fun doOffsetArr(arr: IntArray): IntArray {
    val first = arr[0]
    return arr.mapIndexed { idx, _ ->
        if (idx == arr.size - 1) first else
            arr[idx + 1]
    }.toIntArray()
}

fun process(n: Int, m: Int, k: Int) : Array<IntArray>{
    val maxSide = max(n, m)
    val minSide = min(n, m)
    val matrix: Array<IntArray>
            = Array(minSide) { IntArray(maxSide) { it + 1 } }
    if (k < maxSide) {
        println("NO: $n $m $k")
        return matrix
    }

    for (i in 1 until matrix.size) {
        matrix[i] = doOffsetArr(matrix[i - 1])
    }
    println("YES $n $m $k")
    val newMatrix: Array<IntArray>
            = Array(maxSide) { IntArray(minSide) }
    if (n < m) {
        return matrix
    } else {
        for (i in 0 until n) {
            for (j in 0 until m) {
                newMatrix[i][j] = matrix[j][i]
            }
        }
    }
    return newMatrix
}
fun main() {
    val lines = arrayListOf<String>()
    File("./src/main/kotlin/colors.txt").forEachLine { line ->
        lines.add(line)
    }

    val numbTests = lines[0].toInt()
    println(numbTests)
    var current_line = 1
    for (i in 1..numbTests){
        val (nS, mS, kS) = lines[current_line].split(" ")
        var matrix = process(nS.toInt(), mS.toInt(), kS.toInt())
        for (i in 0 until nS.toInt()) {
            current_line++
            var newLines = lines[current_line].split(" ")
            for (j in 0 until mS.toInt()) {
                if(newLines[j].toInt() == 0)
                    matrix[i][j] = 0
            }
        }
        current_line++

        for (element in matrix) {
            println(element.contentToString())
        }

    }


}