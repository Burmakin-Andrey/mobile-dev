
import kotlin.math.*
fun main() {

        var k = readLine()!!.toInt()
        var n = arrayListOf<Int>()
        var m = arrayListOf<Int>()
        for( i  in 1..k){
                var arr = readln().split(" ").map(String::toInt)
                n.add(arr[0])
                m.add(arr[1])
        }


        for ( c in 0..k-1) {

                var arr = Array(n[c], { Array(m[c], { 0 }) })


                var a = n[c] * m[c]
                for (i in 0..max(n[c], m[c]) + max(n[c], m[c])) {
                        for (j in 0..i) {
                                if (i - j < n[c] && j < m[c] && arr[i - j][j] == 0) {
                                        arr[i - j][j] = a
                                        a--
                                }
                        }
                }

                for ( i in arr){
                        for (j in i){
                                print(j.toString() + " ")
                        }
                        println()
                }
        }




}